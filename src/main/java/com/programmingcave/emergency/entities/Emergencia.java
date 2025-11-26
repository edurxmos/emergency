package com.programmingcave.emergency.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "emergencia")
public class Emergencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    private String status;

    private String descricao;

    @ManyToOne
    private Aluno aluno;

    @OneToMany(mappedBy = "emergencia")
    private List<Notificacao> notificacoes;

    @OneToOne(mappedBy = "emergencia")
    private Atendimento atendimento;
}