package com.sigac.domain.model;

import com.sigac.domain.enums.endereco.UF;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;

@Embeddable
@Data
public class Endereco {

    @NotBlank
    private String rua;

    @NotBlank
    private String bairro;

    @Pattern(regexp = "\\d{8}", message = "O CEP contém 8 dígitos")
    private String cep;

    @NotNull
    private double numero;

    @Enumerated(EnumType.STRING)
    private UF uf;

    @NotBlank
    private String cidade;


    public Endereco (String rua, String bairro, String cep, double numero, UF uf, String cidade) {
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
        this.uf = uf;
        this.cidade = cidade;
    }

}
