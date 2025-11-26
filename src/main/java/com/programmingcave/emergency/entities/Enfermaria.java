package com.programmingcave.emergency.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "enfermaria")
public class Enfermaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String login;
}