package br.com.mariorusso.agenda.core.repository;

import br.com.mariorusso.agenda.core.model.Usuario;

/**
 * Contrato para usar buscar usuario por E-mail
 */
public interface GetUsuarioRepository {
    /**
     * @param email
     * @return Usuario
     */
    public Usuario execute(String email);
}
