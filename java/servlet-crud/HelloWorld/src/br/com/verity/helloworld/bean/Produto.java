package br.com.verity.helloworld.bean;

import java.sql.Date;

public class Produto {
	private int id;
	private String nome;
	private Date dataCompra;
	private String descricao;
	private int qtEstoque;
	private double preco;
	
	public Produto(int id, String nome, Date dataCompra, String descricao, int qtEstoque, double preco) {
		this.id = id;
		this.nome = nome;
		this.dataCompra = dataCompra;
		this.descricao = descricao;
		this.qtEstoque = qtEstoque;
		this.preco = preco;
	}
	
	public Produto(String nome, Date dataCompra, String descricao, int qtEstoque, double preco) {
		this.nome = nome;
		this.dataCompra = dataCompra;
		this.descricao = descricao;
		this.qtEstoque = qtEstoque;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataCompra() {
		return dataCompra;
	}
	
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getQtEstoque() {
		return qtEstoque;
	}
	
	public void setQtEstoque(int qtEstoque) {
		this.qtEstoque = qtEstoque;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
}
