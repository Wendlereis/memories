package br.com.moosegroup.models;

public abstract class Usuario {
    private int id;
    private String nomeAcesso;
    private String senha;
    
    public Usuario(int id, String nomeAcesso, String senha) {
        this.id = id;
        this.nomeAcesso = nomeAcesso;
        this.senha = senha;
    }
    
    public Usuario(String nomeAcesso, String senha) {
        this.nomeAcesso = nomeAcesso;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeAcesso() {
        return nomeAcesso;
    }

    public void setNomeAcesso(String nomeAcesso) {
        this.nomeAcesso = nomeAcesso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
