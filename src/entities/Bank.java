package entities;

import entities.enums.AccountType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Bank {
    private Map<String, BankAccount> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public Client client;

    String tConta = "";
    double saldoInicial = 0;

    LocalDateTime data = LocalDateTime.now();

    DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH");

    public void cadastrarConta() {

            Scanner scanner = new Scanner(System.in);
            System.out.println("----- Cadastro de Conta Bancária -----");
            System.out.print("Número da agência: ");
            String numeroAgencia = scanner.nextLine();
            System.out.print("Número da conta: ");
            String numeroConta = scanner.nextLine();
            System.out.print("Saldo inicial: ");
            double limite = scanner.nextDouble();
            scanner.nextLine();
            menuTipoConta();
            BankAccount conta = new BankAccount(numeroAgencia, numeroConta, saldoInicial, limite, tConta);
            accounts.put(numeroConta, conta);
            System.out.println("Conta cadastrada com sucesso.");

    }

    public void menuTipoConta() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o Tipo da conta: \n");
            for (AccountType op : AccountType.values()) {
                System.out.print(op + " = " + op.getValor() + "\n");
            }
            int op = scanner.nextInt();
            switch (op) {
                case 1:
                    System.out.print("Limite: ");
                    saldoInicial = scanner.nextDouble();
                    tConta = String.valueOf(AccountType.CORRENTE);
                    break;
                case 2:
                    tConta = String.valueOf(AccountType.POUPANÇA);
                    saldoInicial = 0;
                    break;
                case 3:
                    tConta = String.valueOf(AccountType.SALÁRIO);
                    saldoInicial = 0;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    menuTipoConta();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Digite uma opção válida! Tente novamente... \n");
            menuTipoConta();
        }
    }

    public void depositar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Depósito -----");
        System.out.print("Número da conta: ");
        String numeroConta = scanner.nextLine();
        System.out.print("Valor a ser depositado: ");
        double valor = scanner.nextDouble();

        BankAccount conta = accounts.get(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
            System.out.println("Depósito realizado com sucesso.");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void retirar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Retirada (saque) -----");
        System.out.print("Número da conta: ");
        String numeroConta = scanner.nextLine();
        System.out.print("Valor a ser retirado: ");
        double valor = scanner.nextDouble();

        BankAccount conta = accounts.get(numeroConta);
        if (conta != null) {
            conta.retirar(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void transferir() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Transferência -----");
        System.out.print("Número da conta de origem: ");
        String numeroContaOrigem = scanner.nextLine();
        System.out.print("Número da conta de destino: ");
        String numeroContaDestino = scanner.nextLine();
        System.out.print("Valor a ser transferido: ");
        double valor = scanner.nextDouble();

        BankAccount origem = accounts.get(numeroContaOrigem);
        BankAccount destino = accounts.get(numeroContaDestino);
        if (origem != null && destino != null) {
            origem.transferir(valor, destino);
            System.out.println("Transferência realizada com sucesso.");
        } else {
            System.out.println("Conta de origem ou conta de destino não encontrada.");
        }
    }

    public void alterarLimite() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Alteração de Limite -----");
        System.out.print("Número da conta: ");
        String numeroConta = scanner.nextLine();
        System.out.print("Novo limite: ");
        double novoLimite = scanner.nextDouble();

        BankAccount conta = accounts.get(numeroConta);
        if (conta != null && tConta.equals("CORRENTE")) {
            conta.alterarLimite(novoLimite);
            System.out.println("Limite alterado com sucesso.");
        } else {
            System.out.println("Conta não encontrada ou não apta a alteração de Limite.");
        }
    }

    public void exportarHistorico() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Histórico de transações -----");
        System.out.print("Digite a conta que deseja acessar: ");
        String contaHistorico = scanner.nextLine();
        BankAccount conta = accounts.get(contaHistorico);
        System.out.println(conta.getHistoricoTransacoes());
    }

    @Override
    public String toString() {
        return "Banco{" +
                "contas=" + accounts +'}';
    }
}
