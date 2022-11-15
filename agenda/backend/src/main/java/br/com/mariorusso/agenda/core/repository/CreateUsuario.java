package br.com.mariorusso.agenda.core.repository;

import br.com.mariorusso.agenda.core.model.Usuario;
import br.com.mariorusso.agenda.core.model.responseDto.UsuarioResponseDto;

public interface CreateUsuario {
    public UsuarioResponseDto execute(Usuario usuario);
}
