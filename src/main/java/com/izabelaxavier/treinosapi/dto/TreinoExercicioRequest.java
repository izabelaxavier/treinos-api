package com.izabelaxavier.treinosapi.dto;

public class TreinoExercicioRequest {

    private Long treinoId;

    private Long exercicioId;

    private Integer series;

    private Integer repeticoes;

    public Long getTreinoId() {
        return treinoId;
    }
    public void setTreinoId(Long treinoId) {
        this.treinoId = treinoId;
    }
    public Long getExercicioId() {
        return exercicioId;
    }
    public void setExercicioId(Long exercicioId) {
        this.exercicioId = exercicioId;
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

}
