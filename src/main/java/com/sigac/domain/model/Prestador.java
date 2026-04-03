package com.sigac.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class Prestador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    private String telefone;

    @NotBlank
    private String especialidade;

    @OneToOne
    private Manutencao manutencao;

    public Prestador(Long id, String nome, String telefone, String especialidade, Manutencao manutencao) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.especialidade = especialidade;
        this.manutencao = manutencao;
    }
    public Prestador() {}

}
