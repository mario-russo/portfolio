package br.com.mariorusso.agenda.core.model.responseDto;

import br.com.mariorusso.agenda.core.model.Usuario;

/**
 * Classe para retorna um Objeto usuário sem a senha
 * 
 * @author Mário Russo
 */
public class UsuarioResponseDto {
    private long id;
    private String nome;
    private String email;
    private String tipo;

    /**
     * Recebe um usuario e converte em DTO
     * 
     * @param usuario
     *
     */
    public UsuarioResponseDto(Usuario usuario) {
        // setId(usuario.getId());
        setNome(usuario.getNome());
        setEmail(usuario.getEmail());
        tipo = usuario.getTipoUsuario().toString();
    }

    /**
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     * 
     * @param id do tipo long
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return uma String
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome do tipo String
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return returna E-mail do usuário
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email do tipo String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return uma string Do tipo de usuario
     */
    public String getTipo() {
        return tipo;
    }

}
