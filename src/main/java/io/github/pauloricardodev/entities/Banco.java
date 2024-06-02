package io.github.pauloricardodev.entities;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public Conta buscarContaPorNumero(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

    public void transferir(int numeroOrigem, int numeroDestino, double valor) {
        Conta contaOrigem = buscarContaPorNumero(numeroOrigem);
        Conta contaDestino = buscarContaPorNumero(numeroDestino);

        if (contaOrigem != null && contaDestino != null) {
            contaOrigem.sacar(valor);
            contaDestino.depositar(valor);
        } else {
            System.out.println("Conta de origem ou destino não encontrada.");
        }
    }
}
