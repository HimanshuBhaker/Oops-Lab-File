package bankmanagementsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBalanceForm {
    public static void showForm() {
        JFrame frame = new JFrame("Check Balance");
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JLabel accountNumberLabel = new JLabel("Account No:");
        accountNumberLabel.setBounds(30, 50, 100, 30);
        JTextField accountNumberField = new JTextField();
        accountNumberField.setBounds(130, 50, 100, 30);

        JButton checkBtn = new JButton("Check");
        checkBtn.setBounds(80, 100, 100, 30);

        frame.add(accountNumberLabel);
        frame.add(accountNumberField);
        frame.add(checkBtn);

        frame.setVisible(true);

        checkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int accountNumber = Integer.parseInt(accountNumberField.getText());

                double balance = DatabaseConnection.getBalance(accountNumber);

                JOptionPane.showMessageDialog(frame, "Current Balance: " + balance);

                frame.dispose();
            }
        });
    }
}
