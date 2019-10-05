package heranca;

public abstract class EletroEletronico {
	private String modelo;
	private String tamanho;
	private double valor;
	private boolean promocao;
	private double taxaDesconto;
	
	public EletroEletronico(String modelo, String tamanho, double valor, boolean promocao, double taxaDesconto) {
		this.modelo = modelo;
		this.tamanho = tamanho;
		this.valor = valor;
		this.promocao = promocao;
		this.taxaDesconto = taxaDesconto;
	}
		
	public double getTaxaDesconto() {
		return taxaDesconto;
	}

	public void setTaxaDesconto(double taxaDesconto) {
		this.taxaDesconto = taxaDesconto;
	}

	public String getModelo() {
		return modelo;
	}

	public String getTamanho() {
		return tamanho;
	}
	
	public double getValor() {
		return valor;
	}
	
	public boolean getPromocao() {
		return promocao;
	}
}
