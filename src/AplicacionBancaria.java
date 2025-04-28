import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AplicacionBancaria {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int PAUSE_SECONDS = 3;

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Jotaro Kujo", "Corriente", 340000);
        System.out.println("******************************");
        System.out.println("Cliente: " + account.getOwnerName());
        System.out.println("Tipo de cuenta: " + account.getAccountType());
        System.out.println("******************************");

        int opcion;
        do {
            printMenu();
            opcion = getIntInput("Seleccione una opción:");
            switch (opcion) {
                case 1 -> {
                    account.displayBalance();
                    pauseSeconds(PAUSE_SECONDS);
                }
                case 2 -> {
                    handleWithdrawal(account);
                    pauseSeconds(PAUSE_SECONDS);
                }
                case 3 -> {
                    handleDeposit(account);
                    pauseSeconds(PAUSE_SECONDS);
                }
                case 4 -> {
                    handleCurrencyConversion(account);
                    pauseSeconds(PAUSE_SECONDS);
                }
                case 9 -> System.out.println("Sesión finalizada. Gracias por su preferencia.");
                default -> {
                    System.out.println("Opción no válida. Intente nuevamente.");
                    pauseSeconds(PAUSE_SECONDS);
                }
            }
        } while (opcion != 9);
    }

    private static void printMenu() {
        System.out.println("\n*** Menú de Opciones ***");
        System.out.println("1 - Consultar saldo");
        System.out.println("2 - Retirar fondos");
        System.out.println("3 - Depositar fondos");
        System.out.println("4 - Conversión de moneda");
        System.out.println("9 - Salir");
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt + " ");
        while (!SCANNER.hasNextInt()) {
            System.out.print("Entrada inválida. " + prompt + " ");
            SCANNER.next();
        }
        int value = SCANNER.nextInt();
        SCANNER.nextLine();
        return value;
    }

    private static double getDoubleInput(String prompt) {
        System.out.print(prompt + " ");
        while (!SCANNER.hasNextDouble()) {
            System.out.print("Entrada inválida. " + prompt + " ");
            SCANNER.next();
        }
        double value = SCANNER.nextDouble();
        SCANNER.nextLine();
        return value;
    }

    private static void handleWithdrawal(BankAccount account) {
        double monto = getDoubleInput("Ingrese el monto a retirar:");
        account.withdraw(monto);
    }

    private static void handleDeposit(BankAccount account) {
        double monto = getDoubleInput("Ingrese el monto a depositar:");
        account.deposit(monto);
    }

    private static void handleCurrencyConversion(BankAccount account) {
        System.out.println("Seleccione tipo de conversión:");
        System.out.println("1 - Colones a Dólares");
        System.out.println("2 - Dólares a Colones");
        int opcion = getIntInput("Opción:");
        switch (opcion) {
            case 1 -> {
                double dolares = account.convertToDollars();
                System.out.printf("Saldo en Dólares: %.2f USD%n", dolares);
            }
            case 2 -> {
                double colones = account.convertToColones();
                System.out.printf("Saldo en Colones: %.2f CRC%n", colones);
            }
            default -> System.out.println("Opción de conversión no válida.");
        }
    }

    private static void pauseSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class BankAccount {
    private final String ownerName;
    private final String accountType;
    private double balance;
    private static final double EXCHANGE_RATE = 540.0; // Colones por Dólar

    public BankAccount(String ownerName, String accountType, double initialBalance) {
        this.ownerName = ownerName;
        this.accountType = accountType;
        this.balance = initialBalance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void displayBalance() {
        System.out.printf("Saldo disponible: %.2f CRC%n", balance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("El monto de depósito debe ser mayor que cero.");
        } else {
            balance += amount;
            printReceipt("Depósito", amount);
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("El monto de retiro debe ser mayor que cero.");
        } else if (amount > balance) {
            System.out.println("Fondos insuficientes para completar la operación.");
        } else {
            balance -= amount;
            printReceipt("Retiro", amount);
        }
    }

    public double convertToDollars() {
        return balance / EXCHANGE_RATE;
    }

    public double convertToColones() {
        return balance * EXCHANGE_RATE;
    }

    private void printReceipt(String transactionType, double amount) {
        LocalDateTime fechaHora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("-------------------------------");
        System.out.println(transactionType.toUpperCase() + " EXITOSO");
        System.out.println("Fecha/Hora: " + fechaHora.format(formato));
        System.out.printf((transactionType.equalsIgnoreCase("Depósito") ? "Monto depositado: %.2f CRC%n" : "Monto retirado: %.2f CRC%n"), amount);
        System.out.printf("Saldo actualizado: %.2f CRC%n", balance);
        System.out.println("-------------------------------");
    }
}

