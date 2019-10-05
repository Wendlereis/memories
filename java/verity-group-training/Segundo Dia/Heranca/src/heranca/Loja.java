package heranca;

import static javax.swing.JOptionPane.*;

public class Loja {
	
	public void vender(EletroEletronico e){
		double valorTotal = e.getValor();
		
		showMessageDialog(null, "Valor seu eletronico sem desconto: " + e.getValor());
		
		if (e.getPromocao() == true) {
			valorTotal -= aplicarPromocao(e);
		}
		
		showMessageDialog(null, "Valor total sua compra: " + valorTotal);
	}
	
	public double aplicarPromocao(EletroEletronico e){
		return e.getValor() * e.getTaxaDesconto() / 100;
	}
}
