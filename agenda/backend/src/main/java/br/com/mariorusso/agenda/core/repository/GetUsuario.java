package br.com.mariorusso.agenda.core.repository;

import br.com.mariorusso.agenda.core.model.Usuario;

public interface GetUsuario {
    public Usuario execute(Long id);
}
