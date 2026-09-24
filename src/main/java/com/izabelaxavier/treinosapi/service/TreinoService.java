package com.izabelaxavier.treinosapi.service;

import com.izabelaxavier.treinosapi.dto.TreinoRequestDto;
import com.izabelaxavier.treinosapi.dto.TreinoResponseDto;
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

    public TreinoResponseDto salvar(TreinoRequestDto dto) {

        if (treinoRepository.existsByNome(dto.nome())){
            throw new RuntimeException("Ja existe um treino cadastrado com esse nome");
        }

        Treino treino = new Treino();
        treino.setNome(dto.nome());
        treino.setDescricao(dto.descricao());

        Treino treinoSalvo = treinoRepository.save(treino);

        return new TreinoResponseDto(
                treinoSalvo.getId(),
                treinoSalvo.getNome(),
                treinoSalvo.getDescricao()
        );
    }
}
