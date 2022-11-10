package br.com.mariorusso.agenda.usuario.services;

import org.springframework.boot.test.context.SpringBootTest;

import br.com.mariorusso.agenda.usuario.dto.usuarioResponseDto;
import br.com.mariorusso.agenda.usuario.entity.UsuarioEntity;
import br.com.mariorusso.agenda.usuario.repository.UsuarioRepository;

import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@SpringBootTest
public class UsuarioServiceTest {
    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    private UsuarioEntity usuario;

    private Optional<UsuarioEntity> usuarioOptional;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startTest();
    }

    @Test
    void findById() {
    when(usuarioRepository.findById(anyLong())).thenReturn(usuarioOptional);
    usuario = usuarioRepository.findById(anyLong()).get();
    
    Assertions.assertEquals(UsuarioEntity.class,
    usuarioOptional.get().getClass());
    Assertions.assertEquals(usuario.getNome(), usuarioOptional.get().getNome());
    
    verify(usuarioRepository,times(1)).findById(anyLong());
    }

    @Test
    void salva() {
    when(usuarioRepository.save(any())).thenReturn(usuario);

    usuarioResponseDto resposta = usuarioService.salvar(usuario);

    Assertions.assertNotNull(resposta.getId());
    Assertions.assertEquals(resposta.getNome(), usuario.getNome());
    Assertions.assertEquals(resposta.getEmail(), usuario.getEmail());
    Assertions.assertEquals(resposta.getNome(), usuario.getNome());

    verify(usuarioRepository).save(usuario);
    }

    @Test
    void findAll() {
        
        when(usuarioRepository.findAll()).thenReturn(List.of(usuario));

        List< usuarioResponseDto> user = usuarioService.findAll();
        
        Assertions.assertNotNull(user);
        Assertions.assertNotNull(user.get(0).getId());
        Assertions.assertEquals(user.get(0).getNome(), usuario.getNome());

        verify(usuarioRepository).findAll();

        

    }

    void startTest() {
        usuario = new UsuarioEntity("mario", "mario@mario@gmail", "12334312");

        usuarioOptional = Optional.of(usuario);
    }
}
