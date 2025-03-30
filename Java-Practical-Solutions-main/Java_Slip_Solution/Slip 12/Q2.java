/* 2. Write a Java Program to create a PROJECT table with field’s project_id, Project_name,
Project_description, Project_Status. Insert values in the table. Display all the details of
the PROJECT table in a tabular format on the screen.(using swing).  */

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

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver Loaded Successfully");

            con = DriverManager.getConnection("jdbc:postgresql:amresh", "postgres", "8624807723");
            if (con == null)
                System.out.println("Connection failed");
            else
                System.out.println("Connection Established successfully");

            st = con.createStatement();
            st.executeUpdate("create table if not exists project_5(pid int primary key, pname text, pdesc text, pstatus text);");
            System.out.println("Created table project_5 (if not exists)");

            System.out.print("Enter Project ID: ");
            int pid = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.print("Enter Project Name: ");
            String pname = sc.nextLine();

            System.out.print("Enter Project Description: ");
            String pdesc = sc.nextLine();

            System.out.print("Enter Project Status: ");
            String pstatus = sc.nextLine();

            ps = con.prepareStatement("insert into project_5 values(?,?,?,?)");
            ps.setInt(1, pid);
            ps.setString(2, pname);
            ps.setString(3, pdesc);
            ps.setString(4, pstatus);
            ps.executeUpdate();
            System.out.println("Inserted successfully");

            rs = st.executeQuery("select * from project_5");
            System.out.println("pid \t pname \t pdesc \t pstatus ");
            while (rs.next()) {
                System.out.println(" " + rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
                sc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}