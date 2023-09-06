package com.example.Lembretes.Repository;

import com.example.Lembretes.Entity.Lembrete;
import com.example.Lembretes.Entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LembreteRepository extends JpaRepository<Lembrete, Long> {
    @Query(value = "select * from lembretes where pessoa_fk = :id", nativeQuery = true)
    public List<Lembrete> findByPessoa(@Param("id") final Long id);
}
