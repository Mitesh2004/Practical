/* 2. Write a java program for the following:
i. To create a Product(Pid, Pname, Price) table.
ii. Insert at least five records into the table.
iii. Display all the records from a table. */

import java.sql.*;

public class Q2 {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:oracle:thin:@localhost:1521:amresh";
        String user = "oracle";
        String password = "8624807723";

        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();

            // 1️⃣ Create the Product table (if not already created)
            String createTableQuery = "CREATE TABLE Product (Pid INT PRIMARY KEY, Pname VARCHAR(50), Price DECIMAL(10, 2))";
            try {
                stmt.executeUpdate(createTableQuery);
                System.out.println("Table 'Product' created successfully.");
            } catch (SQLException e) {
                System.out.println("Table already exists.");
            }

            // 2️⃣ Insert 5 product records
            String[] products = {
                "INSERT INTO Product VALUES (1, 'Laptop', 50000.00)",
                "INSERT INTO Product VALUES (2, 'Smartphone', 25000.00)",
                "INSERT INTO Product VALUES (3, 'Tablet', 15000.00)",
                "INSERT INTO Product VALUES (4, 'Smartwatch', 7000.00)",
                "INSERT INTO Product VALUES (5, 'Headphones', 2000.00)"
            };

            for (String query : products) {
                stmt.executeUpdate(query);
            }
            System.out.println("5 records inserted successfully.");

            // 3️⃣ Display all records
            ResultSet rs = stmt.executeQuery("SELECT * FROM Product");
            System.out.println("\nProduct Records:");
            System.out.printf("%-5s %-15s %-10s%n", "ID", "Name", "Price");
            System.out.println("----------------------------------");

            while (rs.next()) {
                int id = rs.getInt("Pid");
                String name = rs.getString("Pname");
                double price = rs.getDouble("Price");

                System.out.printf("%-5d %-15s %-10.2f%n", id, name, price);
            }

            // Close the connection
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
