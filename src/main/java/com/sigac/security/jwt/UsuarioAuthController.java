package com.sigac.security.jwt;

import com.sigac.domain.model.Usuario;
import com.sigac.domain.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UsuarioAuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid UsuarioAuthDTO authDTO){

        System.out.println("EMAIL: " + authDTO.getEmail());
        System.out.println("SENHA: " + authDTO.getSenha());

        Usuario usuario = usuarioRepository.findByEmail(authDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        System.out.println("USUARIO DO BANCO: " + usuario.getEmail());

        if (authDTO.getSenha() == null || !usuario.getSenha().equals(authDTO.getSenha())) {
            throw new RuntimeException("Senha inválida");
        }
        return ResponseEntity.ok(jwtUtil.gerarToken(usuario.getEmail()));
    }
}
