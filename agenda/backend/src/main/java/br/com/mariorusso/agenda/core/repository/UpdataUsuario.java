package br.com.mariorusso.agenda.core.repository;

import br.com.mariorusso.agenda.core.model.Usuario;
import br.com.mariorusso.agenda.core.model.responseDto.UsuarioResponseDto;

/**
 * Contrato Para Atualizar Usuário
 */
public interface UpdataUsuario {
    /**
     * @param id
     * @param usuario
     * @return UsuarioResponseDto
     */
    public UsuarioResponseDto execute(Long id, Usuario usuario);
}
