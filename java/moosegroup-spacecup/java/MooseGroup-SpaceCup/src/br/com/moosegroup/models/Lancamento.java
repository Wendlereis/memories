package br.com.moosegroup.models;

import java.sql.Date;

public class Lancamento {
    private int id;
    private int idGrupo;
    private String nomeGrupo;
    private String nomeFoguete;
    private double pesoFoguete;
    private double altitudeMaxima;
    private double velocidadeMaxima;
    private double tempoPropulsao;
    private double picoAceleracao;
    private double aceleracaoMedia;
    private double tempoApogeuDescida;
    private double tempoEjecao;
    private double altitudeEjecao;
    private double taxaDescida;
    private double duracaoVoo;
    private Date dataLancamento;
    private double distanciaAlvo;
    private double anguloLancamento;
    private double velocidadeVento;

    public Lancamento(int id, int idGrupo, String nomeGrupo, String nomeFoguete, double pesoFoguete, double altitudeMaxima, double velocidadeMaxima, double tempoPropulsao, double picoAceleracao, double aceleracaoMedia, double tempoApogeuDescida, double tempoEjecao, double altitudeEjecao, double taxaDescida, double duracaoVoo, Date dataLancamento, double distanciaAlvo, double anguloLancamento, double velocidadeVento) {
        this.id = id;
        this.idGrupo = idGrupo;
        this.nomeGrupo = nomeGrupo;
        this.nomeFoguete = nomeFoguete;
        this.pesoFoguete = pesoFoguete;
        this.altitudeMaxima = altitudeMaxima;
        this.velocidadeMaxima = velocidadeMaxima;
        this.tempoPropulsao = tempoPropulsao;
        this.picoAceleracao = picoAceleracao;
        this.aceleracaoMedia = aceleracaoMedia;
        this.tempoApogeuDescida = tempoApogeuDescida;
        this.tempoEjecao = tempoEjecao;
        this.altitudeEjecao = altitudeEjecao;
        this.taxaDescida = taxaDescida;
        this.duracaoVoo = duracaoVoo;
        this.dataLancamento = dataLancamento;
        this.distanciaAlvo = distanciaAlvo;
        this.anguloLancamento = anguloLancamento;
        this.velocidadeVento = velocidadeVento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public String getNomeFoguete() {
        return nomeFoguete;
    }

    public void setNomeFoguete(String nomeFoguete) {
        this.nomeFoguete = nomeFoguete;
    }

    public double getPesoFoguete() {
        return pesoFoguete;
    }

    public void setPesoFoguete(double pesoFoguete) {
        this.pesoFoguete = pesoFoguete;
    }

    public double getAltitudeMaxima() {
        return altitudeMaxima;
    }

    public void setAltitudeMaxima(double altitudeMaxima) {
        this.altitudeMaxima = altitudeMaxima;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(double velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public double getTempoPropulsao() {
        return tempoPropulsao;
    }

    public void setTempoPropulsao(double tempoPropulsao) {
        this.tempoPropulsao = tempoPropulsao;
    }

    public double getPicoAceleracao() {
        return picoAceleracao;
    }

    public void setPicoAceleracao(double picoAceleracao) {
        this.picoAceleracao = picoAceleracao;
    }

    public double getAceleracaoMedia() {
        return aceleracaoMedia;
    }

    public void setAceleracaoMedia(double aceleracaoMedia) {
        this.aceleracaoMedia = aceleracaoMedia;
    }

    public double getTempoApogeuDescida() {
        return tempoApogeuDescida;
    }

    public void setTempoApogeuDescida(double tempoApogeuDescida) {
        this.tempoApogeuDescida = tempoApogeuDescida;
    }

    public double getTempoEjecao() {
        return tempoEjecao;
    }

    public void setTempoEjecao(double tempoEjecao) {
        this.tempoEjecao = tempoEjecao;
    }

    public double getAltitudeEjecao() {
        return altitudeEjecao;
    }

    public void setAltitudeEjecao(double altitudeEjecao) {
        this.altitudeEjecao = altitudeEjecao;
    }

    public double getTaxaDescida() {
        return taxaDescida;
    }

    public void setTaxaDescida(double taxaDescida) {
        this.taxaDescida = taxaDescida;
    }

    public double getDuracaoVoo() {
        return duracaoVoo;
    }

    public void setDuracaoVoo(double duracaoVoo) {
        this.duracaoVoo = duracaoVoo;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public double getDistanciaAlvo() {
        return distanciaAlvo;
    }

    public void setDistanciaAlvo(double distanciaAlvo) {
        this.distanciaAlvo = distanciaAlvo;
    }

    public double getAnguloLancamento() {
        return anguloLancamento;
    }

    public void setAnguloLancamento(double anguloLancamento) {
        this.anguloLancamento = anguloLancamento;
    }

    public double getVelocidadeVento() {
        return velocidadeVento;
    }

    public void setVelocidadeVento(double velocidadeVento) {
        this.velocidadeVento = velocidadeVento;
    }
}
