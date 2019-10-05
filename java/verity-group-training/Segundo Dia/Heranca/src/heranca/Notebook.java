package heranca;

import static javax.swing.JOptionPane.*;

public class Notebook extends EletroEletronico implements Acao {
	private String processador;
	private String memoria;
	private String armazenamento;
	
	public Notebook(String modelo, String tamanho, String processador, String memoria, String armazenamento, double valor, boolean promocao, double taxaDesconto) {
		super(modelo, tamanho, valor, promocao, taxaDesconto);
		this.processador = processador;
		this.memoria = memoria;
		this.armazenamento = armazenamento;
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public String getArmazenamento() {
		return armazenamento;
	}

	public void setArmazenamento(String armazenamento) {
		this.armazenamento = armazenamento;
	}

	@Override
	public void Ligar() {
		showMessageDialog(null, "O note esta ligado");		
	}

	@Override
	public void Desligar() {
		showMessageDialog(null, "O note esta desligado");
	}

}
