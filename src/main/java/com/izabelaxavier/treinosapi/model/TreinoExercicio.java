package com.izabelaxavier.treinosapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "treino_exercicios")
public class TreinoExercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "treino_id" , nullable = false)
    private Treino treino;

    @ManyToOne
    @JoinColumn(name = "exercicio_id" , nullable = false)
    private Exercicio exercicio;

    private Integer series;

    private Integer repeticoes;

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public void setRepeticoes(Integer repeticoes) {
        this.repeticoes = repeticoes;
    }

    public Treino getTreino() {
        return treino;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public Integer getSeries() {
        return series;
    }

    public Integer getRepeticoes() {
        return repeticoes;
    }

    public Long getId() {
        return id;
    }
}
