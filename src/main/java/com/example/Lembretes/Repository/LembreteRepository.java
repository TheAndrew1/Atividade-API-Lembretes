package com.example.Lembretes.Repository;

import com.example.Lembretes.Entity.Lembrete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LembreteRepository extends JpaRepository<Lembrete, Long> {
}
