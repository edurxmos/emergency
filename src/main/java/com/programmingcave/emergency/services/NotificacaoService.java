package com.programmingcave.emergency.services;

import com.programmingcave.emergency.dtos.notificacao.NotificacaoResponseDTO;
import com.programmingcave.emergency.entities.Emergencia;
import com.programmingcave.emergency.entities.Notificacao;
import com.programmingcave.emergency.enums.TipoNotificacao;
import com.programmingcave.emergency.repositories.NotificacaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificacaoService {

    private final NotificacaoRepository notificacaoRepository;

    public NotificacaoService(NotificacaoRepository notificacaoRepository) {
        this.notificacaoRepository = notificacaoRepository;
    }

    public List<NotificacaoResponseDTO> listarTodas() {
        return notificacaoRepository.findAll()
                .stream()
                .map(n -> new NotificacaoResponseDTO(
                        n.getId(),
                        n.getTipo(),
                        n.getMensagem(),
                        n.getDataHora(),
                        n.getEmergencia().getId()
                ))
                .toList();
    }

    public NotificacaoResponseDTO buscarPorId(Long id) {
        Notificacao n = notificacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificação não encontrada"));

        return new NotificacaoResponseDTO(
                n.getId(),
                n.getTipo(),
                n.getMensagem(),
                n.getDataHora(),
                n.getEmergencia().getId()
        );
    }

    public List<NotificacaoResponseDTO> listarPorEmergencia(Long emergenciaId) {
        return notificacaoRepository.findByEmergenciaId(emergenciaId)
                .stream()
                .map(n -> new NotificacaoResponseDTO(
                        n.getId(),
                        n.getTipo(),
                        n.getMensagem(),
                        n.getDataHora(),
                        n.getEmergencia().getId()
                ))
                .toList();
    }

    public void criarNotificacao(Emergencia emergencia, TipoNotificacao tipo, String mensagem) {
        Notificacao notificacao = new Notificacao();
        notificacao.setTipo(tipo.name());
        notificacao.setMensagem(mensagem);
        notificacao.setDataHora(LocalDateTime.now());
        notificacao.setEmergencia(emergencia);

        notificacaoRepository.save(notificacao);
    }
}