package Capitulo4;

import java.util.ArrayList;

public class Empresa {
    String nome;
    String fundacao;
    ArrayList<Funcionario> funcionario = new ArrayList<>();

    public Empresa(String nome, String fundacao) {
        this.fundacao = fundacao;
        this.nome = nome;
    }

    public void setfuncionario(Funcionario func) {
        funcionario.add(func);
    }

    public String listarFuncioarios() {
        String func = "";

        for(Funcionario f : funcionario) {
                func += "\nNome: " + f.nome + " trabalha a: " + f.tempoDeEmpresa + " anos" + " Salario: " + f.salario;
        }

        return func;
    }

    @Override
    public String toString() {
        return "\nEmpresa: " + nome + "\nCriada em: " + fundacao + "\nOs funcionarios da empresa: " + listarFuncioarios();
    }
}
