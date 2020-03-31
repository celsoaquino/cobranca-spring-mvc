package com.celsoaquino.cobranca.repository;

import com.celsoaquino.cobranca.model.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TituloRepoitory extends JpaRepository<Titulo, Long> {
}
