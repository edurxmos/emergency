package com.programmingcave.emergency.controllers;

import com.programmingcave.emergency.dtos.logdeacao.LogDeAcaoResponseDTO;
import com.programmingcave.emergency.services.LogDeAcaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogDeAcaoController {

    private final LogDeAcaoService logService;

    public LogDeAcaoController(LogDeAcaoService logService) {
        this.logService = logService;
    }

    @GetMapping
    public ResponseEntity<List<LogDeAcaoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(logService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogDeAcaoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(logService.buscarPorId(id));
    }
}