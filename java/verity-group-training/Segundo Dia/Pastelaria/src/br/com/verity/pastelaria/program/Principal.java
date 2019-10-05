package br.com.verity.pastelaria.program;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.*;

import br.com.verity.pastelaria.bean.Pastel;
import br.com.verity.pastelaria.dao.PastelDAO;

public class Principal {
	
	public static void main(String[] args){
		int menu = 0;
        
        do {            
            menu = Integer.parseInt(showInputDialog("1 -- Cadastrar Pastel \n2 -- Pesquisar Todos Pasteis \n3 -- Deletar Pastel \n4 -- Atualizar Pastel \n0 -- Sair"));
        
            switch(menu){
                case 1:
                    Cadastrar();
                    break;                
                case 2:
                    Pesquisar();
                    break;
                case 3:
                    Deletar();
                    break;
                case 4:
                    Atualizar();
                    break;
            }
        } while (menu > 0 && menu <= 5);   
	}
	
	public static void Cadastrar(){
		String nmPastel = showInputDialog("Sabor Pastel");
		int qtdEstoque = Integer.parseInt(showInputDialog("Quantidade Pasteis"));		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dsPastel = showInputDialog("Descrição Pastel");
		
		try {
			Date dtValidade = new Date(dateFormat.parse(showInputDialog("Data Validade")).getTime());
			
			Pastel pastel = new Pastel(nmPastel, qtdEstoque, dtValidade, dsPastel);
			
			PastelDAO pastelDao = new PastelDAO();
			pastelDao.inserirPastel(pastel);
			
			showMessageDialog(null, "Pastel Cadastrado");
			
		} 
		catch (ParseException e) {
			showMessageDialog(null, "Erro ao converter data: " + e);
		}
	}
	
	public static void Pesquisar(){
		List<Pastel> pasteis = new ArrayList<Pastel>();
		String listaPasteis = "";		
		
		PastelDAO cp = new PastelDAO();
		pasteis = cp.getPasteis();
		
		if (pasteis != null) {
			for(Pastel p : pasteis){
				listaPasteis += "Pastel: " + p.getNmPastel() + " Quantidade: " + p.getQtdEstoque() + " Data Validade: " + p.getDtValidade() + " Descricao: " + p.getDsPastel() + "\n";
			}
		}
		
		showMessageDialog(null, listaPasteis);
	}
	
	public static void Deletar(){
		String nmPastel = showInputDialog("Sabor do Pastel");
		
		PastelDAO pastelDao = new PastelDAO();
		pastelDao.deletarPastel(nmPastel);
		
		showMessageDialog(null, "Pastel Excluido");
	}
	
	public static void Atualizar(){
		String saborPastel = showInputDialog("Qual pastel deseja atualizar?");
		
		String nmPastel = showInputDialog("Novo Sabor Pastel");
		int qtdEstoque = Integer.parseInt(showInputDialog("Nova Quantidade Pasteis"));		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dsPastel = showInputDialog("Nova Descrição Pastel");
		
		try {
			Date dtValidade = new Date(dateFormat.parse(showInputDialog("Data Validade")).getTime());
			
			Pastel pastel = new Pastel(nmPastel, qtdEstoque, dtValidade, dsPastel);
			
			PastelDAO pastelDao = new PastelDAO();
			pastelDao.atualizarPastel(pastel, saborPastel);
			
			showMessageDialog(null, "Pastel Atualizado");
			
		} 
		catch (ParseException e) {
			showMessageDialog(null, "Erro ao converter data: " + e);
		}
	}
}
