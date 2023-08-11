package com.example.Lembretes.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lembretes", schema = "public")
public class Lembrete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String mensagem;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "pessoa_fk", nullable = false)
    @JsonBackReference
    private Pessoa pessoa;

    public Lembrete(){}

    public Lembrete(Long id, String mensagem, Pessoa pessoa){
        this.id = id;
        this.mensagem = mensagem;
        this.pessoa = pessoa;
    }
}
