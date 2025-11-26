package com.programmingcave.emergency.controllers;

import com.programmingcave.emergency.dtos.notificacao.NotificacaoResponseDTO;
import com.programmingcave.emergency.services.NotificacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {

    private final NotificacaoService notificacaoService;

    public NotificacaoController(NotificacaoService notificacaoService) {
        this.notificacaoService = notificacaoService;
    }

    @GetMapping
    public ResponseEntity<List<NotificacaoResponseDTO>> listarTodas() {
        return ResponseEntity.ok(notificacaoService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacaoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(notificacaoService.buscarPorId(id));
    }

    @GetMapping("/emergencia/{emergenciaId}")
    public ResponseEntity<List<NotificacaoResponseDTO>> listarPorEmergencia(@PathVariable Long emergenciaId) {
        return ResponseEntity.ok(notificacaoService.listarPorEmergencia(emergenciaId));
    }
}