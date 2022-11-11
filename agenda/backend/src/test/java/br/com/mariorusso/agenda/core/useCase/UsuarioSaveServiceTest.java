package br.com.mariorusso.agenda.core.useCase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import br.com.mariorusso.agenda.core.model.TipoUsuario;
import br.com.mariorusso.agenda.core.model.Usuario;
import br.com.mariorusso.agenda.core.repository.CreateUsuario;

@SpringBootTest()
public class UsuarioSaveServiceTest {
    @InjectMocks
    private UsuarioSaveService saveService;

    @Mock
    private CreateUsuario createUsuario;

    @Test
    void testSalvar() {
        Usuario usuario = new Usuario("mario", "mario@russo", "1234", TipoUsuario.ROLE_CLIENTE);

        when(createUsuario.execute(usuario)).thenReturn(usuario);

        saveService.salvar(usuario);

        // assertEquals("mario", resposta.getNome());

        verify(createUsuario,times(1)).execute(usuario);
    }

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
}
