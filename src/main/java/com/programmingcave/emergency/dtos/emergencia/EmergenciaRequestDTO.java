package com.programmingcave.emergency.dtos.emergencia;

import java.time.LocalDateTime;

public record EmergenciaRequestDTO(
        LocalDateTime dataHora,
        String status,
        String descricao,
        Long alunoId
) {}