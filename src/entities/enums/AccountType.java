package entities.enums;

public enum AccountType {
    CORRENTE(1), POUPANÇA(2), SALÁRIO(3);

    private final int value;

    AccountType(int optionValue) {
        value = optionValue;
    }

    public int getValor() {
        return value;
    }

}