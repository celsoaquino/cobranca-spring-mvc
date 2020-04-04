package com.celsoaquino.cobranca.repository;

import com.celsoaquino.cobranca.model.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TituloRepository extends JpaRepository<Titulo, Long> {

    List<Titulo> findByDescricaoContaining(String descricao);
}
