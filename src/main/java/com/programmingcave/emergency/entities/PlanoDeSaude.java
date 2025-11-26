package com.programmingcave.emergency.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "plano_saude")
public class PlanoDeSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String numeroCarteira;
}