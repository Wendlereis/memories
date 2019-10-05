package br.com.verity.agenda.bean;

import java.sql.Date;

public class Contato {
	private String nome;
	private String email;
	private String endereco;
	private Date dataNascimento;
	
	public Contato(String nome, String email, String endereco, Date dataNascimento) {
		super();
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}	
}
