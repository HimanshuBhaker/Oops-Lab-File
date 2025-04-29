package bankmanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;  // Import ResultSet
import java.sql.SQLException;

public class AccountDAO {

    // Method to Add New Account
    public static void addAccount(Account account) {
        String sql = "INSERT INTO Account (customer_id, account_type, balance) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, account.getCustomerId());
            stmt.setString(2, account.getAccountType());
            stmt.setDouble(3, account.getBalance());

            stmt.executeUpdate();
            System.out.println("Account successfully added to the database.");
        } catch (SQLException e) {
            System.out.println("Error adding account: " + e.getMessage());
        }
    }

    // Method to Update Account Balance
    public static void updateBalance(int accountNumber, double balance) {
        String sql = "UPDATE Account SET balance = ? WHERE account_number = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, balance);
            stmt.setInt(2, accountNumber);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating balance: " + e.getMessage());
        }
    }

    // Method to Get Account Details by Account Number
    public static String getAccountDetails(int accountNumber) {
        String sql = "SELECT * FROM Account WHERE account_number = ?";
        String accountDetails = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, accountNumber);
            ResultSet rs = stmt.executeQuery();  // Execute the query

            if (rs.next()) {
                int customerId = rs.getInt("customer_id");
                double balance = rs.getDouble("balance");

                accountDetails = "Account Number: " + accountNumber + "\n" +
                        "Customer ID: " + customerId + "\n" +
                        "Balance: " + balance;
            }
        } catch (SQLException e) {
            System.out.println("Error fetching account details: " + e.getMessage());
        }

        return accountDetails;
    }
}
