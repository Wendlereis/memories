package Capitulo4;

import Capitulo4.Empresa;

public class Funcionario {
    String nome;
    String sexo;
    int idade;	
    int tempoDeEmpresa;
    double salario;

    public Funcionario(String nome, int idade, String sexo, int tempoDeEmpresa, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.tempoDeEmpresa = tempoDeEmpresa;
        this.salario = salario;
        //this.conta = conta;
    }

    public static double getSalarios(Empresa e){
        double totalSalario = 0;

        for(Funcionario f : e.funcionario){
            totalSalario += f.salario;
        }

        return totalSalario;
    }

    @Override
    public String toString() {
        return "O Funcionario: " + nome;
    }  
}
