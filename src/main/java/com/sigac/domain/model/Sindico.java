package com.sigac.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Sindico extends Usuario{

    @OneToOne
    private Condominio condominio;

    public Sindico(Long id, String nome, String email, String senha, Endereco endereco, Condominio condominio) {
        super(id, nome, email, senha, endereco);
        this.condominio = condominio;
    }
    public Sindico() {}


}
