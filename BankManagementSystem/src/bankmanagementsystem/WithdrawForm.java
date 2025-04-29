package bankmanagementsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawForm {
    public static void showForm() {
        JFrame frame = new JFrame("Withdraw Amount");
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

        JButton withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(80, 120, 100, 30);

        frame.add(accountNumberLabel);
        frame.add(accountNumberField);
        frame.add(amountLabel);
        frame.add(amountField);
        frame.add(withdrawBtn);

        frame.setVisible(true);

        withdrawBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int accountNumber = Integer.parseInt(accountNumberField.getText());
                double amount = Double.parseDouble(amountField.getText());

                double currentBalance = DatabaseConnection.getBalance(accountNumber);

                if (currentBalance >= amount) {
                    double newBalance = currentBalance - amount;

                    AccountDAO.updateBalance(accountNumber, newBalance);

                    Transaction transaction = new Transaction(0, accountNumber, "Withdraw", amount, new java.sql.Timestamp(System.currentTimeMillis()));
                    TransactionDAO.addTransaction(transaction);

                    JOptionPane.showMessageDialog(frame, "Withdrawal Successful! New Balance: " + newBalance);
                } else {
                    JOptionPane.showMessageDialog(frame, "Insufficient Balance!");
                }

                frame.dispose();
            }
        });
    }
}
