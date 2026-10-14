package Cafeteria.cafeteria;

public class Cafe {

    private String nome;
    private double preco;
    private int estoque;

    public Cafe(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public boolean estaEsgotado() {
        return estoque == 0;
    }

    public boolean retirarEstoque(int quantidade) {
        if (quantidade > 0 && quantidade <= estoque) {
            estoque -= quantidade;
            return true;
        }
        return false;
    }
}