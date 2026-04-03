package com.sigac.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.YearMonth;

@Entity
@Data
public class RelatorioMensal {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM")
    private YearMonth mesReferencia;

    @ManyToOne
    private Condominio condominio;

    public RelatorioMensal(Long id, YearMonth mesReferencia, Condominio condominio) {
        this.mesReferencia = mesReferencia;
        this.condominio = condominio;
        this.id = id;
    }
}
