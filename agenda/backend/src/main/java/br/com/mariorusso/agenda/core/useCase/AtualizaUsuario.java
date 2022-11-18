package br.com.mariorusso.agenda.core.useCase;

import br.com.mariorusso.agenda.core.model.Usuario;
import br.com.mariorusso.agenda.core.model.responseDto.UsuarioResponseDto;
import br.com.mariorusso.agenda.core.repository.UpdataUsuario;

/**
 * Atualiza Usuario Na Base De Dados
 */
public class AtualizaUsuario {
    private final UpdataUsuario updataUsuario;

    /**
     * @param repository
     */
    public AtualizaUsuario(UpdataUsuario repository) {
        this.updataUsuario = repository;
    }

    /**
     * @param id
     * @param usuario
     * @return UsuarioResponseDto
     */
    public UsuarioResponseDto execute(long id, Usuario usuario) {
        UsuarioResponseDto user = updataUsuario.execute(id, usuario);
        return user;
    }

}
