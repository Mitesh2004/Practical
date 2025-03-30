/* *********** Slip 13 ********* */
/* 1. Write a Java program to display information about the database and list all the tables in
the database. (Use DatabaseMetaData).  */

import java.sql.*;

public class Q1 {
    public static void main(String[] args) {
        Connection con = null;

        try {
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection("jdbc:postgresql:amresh","postgres","8624807723");

            DatabaseMetaData metaData = con.getMetaData();

            System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());
            System.out.println("Driver Name: " + metaData.getDriverName());
            System.out.println("Driver Version: " + metaData.getDriverVersion());

            System.out.println("\nTables in the database:");
            ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});
            while (tables.next()) {
                System.out.println(tables.getString("TABLE_NAME"));
            }

            tables.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}