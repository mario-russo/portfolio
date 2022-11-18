package br.com.mariorusso.agenda.core.useCase;

import br.com.mariorusso.agenda.core.model.Usuario;
import br.com.mariorusso.agenda.core.model.responseDto.UsuarioResponseDto;
import br.com.mariorusso.agenda.core.repository.CreateUsuario;

/**
 * Serviço para salvar o usuário
 * 
 * @author Mário Russo
 */
public class SalvaUsuario {

    public final CreateUsuario createUsuario;

    /**
     * Depende de um contrato CreateUsuario
     * 
     * @param createUsuario
     */
    public SalvaUsuario(CreateUsuario createUsuario) {
        this.createUsuario = createUsuario;
    }

    /**
     * @param usuario
     * @return UsuarioResponseDto
     */
    public UsuarioResponseDto salvar(Usuario usuario) {
        return createUsuario.execute(usuario);
    }
}
