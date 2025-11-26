package com.programmingcave.emergency.services;

import com.programmingcave.emergency.dtos.atendimento.AtendimentoResponseDTO;
import com.programmingcave.emergency.dtos.atendimento.RegistrarAtendimentoDTO;
import com.programmingcave.emergency.entities.Atendimento;
import com.programmingcave.emergency.entities.Emergencia;
import com.programmingcave.emergency.repositories.AtendimentoRepository;
import com.programmingcave.emergency.repositories.EmergenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;
    private final EmergenciaRepository emergenciaRepository;
    private final LogDeAcaoService logDeAcaoService;

    public AtendimentoService(AtendimentoRepository repository,
                              EmergenciaRepository emergenciaRepository,
                              LogDeAcaoService logDeAcaoService) {
        this.atendimentoRepository = repository;
        this.emergenciaRepository = emergenciaRepository;
        this.logDeAcaoService = logDeAcaoService;
    }

    public AtendimentoResponseDTO registrarAtendimento(Long emergenciaId, RegistrarAtendimentoDTO dto) {

        Emergencia emergencia = emergenciaRepository.findById(emergenciaId)
                .orElseThrow(() -> new RuntimeException("Emergência não encontrada"));

        emergencia.setStatus("FINALIZADA");
        emergenciaRepository.save(emergencia);

        Atendimento atendimento = new Atendimento();
        atendimento.setDecisao(dto.decisao());
        atendimento.setObservacoes(dto.observacoes());
        atendimento.setEmergencia(emergencia);

        Atendimento salvo = atendimentoRepository.save(atendimento);

        logDeAcaoService.registrar(
                "ENFERMARIA",
                "Registrou atendimento para emergência ID " + emergenciaId
                        + " e finalizou a emergência."
        );

        return toDTO(salvo);
    }

    public AtendimentoResponseDTO buscarDTO(Long id) {
        Atendimento at = atendimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atendimento não encontrado"));
        return toDTO(at);
    }

    public AtendimentoResponseDTO toDTO(Atendimento at) {
        return new AtendimentoResponseDTO(
                at.getId(),
                at.getDecisao(),
                at.getObservacoes(),
                at.getEmergencia().getId()
        );
    }

    public List<AtendimentoResponseDTO> listarTodos() {
        return atendimentoRepository.findAll().stream()
                .map(a -> new AtendimentoResponseDTO(
                        a.getId(),
                        a.getDecisao(),
                        a.getObservacoes(),
                        a.getEmergencia().getId()
                ))
                .toList();
    }
}
