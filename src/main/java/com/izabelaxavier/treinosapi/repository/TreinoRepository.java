package com.izabelaxavier.treinosapi.repository;

import com.izabelaxavier.treinosapi.model.Treino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreinoRepository extends JpaRepository<Treino, Long> {

    boolean existsByNome(String nome);
}