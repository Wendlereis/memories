package Capitulo5;

import javax.swing.JOptionPane;

public class Conta {
    private int numeroConta;
    private double saldo;

    public Conta(int numeroConta, double saldo) {
        this.saldo = saldo;
        this.numeroConta = numeroConta;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public double sacar(double valor) {
        if (valor < saldo) {
            saldo -= valor;
            JOptionPane.showMessageDialog(null, "Saque efetuado");
        }
        else {
            JOptionPane.showMessageDialog(null, "Não foi possivel sacar");
        }
        
        return getSaldo();
    }

    public double depositar(double valor) {
        if(valor > 0){
            saldo += valor;
            JOptionPane.showMessageDialog(null, "Deposito efetuado");
        }
        else {
            JOptionPane.showMessageDialog(null, "Não foi possivel depositar");
        }
        
        return getSaldo();
    }	
}
