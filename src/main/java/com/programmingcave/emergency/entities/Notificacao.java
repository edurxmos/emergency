package com.programmingcave.emergency.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notificacao")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String mensagem;
    private LocalDateTime dataHora;

    @ManyToOne
    private Emergencia emergencia;
}
