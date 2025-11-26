package com.programmingcave.emergency.services;

import com.programmingcave.emergency.dtos.emergencia.CriarEmergenciaDTO;
import com.programmingcave.emergency.dtos.emergencia.EmergenciaResponseDTO;
import com.programmingcave.emergency.entities.Aluno;
import com.programmingcave.emergency.entities.Emergencia;
import com.programmingcave.emergency.entities.LogDeAcao;
import com.programmingcave.emergency.enums.TipoNotificacao;
import com.programmingcave.emergency.repositories.AlunoRepository;
import com.programmingcave.emergency.repositories.EmergenciaRepository;
import com.programmingcave.emergency.repositories.LogDeAcaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EmergenciaService {

    private final EmergenciaRepository repository;
    private final AlunoRepository alunoRepository;
    private final LogDeAcaoService logService;
    private final NotificacaoService notificacaoService;
    private final ModelMapper mapper;

    public EmergenciaService(
            EmergenciaRepository repository,
            AlunoRepository alunoRepository,
            LogDeAcaoService logService,
            NotificacaoService notificacaoService,
            ModelMapper mapper
    ) {
        this.repository = repository;
        this.alunoRepository = alunoRepository;
        this.logService = logService;
        this.notificacaoService = notificacaoService;
        this.mapper = mapper;
    }

    public Emergencia criarEmergencia(CriarEmergenciaDTO dto) {

        Aluno aluno = alunoRepository.findById(dto.alunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Emergencia emergencia = new Emergencia();
        emergencia.setAluno(aluno);
        emergencia.setDescricao(dto.descricao());
        emergencia.setStatus("ABERTA");
        emergencia.setDataHora(LocalDateTime.now());

        Emergencia salva = repository.save(emergencia);

        notificacaoService.criarNotificacao(
                salva,
                TipoNotificacao.ENFERMARIA,
                "Aluno " + aluno.getNome() + " está em emergência. Verificar imediatamente."
        );

        notificacaoService.criarNotificacao(
                salva,
                TipoNotificacao.RESPONSAVEIS,
                "Seu filho "+ aluno.getNome() +" está em situação de emergência."
        );


        logService.registrar("Sistema", "Criou emergência ID=" + salva.getId());

        return salva;
    }

    public List<Emergencia> listar() {
        return repository.findAll();
    }

    public Emergencia buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emergência não encontrada"));
    }

    public EmergenciaResponseDTO toDTO(Emergencia e) {
        String data = e.getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        return new EmergenciaResponseDTO(
                e.getId(),
                data,
                e.getStatus(),
                e.getDescricao(),
                e.getAluno().getId()
        );
    }

    public List<EmergenciaResponseDTO> listarDTO() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public EmergenciaResponseDTO buscarDTO(Long id) {
        Emergencia e = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emergência não encontrada"));

        return toDTO(e);
    }

}
