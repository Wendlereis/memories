package br.com.moosegroup.models;

public class Integrante {
    private int id_integrante;
    private String nomeCompleto;
    private String rm;
    private int id_grupo;
    private String grupo;   

    public Integrante(int id_integrante, String nomeCompleto, String rm, int id_grupo, String grupo) {
        this.id_integrante = id_integrante;
        this.nomeCompleto = nomeCompleto;
        this.rm = rm;
        this.id_grupo = id_grupo;
        this.grupo = grupo;
    }

    public int getId_integrante() {
        return id_integrante;
    }

    public void setId_integrante(int id_integrante) {
        this.id_integrante = id_integrante;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }  
}
