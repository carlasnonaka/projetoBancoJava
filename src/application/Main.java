package application;

import entities.Bank;

import java.util.InputMismatchException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        menu();

        }
        public static void menu() {
            Scanner scanner = new Scanner(System.in);
            Bank banco = new Bank();
            try {
                int opcao;
                do {
                    System.out.println("----- Menu -----");
                    System.out.println("1. Cadastro de conta bancária");
                    System.out.println("2. Depósito");
                    System.out.println("3. Retirada (saque)");
                    System.out.println("4. Alteração de limite");
                    System.out.println("5. Transferência");
                    System.out.println("6. Exportar histórico de transações (CSV)");
                    System.out.println("7. Visualizar contas cadastradas");
                    System.out.println("0. Sair");
                    System.out.print("Escolha uma opção: ");
                    opcao = scanner.nextInt();

                    switch (opcao) {
                        case 1:
                            banco.cadastrarConta();
                            break;
                        case 2:
                            banco.depositar();
                            break;
                        case 3:
                            banco.retirar();
                            break;
                        case 4:
                            banco.alterarLimite();
                            break;
                        case 5:
                            banco.transferir();
                            break;
                        case 6:
                            banco.exportarHistorico();
                            break;
                        case 7:
                            System.out.println(banco.toString());
                            break;
                        case 0:
                            System.out.println("Saindo...");
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                } while (opcao != 0);
            }
            catch (InputMismatchException e) {
                System.out.println("Digite uma opção válida!\n");
                menu();
            }
        }

    }