package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankManagementUI extends JFrame implements ActionListener {

    JButton createAccountBtn, depositBtn, withdrawBtn, checkBalanceBtn, viewDetailsBtn, exitBtn;

    public BankManagementUI() {
        setTitle("Bank Management System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create buttons
        createAccountBtn = new JButton("Create New Account");
        depositBtn = new JButton("Deposit Amount");
        withdrawBtn = new JButton("Withdraw Amount");
        checkBalanceBtn = new JButton("Check Balance");
        viewDetailsBtn = new JButton("View Account Details");
        exitBtn = new JButton("Exit");

        // Add action listeners
        createAccountBtn.addActionListener(this);
        depositBtn.addActionListener(this);
        withdrawBtn.addActionListener(this);
        checkBalanceBtn.addActionListener(this);
        viewDetailsBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        // Layout
        setLayout(new GridLayout(6, 1, 10, 10));
        add(createAccountBtn);
        add(depositBtn);
        add(withdrawBtn);
        add(checkBalanceBtn);
        add(viewDetailsBtn);
        add(exitBtn);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createAccountBtn) {
            CreateAccountForm.showForm();
        } else if (e.getSource() == depositBtn) {
            DepositForm.showForm();
        } else if (e.getSource() == withdrawBtn) {
            WithdrawForm.showForm();
        } else if (e.getSource() == checkBalanceBtn) {
            CheckBalanceForm.showForm();
        } else if (e.getSource() == viewDetailsBtn) {
            ViewAccountDetailsForm.showForm();
        } else if (e.getSource() == exitBtn) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new BankManagementUI();
    }
}
