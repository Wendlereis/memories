package Capitulo5;

import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.*;
        
public class PrincipalCapitulo5 {
    
    public static void main(String[] ars) {     
        List<Funcionario> funcionarios = new ArrayList<>();
        
        
        
        int menu = 0;
        
        do {            
            menu = Integer.parseInt(showInputDialog("1 -- Cadastrar funcionarios \n2 -- Efetuar Saque \n3 -- Efetuar Deposito \n0 --Sair"));
        
            switch(menu){
                case 1:
                    funcionarios = inserirFuncionarios(funcionarios);
                    break;                
                case 2:
                    EfeturarSaque(funcionarios);
                    break;
                case 3:
                    EfeturarDeposito(funcionarios);
                    break;
            }
        } while (menu > 0 && menu <= 3);           
    }
       
    public static List<Funcionario> inserirFuncionarios(List<Funcionario> funcionarios){
        Funcionario funcionario = null;
        Conta conta = null;
        
        String opc = "";
                
        do{
            String nome = showInputDialog("Nome");
            int numeroConta = Integer.parseInt(showInputDialog("Numero da Conta"));
            double saldo = Double.parseDouble(showInputDialog("Saldo"));
            
            funcionarios.add(funcionario = new Funcionario(nome, conta = new Conta(numeroConta, saldo)));

            opc = showInputDialog("Continuar [S/N]");
        }while (opc.equalsIgnoreCase("s"));
        
        return funcionarios;
    }

    public static void EfeturarSaque(List<Funcionario> funcionarios){
        String nome = showInputDialog("Titular Conta");
        int numeroConta = Integer.parseInt(showInputDialog("Numero da Conta"));
        double valor = Double.parseDouble(showInputDialog("Saque"));
                
        for(Funcionario f : funcionarios){
            if(f.getNome().equalsIgnoreCase(nome) && f.getConta().getNumeroConta() == numeroConta) {
                double saldo = f.getConta().sacar(valor);
                
                showMessageDialog(null, "Nome: " + f.getNome() + " Saldo: " + saldo);
            }
        }
    }
    
    public static void EfeturarDeposito(List<Funcionario> funcionarios){
        String nome = showInputDialog("Titular Conta");
        int numeroConta = Integer.parseInt(showInputDialog("Numero da Conta"));
        double valor = Double.parseDouble(showInputDialog("Depositar"));
        
        for(Funcionario f : funcionarios){
            if(f.getNome().equalsIgnoreCase(nome) && f.getConta().getNumeroConta() == numeroConta) {
                double saldo = f.getConta().depositar(valor);
               
                showMessageDialog(null, "Nome: " + f.getNome() + " Saldo: " + saldo);
            }
        }
    }
    
}