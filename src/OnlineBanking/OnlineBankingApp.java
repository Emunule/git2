package OnlineBanking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    private String username;
    private String password;
    private double balance;

    public User(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class OnlineBanking {
    private Map<String, User> users;

    public OnlineBanking() {
        users = new HashMap<>();
    }

    public void addUser(String username, String password, double initialBalance) {
        users.put(username, new User(username, password, initialBalance));
    }

    public boolean authenticateUser(String username, String password) {
        User user = users.get(username);
        return user != null && user.authenticate(password);
    }

    public double getBalance(String username) {
        return users.get(username).getBalance();
    }

    public void deposit(String username, double amount) {
        users.get(username).deposit(amount);
    }

    public boolean withdraw(String username, double amount) {
        return users.get(username).withdraw(amount);
    }
}

public class OnlineBankingApp {
    public static void main(String[] args) {
        OnlineBanking onlineBanking = new OnlineBanking();
        onlineBanking.addUser("user1", "password1", 1000);
        onlineBanking.addUser("user2", "password2", 1500);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (onlineBanking.authenticateUser(username, password)) {
            System.out.println("Login successful.");
            System.out.println("Balance: $" + onlineBanking.getBalance(username));
            System.out.print("Enter deposit amount: $");
            double depositAmount = scanner.nextDouble();
            onlineBanking.deposit(username, depositAmount);
            System.out.println("New balance after deposit: $" + onlineBanking.getBalance(username));
            System.out.print("Enter withdrawal amount: $");
            double withdrawalAmount = scanner.nextDouble();
            if (onlineBanking.withdraw(username, withdrawalAmount)) {
                System.out.println("Withdrawal successful.");
                System.out.println("New balance after withdrawal: $" + onlineBanking.getBalance(username));
            } else {
                System.out.println("Insufficient funds for withdrawal.");
            }
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
        scanner.close();
    }
}
