package com.sigac.domain.model;

import com.sigac.domain.enums.aviso.StatusAviso;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Data
public class Aviso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotNull
    @FutureOrPresent
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private StatusAviso statusAviso;

    @ManyToOne
    private Condominio condominio;

    public Aviso(Long id, String titulo, LocalDate data, StatusAviso statusAviso, Condominio condominio) {
        this.titulo = titulo;
        this.data = data;
        this.id = id;
        this.statusAviso = statusAviso;
        this.condominio = condominio;
    }
    public Aviso() {}

}
