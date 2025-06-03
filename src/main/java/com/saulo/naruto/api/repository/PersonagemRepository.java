package com.saulo.naruto.api.repository;

import com.saulo.naruto.api.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {}

