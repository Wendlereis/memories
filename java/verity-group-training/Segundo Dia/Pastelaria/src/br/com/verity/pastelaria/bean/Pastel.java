package br.com.verity.pastelaria.bean;

import java.sql.Date;

public class Pastel {
	private String nmPastel;
	private int qtdEstoque;
	private Date dtValidade;
	private String dsPastel;
	
	public Pastel(String nmPastel, int qtdEstoque, Date dtValidade, String dsPastel) {
		this.nmPastel = nmPastel;
		this.qtdEstoque = qtdEstoque;
		this.dtValidade = dtValidade;
		this.dsPastel = dsPastel;
	}
	
	public String getNmPastel() {
		return nmPastel;
	}
	public int getQtdEstoque() {
		return qtdEstoque;
	}
	public Date getDtValidade() {
		return dtValidade;
	}
	public String getDsPastel() {
		return dsPastel;
	}

	@Override
	public String toString() {
		return "Pastel [nmPastel=" + nmPastel + ", qtdEstoque=" + qtdEstoque + ", dtValidade=" + dtValidade
				+ ", dsPastel=" + dsPastel + "]";
	}	
}
