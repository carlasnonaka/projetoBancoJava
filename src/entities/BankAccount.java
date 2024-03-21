package entities;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
        private String numeroAgencia;
        private String numeroConta;
        private double saldo;
        private String tipoConta;
        private double limite;

        private Client client;
        private List<String> historicoTransacoes;

    public BankAccount(String numeroConta, String numeroAgencia, double saldo, double limite, String tipoConta) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.limite = limite;
        this.client = new Client();
        this.historicoTransacoes = new ArrayList<>();
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public void depositar(double valor) {
            saldo += valor;
            historicoTransacoes.add("Depósito: +" + valor);
        }

        public void retirar(double valor) {
            if (saldo + limite >= valor) {
                saldo -= valor;
                historicoTransacoes.add("Retirada (saque): -" + valor);
            } else {
                System.out.println("Saldo insuficiente.");
            }
        }

        public void transferir(double valor, BankAccount destinatario) {
            if (saldo + limite >= valor) {
                saldo -= valor;
                destinatario.depositar(valor);
                historicoTransacoes.add("Transferência para conta " + destinatario.client + ": -" + valor);
            } else {
                System.out.println("Saldo insuficiente.");
            }
        }

        public void alterarLimite(double novoLimite) {
            this.limite = novoLimite;
            historicoTransacoes.add("Limite alterado para " + novoLimite);
        }

        public void atualizarSaldoAtual(double saldo) {
            this.saldo = saldo;
            historicoTransacoes.add("Saldo Atual " + saldo);
        }

        public List<String> getHistoricoTransacoes() {
            atualizarSaldoAtual(this.saldo);
            return historicoTransacoes;
        }

    @Override
    public String toString() {
        return "BankAccount{" +
                "numeroAgencia='" + numeroAgencia + '\'' +
                ", numeroConta='" + numeroConta + '\'' +
                ", saldo=" + saldo +
                ", tipoConta='" + tipoConta + '\'' +
                ", limite=" + limite +
                ", client=" + client +
                ", historicoTransacoes=" + historicoTransacoes +
                '}';
    }
}
