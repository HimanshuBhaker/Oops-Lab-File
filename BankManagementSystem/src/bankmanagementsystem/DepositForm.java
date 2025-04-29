package bankmanagementsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositForm {
    public static void showForm() {
        JFrame frame = new JFrame("Deposit Amount");
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JLabel accountNumberLabel = new JLabel("Account No:");
        accountNumberLabel.setBounds(30, 30, 100, 30);
        JTextField accountNumberField = new JTextField();
        accountNumberField.setBounds(130, 30, 100, 30);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(30, 70, 100, 30);
        JTextField amountField = new JTextField();
        amountField.setBounds(130, 70, 100, 30);

        JButton depositBtn = new JButton("Deposit");
        depositBtn.setBounds(80, 120, 100, 30);

        frame.add(accountNumberLabel);
        frame.add(accountNumberField);
        frame.add(amountLabel);
        frame.add(amountField);
        frame.add(depositBtn);

        frame.setVisible(true);

        depositBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int accountNumber = Integer.parseInt(accountNumberField.getText());
                double amount = Double.parseDouble(amountField.getText());

                double currentBalance = DatabaseConnection.getBalance(accountNumber);
                double newBalance = currentBalance + amount;

                AccountDAO.updateBalance(accountNumber, newBalance);

                Transaction transaction = new Transaction(0, accountNumber, "Deposit", amount, new java.sql.Timestamp(System.currentTimeMillis()));
                TransactionDAO.addTransaction(transaction);

                JOptionPane.showMessageDialog(frame, "Deposit Successful! New Balance: " + newBalance);

                frame.dispose();
            }
        });
    }
}
