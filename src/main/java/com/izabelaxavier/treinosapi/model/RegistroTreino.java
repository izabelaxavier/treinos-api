package com.izabelaxavier.treinosapi.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "registros_treino")
public class RegistroTreino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exercicio_id", nullable = false)
    private Exercicio exercicio;

    private LocalDate data;

    private Integer series;

    private Integer repeticoes;

    private Double carga;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getSeries() {
        return series;
    }
    public void setSeries(Integer series) {
        this.series = series;
    }
    public Integer getRepeticoes() {
        return repeticoes;
    }
    public void setRepeticoes(Integer repeticoes) {
        this.repeticoes = repeticoes;
    }
    public Double getCarga() {
        return carga;
    }
    public void setCarga(Double carga) {
        this.carga = carga;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }
    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }
}
