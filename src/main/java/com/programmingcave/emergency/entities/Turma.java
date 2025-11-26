package com.programmingcave.emergency.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Professor professor;

    @OneToOne(mappedBy = "turma")
    private LiderDeSala lider;

}
