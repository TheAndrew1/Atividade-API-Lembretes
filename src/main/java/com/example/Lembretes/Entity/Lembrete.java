package com.example.Lembretes.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lembretes", schema = "public")
public class Lembrete {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String mensagem;

    @Getter @Setter
    @ManyToOne
    private Pessoa pessoa;
}
