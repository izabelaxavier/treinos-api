package com.izabelaxavier.treinosapi.dto;



import java.time.LocalDate;

public class RegistroTreinoRequest {

    private Long exercicioId;
    private LocalDate data;
    private Integer series;
    private Integer repeticoes;
    private Double carga;

    public Long getExercicioId() {
        return exercicioId;
    }
    public void setExercicioId(Long exercicioId) {
        this.exercicioId = exercicioId;
    }
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
}
