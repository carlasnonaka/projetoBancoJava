package entities;

import java.util.Scanner;

public class Client {

    private String nome;

    private String rg;

    private String cpf;

    private String telefone;

    private String endereco;

    public Client() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Cadastro de Cliente -----");
        System.out.print("Nome: ");
        nome = scanner.nextLine();
        System.out.print("RG: ");
        rg = scanner.nextLine();
        System.out.print("CPF: ");
        cpf = scanner.nextLine();
        System.out.print("TELEFONE: ");
        telefone = scanner.nextLine();
        System.out.print("ENDEREÇO: ");
        endereco = scanner.nextLine();

        Client client = new Client(nome, rg, cpf, telefone, endereco);
    }
    public Client(String nome, String rg, String cpf, String telefone, String endereco) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Client(String nome, String rg, String cpf, String telefone) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void cadastrarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Cadastro de Cliente -----");
        System.out.print("Nome: ");
        this.nome = scanner.nextLine();
        System.out.print("RG: ");
        this.rg = scanner.nextLine();
        System.out.print("CPF: ");
        this.cpf = scanner.nextLine();
        System.out.print("TELEFONE: ");
        this.telefone = scanner.nextLine();
        System.out.print("ENDEREÇO: ");
        this.endereco = scanner.nextLine();
        scanner.close();
    }
    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", rg=" + rg +
                ", cpf=" + cpf +
                ", telefone=" + telefone +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
