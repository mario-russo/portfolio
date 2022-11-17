package br.com.mariorusso.agenda.core.useCase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.mariorusso.agenda.core.model.TipoUsuario;
import br.com.mariorusso.agenda.core.model.Usuario;
import br.com.mariorusso.agenda.core.model.responseDto.UsuarioResponseDto;
import br.com.mariorusso.agenda.core.repository.GetUsuarioRepository;

@ExtendWith(MockitoExtension.class)
public class GetUsuarioEmailTest {
    @Mock
    GetUsuarioRepository repository;

    @InjectMocks
    GetUsuarioEmail service;

    Usuario usuario;

    @Test
    void RecuperaUsuarioPorEmail() {
        when(repository.execute(anyString())).thenReturn(usuario);

        UsuarioResponseDto usuario = service.recuparaUsuario(anyString());

        assertEquals("mario@email", usuario.getEmail() );
        assertEquals(UsuarioResponseDto.class, usuario.getClass());

        verify(repository).execute(anyString());
    }

    @BeforeEach
    void inicial() {
        MockitoAnnotations.openMocks(this);
        usuario = new Usuario("mario", "mario@email", "123", TipoUsuario.ROLE_ADM);
        service = new GetUsuarioEmail(repository);
    }
}
