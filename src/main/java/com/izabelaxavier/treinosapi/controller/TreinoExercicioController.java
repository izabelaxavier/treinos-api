package com.izabelaxavier.treinosapi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.izabelaxavier.treinosapi.service.TreinoExercicioService;
import org.springframework.web.bind.annotation.GetMapping;
import com.izabelaxavier.treinosapi.model.TreinoExercicio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.izabelaxavier.treinosapi.dto.TreinoExercicioRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;


@RestController
@RequestMapping("/treino-exercicios")
public class TreinoExercicioController {

    private final TreinoExercicioService treinoExercicioService;
    public TreinoExercicioController(TreinoExercicioService treinoExercicioService) {
        this.treinoExercicioService = treinoExercicioService;
    }

    @GetMapping
    public List<TreinoExercicio> buscarTodos() {
        return treinoExercicioService.buscarTodos();
    }

    @PostMapping
    public TreinoExercicio salvar(@RequestBody TreinoExercicioRequest request) {
        return treinoExercicioService.salvar(request);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        treinoExercicioService.excluir(id);
    }
}