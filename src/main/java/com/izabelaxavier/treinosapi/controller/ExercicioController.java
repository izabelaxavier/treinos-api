package com.izabelaxavier.treinosapi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.izabelaxavier.treinosapi.service.ExercicioService;
import org.springframework.web.bind.annotation.GetMapping;
import com.izabelaxavier.treinosapi.model.Exercicio;
import org.springframework.web.bind.annotation.PostMapping;
import com.izabelaxavier.treinosapi.dto.ExercicioRequest;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;


@RestController
@RequestMapping("/exercicios")
public class ExercicioController {

    private final ExercicioService exercicioService;

    public ExercicioController(ExercicioService exercicioService) {
        this.exercicioService = exercicioService;
    }
    @GetMapping
    public List<Exercicio> buscarTodos() {
        return exercicioService.buscarTodos();
    }
    @PostMapping
    public Exercicio salvar(@RequestBody ExercicioRequest request) {
        return exercicioService.salvar(request);
    }
}
