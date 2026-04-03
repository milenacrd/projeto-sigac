package com.sigac.service;

import com.sigac.domain.enums.usuario.TipoUsuario;
import com.sigac.domain.model.Gestor;
import com.sigac.domain.model.Sindico;
import com.sigac.domain.model.Usuario;
import com.sigac.domain.repository.UsuarioRepository;
import com.sigac.dto.UsuarioRequestDTO;
import com.sigac.dto.UsuarioResponseDTO;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    private void preencherDados(Usuario usuario, UsuarioRequestDTO dto) {
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setTipoUsuario(dto.getTipoUsuario());
    }

    public UsuarioResponseDTO cadastrarUsuario(UsuarioRequestDTO dto) {
        if (dto.getTipoUsuario() == TipoUsuario.GESTOR) {
            Gestor gestor = new Gestor();
            preencherDados(gestor, dto);
            usuarioRepository.save(gestor);

            return new UsuarioResponseDTO(
                    gestor.getId(),
                    gestor.getNome(),
                    gestor.getEmail(),
                    gestor.getTipoUsuario()
            );
        }
        if (dto.getTipoUsuario() == TipoUsuario.SINDICO) {
            Sindico sindico = new Sindico();
            preencherDados(sindico, dto);
            usuarioRepository.save(sindico);

            return new UsuarioResponseDTO(
                    sindico.getId(),
                    sindico.getNome(),
                    sindico.getEmail(),
                    sindico.getTipoUsuario()
            );
        }
        throw new RuntimeException("Tipo inválido");
    }

    public UsuarioResponseDTO visualizarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTipoUsuario()
        );
    }

    public UsuarioResponseDTO updateUsuario(UsuarioRequestDTO dto, Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if(usuario.getTipoUsuario() != dto.getTipoUsuario()) {
            throw new RuntimeException("Não é permitido alterar o tipo de usuario");
        }

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTipoUsuario()
        );
    }
    public void deletarUsuario (Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuarioRepository.delete(usuario);
    }
}
