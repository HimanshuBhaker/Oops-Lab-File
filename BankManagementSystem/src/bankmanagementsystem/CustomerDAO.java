package bankmanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {

    public static void addCustomer(Customer customer) {
        String sql = "INSERT INTO Customer (name, address, phone) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getAddress());
            stmt.setString(3, customer.getPhone());

            stmt.executeUpdate();
            System.out.println("✅ Customer added successfully!");
        } catch (SQLException e) {
            System.out.println("❌ Error adding customer: " + e.getMessage());
        }
    }

    public static boolean customerExists(int customerId) {
        String sql = "SELECT customer_id FROM Customer WHERE customer_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // returns true if customer exists
        } catch (SQLException e) {
            System.out.println("Error checking customer existence: " + e.getMessage());
            return false;
        }
    }
}
