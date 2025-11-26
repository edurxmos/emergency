package com.programmingcave.emergency.dtos.notificacao;

import java.time.LocalDateTime;

public record NotificacaoResponseDTO(
        Long id,
        String tipo,
        String mensagem,
        LocalDateTime dataHora,
        Long emergenciaId
) {}