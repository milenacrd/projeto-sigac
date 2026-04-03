package com.sigac.domain.model;

import com.sigac.domain.enums.manutencao.StatusManutencao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Data
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String descricao;

    @NotNull
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private StatusManutencao status;

    @OneToOne
    private Prestador prestador;

    @ManyToOne
    private Condominio condominio;

    public Manutencao(Long id, String descricao, LocalDate data, StatusManutencao status, Prestador
                      prestador, Condominio condominio){
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.status = status;
        this.prestador = prestador;
        this.condominio = condominio;
    }
    public Manutencao() {}

}
