package br.com.mariorusso.agenda.core.useCase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


import br.com.mariorusso.agenda.core.model.TipoUsuario;
import br.com.mariorusso.agenda.core.model.Usuario;
import br.com.mariorusso.agenda.core.repository.CreateUsuario;

@ExtendWith(MockitoExtension.class)
public class UsuarioSaveServiceTest {
    @InjectMocks
    private UsuarioSaveService saveService;
    private Usuario usuario;

    @Mock
    private CreateUsuario createUsuario;

    @Test
    void testSalvar() {

        when(createUsuario.execute(any())).thenReturn(usuario);

        Usuario resposta  = saveService.salvar(usuario);

        assertEquals("mario", resposta.getNome());
        assertEquals("mario@russo", resposta.getEmail());
       
    }

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        usuario = new Usuario("mario", "mario@russo", "1234", TipoUsuario.ROLE_CLIENTE);
        saveService = new UsuarioSaveService(createUsuario);
    }
}
