package Capitulo3;

public class Lapis {
    String cor;
    String formato;
    String grafite;
    String material;

    public Lapis() {}

    public Lapis(String cor, String formato, String material) {
        this.cor = cor;
        this.formato = formato;
        this.material = material;
    }

    public void escrever(String texto){
        System.out.println(texto);
    }
}
