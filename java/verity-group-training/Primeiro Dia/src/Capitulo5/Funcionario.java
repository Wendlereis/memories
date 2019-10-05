package Capitulo5;

public class Funcionario {   
    private String nome;
    private Conta conta;
    
    //Funcionario f = new Funcionario("abc", conta);
    
    public Funcionario(String nome, Conta conta) {
        this.nome = nome;
        this.conta = conta;
    }

    public Conta getConta() {
        return conta;
    }    
    
    public String getNome() {
        return nome;
    }
}
