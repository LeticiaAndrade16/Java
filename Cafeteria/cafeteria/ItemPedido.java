package Cafeteria.cafeteria;

public class ItemPedido {

    private Cafe cafe;
    private int quantidade;

    public ItemPedido(Cafe cafe, int quantidade) {
        this.cafe = cafe;
        this.quantidade = quantidade;
    }

    public Cafe getCafe() {
        return cafe;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void adicionarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public double getSubtotal() {
        return cafe.getPreco() * quantidade;
    }
}