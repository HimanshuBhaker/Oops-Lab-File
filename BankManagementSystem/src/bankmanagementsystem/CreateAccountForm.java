package bankmanagementsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccountForm {
    public static void showForm() {
        JFrame frame = new JFrame("Create New Account");
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JLabel customerIdLabel = new JLabel("Customer ID:");
        customerIdLabel.setBounds(30, 30, 100, 30);
        JTextField customerIdField = new JTextField();
        customerIdField.setBounds(150, 30, 100, 30);

        JLabel depositLabel = new JLabel("Initial Deposit:");
        depositLabel.setBounds(30, 70, 100, 30);
        JTextField depositField = new JTextField();
        depositField.setBounds(150, 70, 100, 30);

        JLabel accountTypeLabel = new JLabel("Account Type:");
        accountTypeLabel.setBounds(30, 110, 100, 30);
        JTextField accountTypeField = new JTextField();
        accountTypeField.setBounds(150, 110, 100, 30);

        JButton createBtn = new JButton("Create");
        createBtn.setBounds(90, 160, 100, 30);

        frame.add(customerIdLabel);
        frame.add(customerIdField);
        frame.add(depositLabel);
        frame.add(depositField);
        frame.add(accountTypeLabel);
        frame.add(accountTypeField);
        frame.add(createBtn);

        frame.setVisible(true);

        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int customerId = Integer.parseInt(customerIdField.getText());
                double initialDeposit = Double.parseDouble(depositField.getText());
                String accountType = accountTypeField.getText();

                if (!CustomerDAO.customerExists(customerId)) {
                    JOptionPane.showMessageDialog(frame, "Customer ID does not exist!");
                    return;
                }

                Account account = new Account(customerId, accountType, initialDeposit);
                AccountDAO.addAccount(account);
                JOptionPane.showMessageDialog(frame, "Account Created Successfully!");

                frame.dispose();
            }
        });
    }
}
