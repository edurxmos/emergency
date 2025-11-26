package com.programmingcave.emergency.repositories;

import com.programmingcave.emergency.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}