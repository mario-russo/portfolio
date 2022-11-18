package br.com.mariorusso.agenda.core.model;

public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private TipoUsuario tipo;

    public Usuario(String nome, String email, String senha, TipoUsuario tipo) {
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        setTipoUsuario(tipo);
    }

    /**
     * Enum 
     * ROLE_ADM,
     * ROLE_CLIENTE,
     * ROLE_FUNCIONARIO;
     * 
     * @return TipoUsuario
     */
    public TipoUsuario getTipoUsuario() {
        return tipo;
    }

    /**
     * @param tipo
     */
    public void setTipoUsuario(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    /**
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param  String 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String 
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

}
