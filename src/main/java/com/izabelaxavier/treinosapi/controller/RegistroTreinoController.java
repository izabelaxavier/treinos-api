package com.izabelaxavier.treinosapi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.izabelaxavier.treinosapi.service.RegistroTreinoService;
import com.izabelaxavier.treinosapi.model.RegistroTreino;
import com.izabelaxavier.treinosapi.dto.RegistroTreinoRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@RestController
@RequestMapping("/registros-treino")
public class RegistroTreinoController {

    private final RegistroTreinoService registroTreinoService;

    public RegistroTreinoController(RegistroTreinoService registroTreinoService) {
        this.registroTreinoService = registroTreinoService;
    }

    @GetMapping
    public List<RegistroTreino> buscarTodos() {
        return registroTreinoService.buscarTodos();
    }
    @PostMapping
    public RegistroTreino salvar(@RequestBody RegistroTreinoRequest request) {
        return registroTreinoService.salvar(request);
    }
}