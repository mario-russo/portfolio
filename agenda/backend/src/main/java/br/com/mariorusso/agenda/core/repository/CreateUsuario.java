package br.com.mariorusso.agenda.core.repository;

import br.com.mariorusso.agenda.core.model.Usuario;
import br.com.mariorusso.agenda.core.model.responseDto.UsuarioResponseDto;

/**
 * inteface para salvar o usuário
 * 
 * @author Mário Russo
 */
public interface CreateUsuario {

    /**
     * @param usuario
     * @return Usuário Dto
     */
    public UsuarioResponseDto execute(Usuario usuario);
}
