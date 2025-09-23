package ContaBancaria;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner c = new Scanner(System.in)) {

            System.out.println("=== Conta Bancária ===");

            System.out.print("Número da Conta: ");
            int numeroConta = c.nextInt();

            System.out.print("Saldo Inicial: ");
            double saldo = c.nextDouble();

            Conta conta = new Conta(numeroConta, saldo);

            System.out.println("\nO que gostaria de fazer?");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Consultar Saldo");
            System.out.print("Opção: ");
            int op = c.nextInt();

            switch (op) {
                case 1 -> {
                    System.out.print("Informe o valor a ser depositado: ");
                    double valor = c.nextDouble();
                    conta.depositar(valor);
                    System.out.printf("Valor depositado: %.2f\n", valor);
                    System.out.printf("Saldo atual: %.2f\n", conta.consultarSaldo());
                }
                case 2 -> {
                    System.out.print("Informe o valor que gostaria de sacar: ");
                    double sacar = c.nextDouble();
                    if (conta.sacar(sacar)) {
                        System.out.printf("Saque realizado: %.2f\n", sacar);
                    } else {
                        System.out.println("Saldo insuficiente para saque.");
                    }
                    System.out.printf("Saldo atual: %.2f\n", conta.consultarSaldo());
                }
                case 3 -> {
                    System.out.printf("Saldo atual: %.2f\n", conta.consultarSaldo());
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
