package com.programmingcave.emergency.repositories;

import com.programmingcave.emergency.entities.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
    List<Notificacao> findByEmergenciaId(Long emergenciaId);
}