package com.izabelaxavier.treinosapi.service;

import org.springframework.stereotype.Service;
import com.izabelaxavier.treinosapi.repository.TreinoRepository;
import com.izabelaxavier.treinosapi.model.Treino;
import java.util.List;


@Service
public class TreinoService {

    private final TreinoRepository treinoRepository;

    public TreinoService(TreinoRepository treinoRepository) {
        this.treinoRepository = treinoRepository;
    }

    public List<Treino> buscarTodos() {
        return treinoRepository.findAll();
    }

    public Treino salvar(Treino treino) {
        return treinoRepository.save(treino);
    }
}
