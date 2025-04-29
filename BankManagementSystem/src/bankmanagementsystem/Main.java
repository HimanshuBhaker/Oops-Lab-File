package bankmanagementsystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("===============================");
        System.out.println("  Welcome to Bank Management  ");
        System.out.println("===============================");

        while (true) {
            // Display main menu
            System.out.println("\n1. Create New Account");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Check Balance");
            System.out.println("5. View Account Details");
            System.out.println("6. Exit");

            int choice = InputHelper.getInt("Enter your choice: ");

            // Switch case to handle different operations
            switch (choice) {
                case 1:
                    BankOperations.createAccount();  // Call method to create a new account
                    break;
                case 2:
                    BankOperations.deposit();  // Call method to deposit amount
                    break;
                case 3:
                    BankOperations.withdraw();  // Call method to withdraw amount
                    break;
                case 4:
                    BankOperations.checkBalance();  // Call method to check balance
                    break;
                case 5:
                    BankOperations.viewAccountDetails();  // Call method to view account details
                    break;
                case 6:
                    System.out.println("Thank you for using Bank Management System!");
                    System.exit(0);  // Exit the program
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
