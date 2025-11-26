package com.programmingcave.emergency.dtos.atendimento;

public record AtendimentoRequestDTO(
        String decisao,
        String observacoes,
        Long emergenciaId
) {}