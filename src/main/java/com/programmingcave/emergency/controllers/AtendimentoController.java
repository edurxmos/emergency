package com.programmingcave.emergency.controllers;

import com.programmingcave.emergency.dtos.atendimento.AtendimentoResponseDTO;
import com.programmingcave.emergency.dtos.atendimento.RegistrarAtendimentoDTO;
import com.programmingcave.emergency.services.AtendimentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {

    private final AtendimentoService atendimentoService;

    public AtendimentoController(AtendimentoService atendimentoService) {
        this.atendimentoService = atendimentoService;
    }

    @PostMapping("/{emergenciaId}")
    public ResponseEntity<AtendimentoResponseDTO> registrarAtendimento(
            @PathVariable Long emergenciaId,
            @RequestBody RegistrarAtendimentoDTO dto
    ) {
        AtendimentoResponseDTO atendimento = atendimentoService.registrarAtendimento(emergenciaId, dto);
        return ResponseEntity.ok(atendimento);
    }

    @GetMapping
    public ResponseEntity<List<AtendimentoResponseDTO>> listarTodos() {
        List<AtendimentoResponseDTO> lista = atendimentoService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtendimentoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(atendimentoService.buscarDTO(id));
    }
}