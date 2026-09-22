package com.izabelaxavier.treinosapi.repository;

import com.izabelaxavier.treinosapi.model.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
}