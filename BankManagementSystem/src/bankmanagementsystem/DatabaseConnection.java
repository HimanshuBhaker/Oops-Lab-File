package bankmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/bankdb";
    private static final String USER = "root";
    private static final String PASSWORD = "842500"; // Change to your MySQL password

    // Get Connection
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("❌ Failed to connect to the database: " + e.getMessage());
        }
        return conn;
    }

    // Fetch Balance for given Account Number
    public static double getBalance(int accountNumber) {
        double balance = 0;
        String sql = "SELECT balance FROM Account WHERE account_number = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, accountNumber);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                balance = rs.getDouble("balance");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error fetching balance: " + e.getMessage());
        }

        return balance;
    }
}
