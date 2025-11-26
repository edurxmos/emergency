package com.programmingcave.emergency.controllers;

import com.programmingcave.emergency.dtos.emergencia.CriarEmergenciaDTO;
import com.programmingcave.emergency.dtos.emergencia.EmergenciaResponseDTO;
import com.programmingcave.emergency.entities.Emergencia;
import com.programmingcave.emergency.services.EmergenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emergencias")
public class EmergenciaController {

    private final EmergenciaService emergenciaService;

    public EmergenciaController(EmergenciaService emergenciaService) {
        this.emergenciaService = emergenciaService;
    }

    @PostMapping
    public ResponseEntity<EmergenciaResponseDTO> criarEmergencia(@RequestBody CriarEmergenciaDTO dto) {
        Emergencia emergencia = emergenciaService.criarEmergencia(dto);
        return ResponseEntity.ok(emergenciaService.toDTO(emergencia));
    }

    @GetMapping
    public ResponseEntity<List<EmergenciaResponseDTO>> listar() {
        return ResponseEntity.ok(emergenciaService.listarDTO());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmergenciaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(emergenciaService.buscarDTO(id));
    }
}