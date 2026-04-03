package com.sigac.controller;

import com.sigac.domain.model.Usuario;
import com.sigac.domain.repository.UsuarioRepository;
import com.sigac.dto.UsuarioRequestDTO;
import com.sigac.dto.UsuarioResponseDTO;
import com.sigac.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioService usuarioService, UsuarioRepository usuarioRepository) {
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public UsuarioResponseDTO criarUsuario(@RequestBody @Valid UsuarioRequestDTO dto) {
        return usuarioService.cadastrarUsuario(dto);
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO listarUsuario(@PathVariable Long id){
        return usuarioService.visualizarUsuario(id);
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @PutMapping("/{id}")
    public UsuarioResponseDTO updateUsuario(@RequestBody @Valid UsuarioRequestDTO dto, @PathVariable Long id) {
        return usuarioService.updateUsuario(dto, id);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
        System.out.println("Usuario deletado com sucesso");
    }



}
