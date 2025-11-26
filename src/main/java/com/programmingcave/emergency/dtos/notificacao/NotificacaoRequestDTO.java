package com.programmingcave.emergency.dtos.notificacao;


import java.time.LocalDateTime;

public record NotificacaoRequestDTO(
        String tipo,
        String mensagem,
        LocalDateTime dataHora,
        Long emergenciaId
) {}