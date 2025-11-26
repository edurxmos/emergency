package com.programmingcave.emergency.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "portaria")
public class Portaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String login;
}