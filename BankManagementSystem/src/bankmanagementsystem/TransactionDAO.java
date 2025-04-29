package bankmanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDAO {

    public static void addTransaction(Transaction transaction) {
        String sql = "INSERT INTO Transaction (account_number, transaction_type, amount, transaction_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, transaction.getAccountNumber());
            stmt.setString(2, transaction.getTransactionType());
            stmt.setDouble(3, transaction.getAmount());
            stmt.setTimestamp(4, transaction.getTransactionDate());

            stmt.executeUpdate();
            System.out.println("Transaction added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding transaction: " + e.getMessage());
        }
    }
}
