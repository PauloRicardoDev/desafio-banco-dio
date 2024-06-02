package io.github.pauloricardodev;

import io.github.pauloricardodev.entities.Banco;
import io.github.pauloricardodev.entities.Cliente;
import io.github.pauloricardodev.entities.ContaCorrente;
import io.github.pauloricardodev.entities.ContaPoupanca;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Cliente cliente1 = new Cliente("João Silva", "123.456.789-00");
        Cliente cliente2 = new Cliente("Maria Souza", "987.654.321-00");

        ContaCorrente cc1 = new ContaCorrente(cliente1, 500.0);
        ContaPoupanca cp1 = new ContaPoupanca(cliente2, 0.01);

        banco.adicionarConta(cc1);
        banco.adicionarConta(cp1);

        cc1.depositar(1000);
        cp1.depositar(1500);

        System.out.println("Saldo Conta Corrente João: " + cc1.getSaldo());
        System.out.println("Saldo Conta Poupança Maria: " + cp1.getSaldo());

        banco.transferir(cc1.getNumero(), cp1.getNumero(), 200);

        System.out.println("Saldo Conta Corrente João após transferência: " + cc1.getSaldo());
        System.out.println("Saldo Conta Poupança Maria após transferência: " + cp1.getSaldo());

        cp1.aplicarRendimento();

        System.out.println("Saldo Conta Poupança Maria após rendimento: " + cp1.getSaldo());
    }
}