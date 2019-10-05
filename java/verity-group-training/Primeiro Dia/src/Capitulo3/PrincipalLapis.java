package Capitulo3;

public class PrincipalLapis {
    
    public static void main(String[] args) {
        String cor = "preto";
        String formato = "quadrado";
        String material =  "madeira";

        Lapis meuLapis = new Lapis(cor, formato, material);

        meuLapis.escrever("Meu Primeiro Texto");		
    }
}
