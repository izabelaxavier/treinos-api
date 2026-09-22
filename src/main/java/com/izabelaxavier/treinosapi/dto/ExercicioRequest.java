package com.izabelaxavier.treinosapi.dto;

public class ExercicioRequest {

    private String nome;
    private String grupoMuscular;
    private String descricao;
    private String fotoUrl;
    private String videoUrl;


    public ExercicioRequest() {
    }

    public ExercicioRequest(String nome, String grupoMuscular, String descricao, String fotoUrl, String videoUrl) {
        this.nome = nome;
        this.grupoMuscular = grupoMuscular;
        this.descricao = descricao;
        this.fotoUrl = fotoUrl;
        this.videoUrl = videoUrl;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}

