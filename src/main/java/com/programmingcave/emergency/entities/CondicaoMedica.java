package com.programmingcave.emergency.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "condicao_medica")
public class CondicaoMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @ManyToOne
    private Aluno aluno;
}