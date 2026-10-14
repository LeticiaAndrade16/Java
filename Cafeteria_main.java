package Cafeteria;

import Cafeteria.cafeteria.*;

import java.util.Scanner;

public class Cafeteria_main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Cafe[] cardapio = {
                new Cafe("Expresso", 5.00, 20),
                new Cafe("Cappuccino", 8.50, 10),
                new Cafe("Latte", 10.00, 10),
                new Cafe("Americano", 3.50, 20),
                new Cafe("Café com Leite", 4.00, 10)
        };

        System.out.println("============= Bem-vindo à Cafeteria =============");

        while (true) {

            System.out.println("\n========== MENU ==========");
            System.out.println("1 - Fazer Pedido");
            System.out.println("2 - Ver Estoque");
            System.out.println("0 - Sair");

            int menu = lerInt("Informe a opção: ");

            if (menu == 1) {
                fazerPedido(cardapio);
            } else if (menu == 2) {
                verEstoque(cardapio);
            } else if (menu == 0) {
                System.out.println("Obrigado por utilizar a cafeteria!");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }

    static void fazerPedido(Cafe[] cardapio) {

        Pedido pedido = new Pedido();

        while (true) {

            System.out.println("\n========== FAZER PEDIDO ==========");
            for (int i = 0; i < cardapio.length; i++) {
                Cafe c = cardapio[i];
                String situacao = c.estaEsgotado() ? " (ESGOTADO)" : "";
                System.out.printf("%d - %s - R$ %.2f%s%n", i + 1, c.getNome(), c.getPreco(), situacao);
            }
            System.out.println("0 - Finalizar Pedido");

            int opcao = lerInt("Escolha uma opção: ");

            if (opcao == 0) {
                break;
            }

            if (opcao < 1 || opcao > cardapio.length) {
                System.out.println("Opção inválida!");
                continue;
            }

            Cafe produto = cardapio[opcao - 1];

            int quantidade = lerInt("Quantidade: ");

            if (quantidade <= 0) {
                System.out.println("Quantidade inválida!");
                continue;
            }

            if (produto.retirarEstoque(quantidade)) {
                pedido.adicionarItem(produto, quantidade);
                System.out.println(quantidade + "x " + produto.getNome() + " adicionado!");

                if (produto.estaEsgotado()) {
                    System.out.println("Atenção: " + produto.getNome() + " acabou no estoque!");
                }
            } else {
                System.out.println("Estoque insuficiente! Disponível: " + produto.getEstoque());
            }
        }

        if (pedido.estaVazio()) {
            System.out.println("Nenhum item no pedido.");
            return;
        }

        System.out.println("\n========== PEDIDO ==========");
        for (ItemPedido item : pedido.getItens()) {
            System.out.printf("%dx %s - R$ %.2f%n",
                    item.getQuantidade(), item.getCafe().getNome(), item.getSubtotal());
        }

        double total = pedido.calcularTotal();
        System.out.printf("Total: R$ %.2f%n", total);

        double pago = lerDouble("Valor pago: R$ ");
        while (pago < total) {
            System.out.printf("Valor insuficiente! Faltam R$ %.2f%n", total - pago);
            pago = lerDouble("Valor pago: R$ ");
        }

        System.out.printf("Troco: R$ %.2f%n", pago - total);
        System.out.println("Obrigada pela preferência!");
    }

    static void verEstoque(Cafe[] cardapio) {
        System.out.println("\n========== ESTOQUE ==========");
        for (Cafe c : cardapio) {
            System.out.println(c.getNome() + ": " + c.getEstoque());
        }
    }

    static int lerInt(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido!");
            }
        }
    }

    static double lerDouble(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Double.parseDouble(sc.nextLine().trim().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor válido!");
            }
        }
    }
}