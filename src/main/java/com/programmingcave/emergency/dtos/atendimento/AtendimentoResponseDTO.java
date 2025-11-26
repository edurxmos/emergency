package com.programmingcave.emergency.dtos.atendimento;

public record AtendimentoResponseDTO(
        Long id,
        String decisao,
        String observacoes,
        Long emergenciaId
) {}