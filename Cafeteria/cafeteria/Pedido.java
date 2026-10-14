package Cafeteria.cafeteria;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<ItemPedido> itens = new ArrayList<>();

    public void adicionarItem(Cafe cafe, int quantidade) {
        for (ItemPedido item : itens) {
            if (item.getCafe() == cafe) {
                item.adicionarQuantidade(quantidade);
                return;
            }
        }
        itens.add(new ItemPedido(cafe, quantidade));
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public boolean estaVazio() {
        return itens.isEmpty();
    }

    public double calcularTotal() {
        double total = 0;

        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }

        return total;
    }
}