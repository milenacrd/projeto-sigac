package com.sigac.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@Entity
public class Gastos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    @FutureOrPresent
    private LocalDate data;

    @ManyToOne
    private Condominio condominio;

    public Gastos(String nome, LocalDate data, Condominio condominio) {
        this.nome = nome;
        this.data = data;
        this.condominio = condominio;
    }

    public Gastos() {}

}
