package com.izabelaxavier.treinosapi.service;

import com.izabelaxavier.treinosapi.dto.ExercicioRequest;
import com.izabelaxavier.treinosapi.model.Exercicio;
import com.izabelaxavier.treinosapi.repository.ExercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioService {

    private final ExercicioRepository exercicioRepository;

    public ExercicioService(ExercicioRepository exercicioRepository) {
        this.exercicioRepository = exercicioRepository;
    }

    public List<Exercicio> buscarTodos() {
        return exercicioRepository.findAll();
    }

    public Exercicio salvar(ExercicioRequest request) {
        Exercicio exercicio = new Exercicio();

        exercicio.setNome(request.getNome());
        exercicio.setGrupoMuscular(request.getGrupoMuscular());
        exercicio.setDescricao(request.getDescricao());
        exercicio.setFotoUrl(request.getFotoUrl());
        exercicio.setVideoUrl(request.getVideoUrl());

        return exercicioRepository.save(exercicio);

    }

    public Exercicio atualizar(Long id, ExercicioRequest request) {
        Exercicio exercicio = exercicioRepository.findById(id).orElseThrow();

        exercicio.setNome(request.getNome());
        exercicio.setGrupoMuscular(request.getGrupoMuscular());
        exercicio.setDescricao(request.getDescricao());
        exercicio.setFotoUrl(request.getFotoUrl());
        exercicio.setVideoUrl(request.getVideoUrl());

        return exercicioRepository.save(exercicio);
    }
}