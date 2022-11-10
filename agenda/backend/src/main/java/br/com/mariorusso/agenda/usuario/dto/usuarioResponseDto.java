package br.com.mariorusso.agenda.usuario.dto;

public class usuarioResponseDto {
    private final long id;
    private final String nome;
    private final String email;

    public usuarioResponseDto(long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

}
