package com.programmingcave.emergency.repositories;

import com.programmingcave.emergency.entities.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
}