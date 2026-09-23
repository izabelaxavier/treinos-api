package com.izabelaxavier.treinosapi.controller;

import com.izabelaxavier.treinosapi.model.Treino;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.izabelaxavier.treinosapi.service.TreinoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;


@RestController
@RequestMapping("/treinos")
public class TreinoController {

    private final TreinoService treinoService;

    public TreinoController(TreinoService treinoService) {
        this.treinoService = treinoService;
    }

    @GetMapping
    public List<Treino> buscarTodos() {
        return treinoService.buscarTodos();
    }

    @PostMapping
    public Treino salvar(@RequestBody Treino treino) {
        return treinoService.salvar(treino);
    }
}
