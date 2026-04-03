package com.sigac.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Condominio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Pattern(regexp = "\\d{14}", message = "CNPJ deve ter 14 digitos numéricos")
    private String cnpj;

    @OneToOne
    private Sindico sindico;

    @OneToMany
    private List<Aviso> aviso = new ArrayList<>();

    @OneToMany
    private List<Manutencao> manutencao = new ArrayList<>();

    @OneToMany
    private List<Gastos> gastos = new ArrayList<>();

    @OneToOne
    private Gestor gestor;


    public Condominio(String nome,String cnpj, Sindico sindico, Long id, List aviso, Gestor gestor, List manutencao, List gastos) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.sindico = sindico;
        this.id = id;
        this.aviso = aviso;
        this.gestor = gestor;
        this.manutencao = manutencao;
        this.gastos = gastos;
    }

    public Condominio() {}
}
