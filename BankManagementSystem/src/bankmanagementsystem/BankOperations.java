package bankmanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankOperations {

    // Method to Create New Account
    public static void createAccount() {
        System.out.println("Creating New Account...");

        // Get customer details
        int customerId = InputHelper.getInt("Enter Customer ID: ");
        double initialDeposit = InputHelper.getDouble("Enter Initial Deposit Amount: ");
        String accountType = InputHelper.getString("Enter Account Type (e.g., Savings, Checking): ");

        // Validate the deposit amount
        if (initialDeposit < 0) {
            System.out.println("❌ Initial deposit must be a positive amount!");
            return;
        }

        // Create a new account with the initial deposit and account type
        Account account = new Account(customerId, accountType, initialDeposit);

        // Insert account into the database
        AccountDAO.addAccount(account);

        System.out.println("Account created successfully with an initial deposit of " + initialDeposit + " and account type: " + accountType);
    }

    // Method to Deposit Amount
    public static void deposit() {
        int accountNumber = InputHelper.getInt("Enter account number: ");
        double amount = InputHelper.getDouble("Enter amount to deposit: ");

        // Fetch current balance and add the deposit
        double currentBalance = DatabaseConnection.getBalance(accountNumber);
        double newBalance = currentBalance + amount;

        // Update the balance in the database
        AccountDAO.updateBalance(accountNumber, newBalance);

        // Log the transaction
        Transaction transaction = new Transaction(0, accountNumber, "Deposit", amount, new java.sql.Timestamp(System.currentTimeMillis()));
        TransactionDAO.addTransaction(transaction);

        System.out.println("Deposit successful! New balance: " + newBalance);
    }

    // Method to Withdraw Amount
    public static void withdraw() {
        int accountNumber = InputHelper.getInt("Enter account number: ");
        double amount = InputHelper.getDouble("Enter amount to withdraw: ");

        // Fetch current balance and perform withdrawal
        double currentBalance = DatabaseConnection.getBalance(accountNumber);

        if (currentBalance >= amount) {
            double newBalance = currentBalance - amount;

            // Update the balance in the database
            AccountDAO.updateBalance(accountNumber, newBalance);

            // Log the transaction
            Transaction transaction = new Transaction(0, accountNumber, "Withdraw", amount, new java.sql.Timestamp(System.currentTimeMillis()));
            TransactionDAO.addTransaction(transaction);

            System.out.println("Withdrawal successful! New balance: " + newBalance);
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    // Method to Check Balance
    public static void checkBalance() {
        int accountNumber = InputHelper.getInt("Enter account number: ");

        // Fetch current balance
        double balance = DatabaseConnection.getBalance(accountNumber);

        System.out.println("Current balance: " + balance);
    }

    // Method to View Account Details
    public static void viewAccountDetails() {
        int accountNumber = InputHelper.getInt("Enter account number to view details: ");

        // Fetch account details (you can add additional details as needed)
        String accountDetails = AccountDAO.getAccountDetails(accountNumber);

        if (accountDetails != null) {
            System.out.println("Account Details for Account Number " + accountNumber + ": ");
            System.out.println(accountDetails);
        } else {
            System.out.println("Account not found.");
        }
    }
}
