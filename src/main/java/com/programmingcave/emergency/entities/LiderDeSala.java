package com.programmingcave.emergency.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "lider_sala")
public class LiderDeSala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String login;

    private java.util.Date validadeSemestre;

    @OneToOne
    private Turma turma;
}