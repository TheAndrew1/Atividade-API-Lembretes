package com.example.Lembretes.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class PessoaDTO {
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private List<LembreteDTO> lembretes;

    public PessoaDTO(){}

    public PessoaDTO(Long id, String nome, List<LembreteDTO> lembretes){
        this.id = id;
        this.nome = nome;
        this.lembretes = lembretes;
    }
}
