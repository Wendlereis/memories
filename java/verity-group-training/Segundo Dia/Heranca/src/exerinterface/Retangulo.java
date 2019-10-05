package exerinterface;

public class Retangulo implements AreaCalculavel {
	private int largura;
	private int altura;
	
	public Retangulo(int largura, int altura) {
		this.largura = largura;
		this.altura = altura;
	}

	@Override
	public double calcularArea() {
		return largura * altura;
	}
}
