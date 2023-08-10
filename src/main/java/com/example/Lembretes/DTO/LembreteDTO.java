package com.example.Lembretes.DTO;

import lombok.Getter;
import lombok.Setter;

public class LembreteDTO {
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String mensagem;

    @Getter @Setter
    private PessoaDTO pessoa;

    public LembreteDTO(){}

    public LembreteDTO(Long id, String mensagem, PessoaDTO pessoa){
        this.id = id;
        this.mensagem = mensagem;
        this.pessoa = pessoa;
    }
}
