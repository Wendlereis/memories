package Capitulo4;

import javax.swing.JOptionPane;

public class PrincipalCapitulo4 {
    public static void main(String[] args) {
        //Criacao Empresa
        Empresa myCompany = new Empresa("Verity", "01/01/2017");
        
        //Criacao Funcionarios	
        String opc = "";

        do {
            String nome = JOptionPane.showInputDialog("Nome");
            int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade"));
            String sexo = JOptionPane.showInputDialog("Sexo");
            int tempoDeEmpresa = Integer.parseInt(JOptionPane.showInputDialog("Tempo de Empresa"));
            double salario = Double.parseDouble(JOptionPane.showInputDialog("Salario"));

            myCompany.setfuncionario(new Funcionario(nome, idade, sexo, tempoDeEmpresa, salario));

            opc = JOptionPane.showInputDialog("Inserir mais funcionarios [S/N]");
        }while(opc.equalsIgnoreCase("s"));

        JOptionPane.showMessageDialog(null, myCompany.toString() + "\nTotal Salarios: " + Funcionario.getSalarios(myCompany));
    }	
}
