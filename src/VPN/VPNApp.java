package VPN;

import java.util.Scanner;

public class VPNApp {
    public static void main(String[] args) {
        System.out.println("Welcome to MyVPN!");

        // Simulating user authentication
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (authenticateUser(username, password)) {
            System.out.println("Login successful. Connecting to VPN server...");
            connectToVPN();
            System.out.println("You are now connected to the VPN.");
            // Simulating data transfer over VPN
            System.out.println("You can now browse securely and access restricted content.");
            // Simulating user activity
            System.out.println("Press any key to disconnect from VPN.");
            scanner.nextLine(); // Wait for user input
            disconnectFromVPN();
            System.out.println("Disconnected from VPN. Goodbye!");
        } else {
            System.out.println("Login failed. Incorrect username or password.");
        }

        scanner.close();
    }

    private static boolean authenticateUser(String username, String password) {
        // Simulate user authentication logic (e.g., check against a database)
        // For simplicity, hardcoded username and password are used
        return username.equals("user") && password.equals("password");
    }

    private static void connectToVPN() {
        // Simulate connecting to VPN server
        // This could involve setting up a secure tunnel, negotiating encryption parameters, etc.
        System.out.println("Connecting to VPN server...");
        // Simulate connection process
        try {
            Thread.sleep(2000); // Simulate connection delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void disconnectFromVPN() {
        // Simulate disconnecting from VPN server
        // This could involve closing the secure tunnel, releasing resources, etc.
        System.out.println("Disconnecting from VPN server...");
        // Simulate disconnection process
        try {
            Thread.sleep(1000); // Simulate disconnection delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
