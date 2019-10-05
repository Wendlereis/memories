package heranca;

import static javax.swing.JOptionPane.showMessageDialog;

public class Televisao extends EletroEletronico implements Acao {
	private String tipoTela;

	public Televisao(String modelo, String tamanho, String tipoTela, double valor, boolean promocao, double taxaDesconto) {
		super(modelo, tamanho, valor, promocao, taxaDesconto);
		this.tipoTela = tipoTela;
	}

	public String getTipoTela() {
		return tipoTela;
	}

	@Override
	public void Ligar() {
		showMessageDialog(null, "A televisao esta ligado");		
	}

	@Override
	public void Desligar() {
		showMessageDialog(null, "A televisao esta desligado");
	}
}
