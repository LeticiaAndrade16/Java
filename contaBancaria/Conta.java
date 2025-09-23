package ContaBancaria;

public class Conta {
    private int numero;
    private double saldo;

    public Conta(int numero, double saldoInicial) {
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public double consultarSaldo() {
        return saldo;
    }
}
