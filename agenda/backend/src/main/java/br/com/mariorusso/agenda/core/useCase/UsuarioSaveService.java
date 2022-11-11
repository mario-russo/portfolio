package br.com.mariorusso.agenda.core.useCase;

import br.com.mariorusso.agenda.core.model.Usuario;
import br.com.mariorusso.agenda.core.repository.CreateUsuario;

public class UsuarioSaveService {

    public final CreateUsuario createUsuario;

    public UsuarioSaveService(CreateUsuario createUsuario) {
        this.createUsuario = createUsuario;
    }

    public Usuario salvar( Usuario usuario){
       return createUsuario.execute(usuario);
    }
}
