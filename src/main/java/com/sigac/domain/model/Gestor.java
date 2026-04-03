package com.sigac.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Gestor extends Usuario{

    @OneToOne
    private Condominio condominio;

    public Gestor(Long id, String nome, String email, String senha,Endereco endereco, Condominio condominio) {
        super(id, nome, email, senha, endereco);
        this.condominio = condominio;
    }
    public Gestor() {
        super();
    }

}
