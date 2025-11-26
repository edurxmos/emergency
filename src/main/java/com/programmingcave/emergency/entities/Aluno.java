package com.programmingcave.emergency.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String matricula;

    private boolean marcadorVisual;

    @ManyToOne
    private Turma turma;

    @ManyToOne
    private PlanoDeSaude planoDeSaude;
}