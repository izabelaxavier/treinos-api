package com.izabelaxavier.treinosapi.service;

import org.springframework.stereotype.Service;
import com.izabelaxavier.treinosapi.repository.TreinoExercicioRepository;
import com.izabelaxavier.treinosapi.model.TreinoExercicio;
import com.izabelaxavier.treinosapi.repository.TreinoRepository;
import com.izabelaxavier.treinosapi.repository.ExercicioRepository;
import com.izabelaxavier.treinosapi.dto.TreinoExercicioRequest;
import com.izabelaxavier.treinosapi.model.Treino;
import com.izabelaxavier.treinosapi.model.Exercicio;
import java.util.List;

@Service
public class TreinoExercicioService {

    private final TreinoExercicioRepository treinoExercicioRepository;
    private final TreinoRepository treinoRepository;
    private final ExercicioRepository exercicioRepository;

    public TreinoExercicioService(
            TreinoExercicioRepository treinoExercicioRepository,
            TreinoRepository treinoRepository,
            ExercicioRepository exercicioRepository) {

        this.treinoExercicioRepository = treinoExercicioRepository;
        this.treinoRepository = treinoRepository;
        this.exercicioRepository = exercicioRepository;
    }

    public List<TreinoExercicio> buscarTodos() {
        return treinoExercicioRepository.findAll();
    }

    public void excluir(Long id) {
        treinoExercicioRepository.deleteById(id);
    }

    public TreinoExercicio salvar(TreinoExercicioRequest request) {
        Treino treino = treinoRepository.findById(request.getTreinoId()).orElseThrow();

        Exercicio exercicio = exercicioRepository.findById(request.getExercicioId()).orElseThrow();

        TreinoExercicio treinoExercicio = new TreinoExercicio();
        treinoExercicio.setTreino(treino);
        treinoExercicio.setExercicio(exercicio);
        treinoExercicio.setSeries(request.getSeries());
        treinoExercicio.setRepeticoes(request.getRepeticoes());

        return treinoExercicioRepository.save(treinoExercicio);
    }
}