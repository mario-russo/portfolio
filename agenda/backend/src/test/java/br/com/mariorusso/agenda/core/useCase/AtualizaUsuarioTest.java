package br.com.mariorusso.agenda.core.useCase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
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
import br.com.mariorusso.agenda.core.repository.UpdataUsuario;

@ExtendWith(MockitoExtension.class)
public class AtualizaUsuarioTest {
    @Mock
    private UpdataUsuario repository;
    @InjectMocks
    private AtualizaUsuario atualiza;

    Usuario usuario;

    UsuarioResponseDto usuarioDto;

    @Test
    void AtualizaUsuarioExistente() {
        Long id = (long) 1;

        when(repository.execute(anyLong(), any())).thenReturn(usuarioDto);
        UsuarioResponseDto user = atualiza.execute(id, usuario);

        assertEquals(UsuarioResponseDto.class, user.getClass());

    }

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        usuario = new Usuario("mario", "mario@mario", "123", TipoUsuario.ROLE_CLIENTE);
        atualiza = new AtualizaUsuario(repository);
        usuarioDto = new UsuarioResponseDto(usuario);

    }
}
