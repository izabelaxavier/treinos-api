package com.izabelaxavier.treinosapi.controller;

import com.izabelaxavier.treinosapi.dto.TreinoRequestDto;
import com.izabelaxavier.treinosapi.dto.TreinoResponseDto;
import com.izabelaxavier.treinosapi.model.Treino;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<TreinoResponseDto> salvar(@RequestBody TreinoRequestDto treino) {
        return ResponseEntity.status(HttpStatus.CREATED).body(treinoService.salvar(treino));
    }
}
