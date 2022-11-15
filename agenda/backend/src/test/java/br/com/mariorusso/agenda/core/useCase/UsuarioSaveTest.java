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
import br.com.mariorusso.agenda.core.model.responseDto.UsuarioResponseDto;
import br.com.mariorusso.agenda.core.repository.CreateUsuario;

@ExtendWith(MockitoExtension.class)
public class UsuarioSaveTest {
    @InjectMocks
    private UsuarioSave saveService;
    private Usuario usuario;

    @Mock
    private CreateUsuario createUsuario;

    @Test
    void testSalvar() {
        UsuarioResponseDto usuriarioDto = new UsuarioResponseDto(usuario);

        when(createUsuario.execute(any())).thenReturn(usuriarioDto);

        UsuarioResponseDto resposta = saveService.salvar(usuario);

        assertEquals(UsuarioResponseDto.class, resposta.getClass());

        assertEquals("mario", resposta.getNome());
        assertEquals("mario@russo", resposta.getEmail());
        verify(createUsuario).execute(usuario);

    }

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        usuario = new Usuario("mario", "mario@russo", "1234", TipoUsuario.ROLE_CLIENTE);
        saveService = new UsuarioSave(createUsuario);
    }
}
