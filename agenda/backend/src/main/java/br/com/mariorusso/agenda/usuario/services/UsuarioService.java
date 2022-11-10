package br.com.mariorusso.agenda.usuario.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.mariorusso.agenda.usuario.dto.usuarioResponseDto;
import br.com.mariorusso.agenda.usuario.entity.UsuarioEntity;
import br.com.mariorusso.agenda.usuario.exception.UsuarioNaoEncontrado;
import br.com.mariorusso.agenda.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public usuarioResponseDto salvar(UsuarioEntity usuario) {
        String passWord = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(passWord);
        UsuarioEntity user = usuarioRepository.save(usuario);
        return new usuarioResponseDto(user.getId(), user.getNome(), user.getEmail());
    }

    public List<usuarioResponseDto> findAll() {
        List<UsuarioEntity> user = usuarioRepository.findAll();
        List<usuarioResponseDto> usuario = user.stream()
                .map(item -> new usuarioResponseDto(item.getId(), item.getNome(), item.getEmail()))
                .collect(Collectors.toList());
        return usuario;
    }

    public UsuarioEntity findById(long id) {
        Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);
        return usuario.orElseThrow(() -> new UsuarioNaoEncontrado("Usuario não encontrado!!!"));
    }

    public void delete(long id) {
        usuarioRepository.deleteById(id);
    }

    public usuarioResponseDto update(UsuarioEntity usuario) {
        UsuarioEntity user = usuarioRepository.save(usuario);
        return new usuarioResponseDto(user.getId(), user.getNome(), user.getEmail());
    }

}
