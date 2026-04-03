package com.sigac.dto;

import com.sigac.domain.enums.usuario.TipoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Data
public class UsuarioResponseDTO {


        private Long id;
        private String nome;
        private String email;
        private TipoUsuario tipoUsuario;


        public UsuarioResponseDTO(Long id, String nome, String email, TipoUsuario tipoUsuario) {
            this.id = id;
            this.nome = nome;
            this.email = email;
            this.tipoUsuario = tipoUsuario;
        }
}

