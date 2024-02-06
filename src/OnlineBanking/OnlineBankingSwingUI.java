package OnlineBanking;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnlineBankingSwingUI extends JFrame {
    private OnlineBanking onlineBanking;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JTextArea infoArea;
    private JTextField depositField;
    private JButton depositButton;
    private JTextField withdrawalField;
    private JButton withdrawalButton;

    public OnlineBankingSwingUI() {
        onlineBanking = new OnlineBanking();
        onlineBanking.addUser("user1", "password1", 1000);
        onlineBanking.addUser("user2", "password2", 1500);

        setTitle("Online Banking System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 50, 80, 25);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(140, 50, 160, 25);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 80, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(140, 80, 160, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(140, 110, 80, 25);
        add(loginButton);

        infoArea = new JTextArea();
        infoArea.setBounds(50, 150, 300, 80);
        infoArea.setEditable(false);
        add(infoArea);

        JLabel depositLabel = new JLabel("Deposit:");
        depositLabel.setBounds(50, 250, 60, 25);
        add(depositLabel);

        depositField = new JTextField();
        depositField.setBounds(120, 250, 80, 25);
        add(depositField);

        depositButton = new JButton("Deposit");
        depositButton.setBounds(220, 250, 80, 25);
        add(depositButton);

        JLabel withdrawalLabel = new JLabel("Withdrawal:");
        withdrawalLabel.setBounds(50, 280, 80, 25);
        add(withdrawalLabel);

        withdrawalField = new JTextField();
        withdrawalField.setBounds(140, 280, 80, 25);
        add(withdrawalField);

        withdrawalButton = new JButton("Withdraw");
        withdrawalButton.setBounds(240, 280, 100, 25);
        add(withdrawalButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (onlineBanking.authenticateUser(username, password)) {
                    infoArea.setText("Login successful.\nBalance: $" + onlineBanking.getBalance(username));
                } else {
                    infoArea.setText("Login failed. Invalid username or password.");
                }
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                double amount = Double.parseDouble(depositField.getText());
                onlineBanking.deposit(username, amount);
                infoArea.setText("Deposit successful.\nNew balance: $" + onlineBanking.getBalance(username));
            }
        });

        withdrawalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                double amount = Double.parseDouble(withdrawalField.getText());
                if (onlineBanking.withdraw(username, amount)) {
                    infoArea.setText("Withdrawal successful.\nNew balance: $" + onlineBanking.getBalance(username));
                } else {
                    infoArea.setText("Insufficient funds for withdrawal.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new OnlineBankingSwingUI().setVisible(true);
            }
        });
    }
}
