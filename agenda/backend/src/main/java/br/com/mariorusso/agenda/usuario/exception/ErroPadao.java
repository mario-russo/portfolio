package br.com.mariorusso.agenda.usuario.exception;

import java.time.LocalDateTime;

public class ErroPadao {
    private LocalDateTime timesTamp;
    private Integer status;
    private String error;

    private String path;

    public ErroPadao() {
    }

    public ErroPadao(LocalDateTime timesTamp, Integer status, String error, String path) {
        this.timesTamp = timesTamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public LocalDateTime getTimesTamp() {
        return timesTamp;
    }

    public void setTimesTamp(LocalDateTime timesTamp) {
        this.timesTamp = timesTamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
