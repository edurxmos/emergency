package com.programmingcave.emergency.dtos.emergencia;

public record EmergenciaResponseDTO(
        Long id,
        String dataHora,
        String status,
        String descricao,
        Long alunoId
) {}