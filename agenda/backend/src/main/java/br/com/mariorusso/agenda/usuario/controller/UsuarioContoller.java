package br.com.mariorusso.agenda.usuario.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import br.com.mariorusso.agenda.usuario.dto.usuarioResponseDto;
import br.com.mariorusso.agenda.usuario.entity.UsuarioEntity;
import br.com.mariorusso.agenda.usuario.services.UsuarioService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "usuarios")
public class UsuarioContoller {

    private final UsuarioService usuarioService;

    public UsuarioContoller(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<usuarioResponseDto>> usuario() {
        List<usuarioResponseDto> usuarios = usuarioService.findAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(200).body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> findById(@PathVariable long id) {
        UsuarioEntity usuario = usuarioService.findById(id);
        return ResponseEntity.status(200).body(usuario);
    }

    @PostMapping()
    public usuarioResponseDto salvar(@RequestBody UsuarioRequestDto entity) {
        UsuarioEntity user = new UsuarioEntity(entity.getNome(), entity.getEmail(), entity.getSenha());
        return usuarioService.salvar(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        usuarioService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<usuarioResponseDto> update(@PathVariable Long id, @RequestBody UsuarioEntity usuario) {
        usuarioResponseDto user = usuarioService.update(usuario);
        return ResponseEntity.status(202).body(user);
    }

}
