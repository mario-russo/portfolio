package br.com.mariorusso.agenda.usuario.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UsuarioNaoEncontrado.class)
    public ResponseEntity<ErroPadao> usuarioNaoEncontrado(UsuarioNaoEncontrado ex, HttpServletRequest request) {
        ErroPadao erro = new ErroPadao(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}