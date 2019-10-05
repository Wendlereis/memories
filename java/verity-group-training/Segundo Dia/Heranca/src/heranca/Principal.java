package heranca;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		Loja loja = new Loja();

		Televisao televisao = new Televisao("Smart-tv", "42", "Led", 1000.0, true, 20);
		Notebook notebook = new Notebook("Inspiron 5000", "wide", "i5", "8Gb", "500Gb", 1000.0, false, 50);
		Desktop desktop = new Desktop("Inspiron 5000", "wide", "i5", "8Gb", "500Gb", 3000.0, true, 60);

		/*
		 * List<EletroEletronico> listaEletronicos = new
		 * ArrayList<EletroEletronico>(); listaEletronicos.add(televisao);
		 * listaEletronicos.add(notebook); listaEletronicos.add(desktop);
		 * 
		 * for(EletroEletronico e : listaEletronicos) { loja.vender(e); }
		 * 
		 * 
		 */
		televisao.Desligar();
		desktop.Ligar();
	}
}
