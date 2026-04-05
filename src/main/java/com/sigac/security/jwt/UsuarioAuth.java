package com.sigac.security.jwt;

import com.sigac.domain.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UsuarioAuth implements UserDetails {

    private Usuario usuario;

    public UsuarioAuth(Usuario usuario){
        this.usuario = usuario;
    }
    @Override
    public String getUsername() {
        return usuario.getEmail();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return usuario.getSenha();
    }

}
