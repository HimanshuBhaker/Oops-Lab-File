package bankmanagementsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewAccountDetailsForm {
    public static void showForm() {
        JFrame frame = new JFrame("View Account Details");
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JLabel accountNumberLabel = new JLabel("Account No:");
        accountNumberLabel.setBounds(30, 50, 100, 30);
        JTextField accountNumberField = new JTextField();
        accountNumberField.setBounds(130, 50, 100, 30);

        JButton viewBtn = new JButton("View");
        viewBtn.setBounds(80, 100, 100, 30);

        frame.add(accountNumberLabel);
        frame.add(accountNumberField);
        frame.add(viewBtn);

        frame.setVisible(true);

        viewBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int accountNumber = Integer.parseInt(accountNumberField.getText());

                String details = AccountDAO.getAccountDetails(accountNumber);

                if (details != null) {
                    JOptionPane.showMessageDialog(frame, details);
                } else {
                    JOptionPane.showMessageDialog(frame, "Account Not Found!");
                }

                frame.dispose();
            }
        });
    }
}
