package com.izabelaxavier.treinosapi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.izabelaxavier.treinosapi.service.ExercicioService;
import org.springframework.web.bind.annotation.GetMapping;
import com.izabelaxavier.treinosapi.model.Exercicio;
import org.springframework.web.bind.annotation.PostMapping;
import com.izabelaxavier.treinosapi.dto.ExercicioRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    @ResponseStatus(HttpStatus.CREATED)
    public Exercicio salvar(@Valid @RequestBody ExercicioRequest request) {
        return exercicioService.salvar(request);
    }

    @PutMapping("/{id}")
    public Exercicio atualizar(@PathVariable Long id, @Valid @RequestBody ExercicioRequest request) {
        return exercicioService.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        exercicioService.excluir(id);
    }

    @GetMapping("/{id}")
    public Exercicio buscarPorId(@PathVariable Long id) {
        return exercicioService.buscarPorId(id);
    }
}
