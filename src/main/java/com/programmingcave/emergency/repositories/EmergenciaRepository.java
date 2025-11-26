package com.programmingcave.emergency.repositories;

import com.programmingcave.emergency.entities.Emergencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergenciaRepository extends JpaRepository<Emergencia, Long> {
}