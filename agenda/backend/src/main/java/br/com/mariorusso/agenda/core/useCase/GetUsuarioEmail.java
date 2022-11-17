package br.com.mariorusso.agenda.core.useCase;

import br.com.mariorusso.agenda.core.model.Usuario;
import br.com.mariorusso.agenda.core.model.responseDto.UsuarioResponseDto;
import br.com.mariorusso.agenda.core.repository.GetUsuarioRepository;

/**
 * Recupera Usuário pelo Email
 */
public class GetUsuarioEmail {
    private final GetUsuarioRepository repository;

    /**
     * @param repository
     */
    public GetUsuarioEmail(GetUsuarioRepository repository) {
        this.repository = repository;
    }

    /**
     * @param E-mail
     * @return Usuario
     */
    public UsuarioResponseDto recuparaUsuario(String email) {
        Usuario usuario = repository.execute(email);
        UsuarioResponseDto usuariodto = new UsuarioResponseDto(usuario);
        return usuariodto;
    }
}
