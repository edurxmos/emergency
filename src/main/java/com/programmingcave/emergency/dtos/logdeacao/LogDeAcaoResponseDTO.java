package com.programmingcave.emergency.dtos.logdeacao;

import java.time.LocalDateTime;

public record LogDeAcaoResponseDTO(
        Long id,
        String usuario,
        String acao,
        LocalDateTime dataHora
) {}