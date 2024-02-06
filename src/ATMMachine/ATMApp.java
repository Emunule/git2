package ATMMachine;

import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String pin;
    private double balance;

    public BankAccount(String accountNumber, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public boolean validatePin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: $" + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your PIN: ");
        String enteredPin = scanner.nextLine();

        if (bankAccount.validatePin(enteredPin)) {
            System.out.println("Login successful.");
            displayMenu();
            int choice = scanner.nextInt();
            processChoice(choice);
        } else {
            System.out.println("Invalid PIN. Login failed.");
        }
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private void processChoice(int choice) {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case 1:
                System.out.println("Current balance: $" + bankAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter withdrawal amount: $");
                double withdrawalAmount = scanner.nextDouble();
                bankAccount.withdraw(withdrawalAmount);
                break;
            case 4:
                System.out.println("Exiting. Thank you for using the ATM.");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
        scanner.close();
    }
}

public class ATMApp {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("123456789", "1234", 1000.0);
        ATM atm = new ATM(account1);
        atm.start();
    }
}

