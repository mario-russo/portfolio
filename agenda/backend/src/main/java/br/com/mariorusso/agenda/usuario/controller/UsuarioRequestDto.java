package br.com.mariorusso.agenda.usuario.controller;

public class UsuarioRequestDto {

    private final String nome;
    private final String email;
    private final String senha;

    public String getSenha() {
        return senha;
    }

    public UsuarioRequestDto(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

}
