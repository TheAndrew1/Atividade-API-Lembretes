package com.example.Lembretes.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "pessoas", schema = "public")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    @OneToMany
    @JoinColumn(name = "id")
    @JsonManagedReference
    private List<Lembrete> lembretes;

    public Pessoa(){}

    public Pessoa(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Pessoa(Long id, String nome, List<Lembrete> lembretes){
        this.id = id;
        this.nome = nome;
        this.lembretes = lembretes;
    }
}
