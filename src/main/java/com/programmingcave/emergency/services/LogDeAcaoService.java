package com.programmingcave.emergency.services;

import com.programmingcave.emergency.dtos.logdeacao.LogDeAcaoResponseDTO;
import com.programmingcave.emergency.entities.LogDeAcao;
import com.programmingcave.emergency.repositories.LogDeAcaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogDeAcaoService {

    private final LogDeAcaoRepository repository;

    public LogDeAcaoService(LogDeAcaoRepository repository) {
        this.repository = repository;
    }

    public void registrar(String usuario, String acao) {
        LogDeAcao log = new LogDeAcao();
        log.setUsuario(usuario);
        log.setAcao(acao);
        log.setDataHora(LocalDateTime.now());

        repository.save(log);
    }

    public List<LogDeAcaoResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(l -> new LogDeAcaoResponseDTO(
                        l.getId(),
                        l.getUsuario(),
                        l.getAcao(),
                        l.getDataHora()
                ))
                .toList();
    }

    public LogDeAcaoResponseDTO buscarPorId(Long id) {
        LogDeAcao log = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Log não encontrado"));

        return new LogDeAcaoResponseDTO(
                log.getId(),
                log.getUsuario(),
                log.getAcao(),
                log.getDataHora()
        );
    }

}