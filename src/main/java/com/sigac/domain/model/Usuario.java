package com.sigac.domain.model;

import com.sigac.domain.enums.usuario.TipoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

    @NotNull
    private String senha;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @Embedded
    private Endereco endereco;

    public Usuario(Long id, String nome, String email, String senha, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }
    public Usuario() {}

    public Usuario(Long id, String nome, String email, String senha, TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
