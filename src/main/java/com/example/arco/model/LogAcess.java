package com.example.arco.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LogAcess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "adm_id", nullable = false)
    private adm adm;

    private String acaoRealizada;

    private LocalDateTime dataRealizacao;

    // Construtores
    public LogAcess() {
    }

    public LogAcess(adm adm, String acaoRealizada, LocalDateTime dataRealizacao) {
        this.adm = adm;
        this.acaoRealizada = acaoRealizada;
        this.dataRealizacao = dataRealizacao;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public adm getAdm() {
        return adm;
    }

    public void setAdm(adm adm) {
        this.adm = adm;
    }

    public String getAcaoRealizada() {
        return acaoRealizada;
    }

    public void setAcaoRealizada(String acaoRealizada) {
        this.acaoRealizada = acaoRealizada;
    }

    public LocalDateTime getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDateTime dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }
}
