package com.example.Lembretes.Repository;

import com.example.Lembretes.Entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository  extends JpaRepository<Pessoa, Long> {
    public Pessoa findByNome(final String nome);
}
