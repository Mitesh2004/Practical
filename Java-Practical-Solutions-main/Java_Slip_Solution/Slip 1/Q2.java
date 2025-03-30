
//2. Write a Java program to accept the details of Employee (Eno, EName, Designation,Salary) from a user and store it into the database.


import java.sql.*;
import java.util.*;

public class Q2 
{
    public static void main(String args[]) 
    {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Scanner sc = new Scanner(System.in);

        try 
        {
            // Load PostgreSQL driver
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver Loaded Successfully");

            // Connect to the database
            con = DriverManager.getConnection("jdbc:postgresql:amresh", "postgres", "8624807723");
            if (con == null)
                System.out.println("Connection failed");
            else
                System.out.println("Connection Established successfully");

            // Create table if it doesn't exist
            st = con.createStatement();
            st.executeUpdate("CREATE TABLE IF NOT EXISTS employee (Eno INT PRIMARY KEY, EName TEXT, Designation TEXT, Salary DOUBLE PRECISION)");
            System.out.println("Created table 'employee' (if not exists)");

            // Accept employee details from user
            System.out.print("Enter Employee Number (Eno): ");
            int eno = sc.nextInt();
            sc.nextLine(); // Consume leftover newline

            System.out.print("Enter Employee Name (EName): ");
            String ename = sc.nextLine();

            System.out.print("Enter Employee Designation: ");
            String designation = sc.nextLine();

            System.out.print("Enter Employee Salary: ");
            double salary = sc.nextDouble();

            // Insert data into employee table
            ps = con.prepareStatement("INSERT INTO employee VALUES(?, ?, ?, ?)");
            ps.setInt(1, eno);
            ps.setString(2, ename);
            ps.setString(3, designation);
            ps.setDouble(4, salary);
            ps.executeUpdate();
            System.out.println("Employee details inserted successfully!");

            // Display all employee records
            rs = st.executeQuery("SELECT * FROM employee");
            System.out.println("\nEno\tEName\t\tDesignation\tSalary");
            System.out.println("--------------------------------------------------");
            while (rs.next()) 
            {
                System.out.println(
                        rs.getInt("Eno") + "\t" +
                        rs.getString("EName") + "\t\t" +
                        rs.getString("Designation") + "\t" +
                        rs.getDouble("Salary"));
            }

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            // Close all resources
            try 
            {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
                sc.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    }
}
