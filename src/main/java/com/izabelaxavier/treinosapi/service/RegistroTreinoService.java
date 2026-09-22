package com.izabelaxavier.treinosapi.service;

import com.izabelaxavier.treinosapi.dto.RegistroTreinoRequest;
import com.izabelaxavier.treinosapi.model.Exercicio;
import com.izabelaxavier.treinosapi.model.RegistroTreino;
import com.izabelaxavier.treinosapi.repository.ExercicioRepository;
import com.izabelaxavier.treinosapi.repository.RegistroTreinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroTreinoService {

    private final RegistroTreinoRepository registroTreinoRepository;
    private final ExercicioRepository exercicioRepository;

    public RegistroTreinoService(
            RegistroTreinoRepository registroTreinoRepository,
            ExercicioRepository exercicioRepository) {

        this.registroTreinoRepository = registroTreinoRepository;
        this.exercicioRepository = exercicioRepository;
    }

    public List<RegistroTreino> buscarTodos() {
        return registroTreinoRepository.findAll();
    }

    public RegistroTreino salvar(RegistroTreinoRequest request) {
        Optional<Exercicio> exercicio =
                exercicioRepository.findById(request.getExercicioId());

        Exercicio exercicioEncontrado = exercicio.orElseThrow();

        RegistroTreino registro = new RegistroTreino();

        registro.setExercicio(exercicioEncontrado);
        registro.setData(request.getData());
        registro.setSeries(request.getSeries());
        registro.setRepeticoes(request.getRepeticoes());
        registro.setCarga(request.getCarga());

        return registroTreinoRepository.save(registro);
    }
}