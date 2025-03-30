
/* 2. Write a Java program to display information about all columns in the DONAR table
using ResultSetMetaData.  */

import java.sql.*;

public class Q2{
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load PostgreSQL driver
            Class.forName("org.postgresql.Driver");

            // Connect to the database
            con = DriverManager.getConnection("jdbc:postgresql:amresh", "postgres", "8624807723");

            // Create statement and execute query
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM DONAR");

            // Get metadata from the result set
            ResultSetMetaData rsmd = rs.getMetaData();
            int noOfColumns = rsmd.getColumnCount();

            // Display column count
            System.out.println("Number of columns = " + noOfColumns);

            // Display details for each column
            for (int i = 1; i <= noOfColumns; i++) {
                System.out.println("Column No : " + i);
                System.out.println("Column Name : " + rsmd.getColumnName(i));
                System.out.println("Column Type : " + rsmd.getColumnTypeName(i));
                System.out.println("Column Display Size : " + rsmd.getColumnDisplaySize(i));
                System.out.println("-----------------------------------------");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
