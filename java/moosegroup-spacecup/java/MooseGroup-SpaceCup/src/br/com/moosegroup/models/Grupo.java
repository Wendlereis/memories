package br.com.moosegroup.models;

import javax.swing.JOptionPane;

public class Grupo extends Usuario {
    private int idGrupo;
    private String nome;
    private int idTurma;
    private String turma;
    private int idFoguete;
    private String foguete;
    private double pesoFoguete;    

    public Grupo(int idGrupo, String nome, int idTurma, String turma, int idFoguete, String foguete, int id, String nomeAcesso, String senha, Double pesoFoguete) {
        super(id, nomeAcesso, senha);
        this.idGrupo = idGrupo;;
        this.nome = nome;
        this.idTurma = idTurma;
        this.turma = turma;
        this.idFoguete = idFoguete;
        this.foguete = foguete;
        this.pesoFoguete = pesoFoguete; 
    } 

    public Grupo(String nome, String turma, String foguete, String nomeAcesso, String senha) {
        super(nomeAcesso, senha);
        this.nome = nome;
        this.turma = turma;
        this.foguete = foguete;
    }   
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getFoguete() {
        return foguete;
    }

    public void setFoguete(String foguete) {
        this.foguete = foguete;
    }   

    public double getPesoFoguete() {
        return pesoFoguete;
    }

    public void setPesoFoguete(double pesoFoguete) {
        this.pesoFoguete = pesoFoguete;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public int getIdFoguete() {
        return idFoguete;
    }

    public void setIdFoguete(int idFoguete) {
        this.idFoguete = idFoguete;
    }
}
