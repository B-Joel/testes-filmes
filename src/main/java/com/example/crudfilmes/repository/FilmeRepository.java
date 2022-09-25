package com.example.crudfilmes.repository;

import com.example.crudfilmes.domain.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
