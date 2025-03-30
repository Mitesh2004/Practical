
/* 2. Write a Java program to accept the details of Teacher (TNo, TName, Subject). Insert at
least 5 Records into Teacher Table and display the details of Teacher who is teaching
“JAVA” Subject. (Use PreparedStatement Interface)  */

import java.sql.*;

public class Q2 {
    public static void main(String[] args) {
        try {
            // Load PostgreSQL Driver (optional for newer JDBC versions)
            Class.forName("org.postgresql.Driver");

            // Establish Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql:amresh", "postgres", "8624807723");

            // Insert multiple rows into the Teacher table
            String insertQuery = "INSERT INTO Teacher (Tno, Tname, Subject) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = con.prepareStatement(insertQuery);

            // Data entries
            Object[][] teachers = {
                    {1, "Missba Shaikh", "JAVA"},
                    {2, "Afreen Sayyed", "Python"},
                    {3, "Shabnam Pathan", "C++"},
                    {4, "Aslam Saudagar", "JAVA"},
                    {5, "Imran Shaikh", "PHP"}
            };

            // Loop through each entry and execute insert
            for (Object[] teacher : teachers) {
                insertStmt.setInt(1, (int) teacher[0]);
                insertStmt.setString(2, (String) teacher[1]);
                insertStmt.setString(3, (String) teacher[2]);
                insertStmt.executeUpdate();
            }

            System.out.println("✅ Data inserted successfully!");

            // Select statement to fetch teachers who teach "JAVA"
            String selectQuery = "SELECT * FROM Teacher WHERE Subject = ?";
            PreparedStatement selectStmt = con.prepareStatement(selectQuery);
            selectStmt.setString(1, "JAVA");

            ResultSet rs = selectStmt.executeQuery();

            System.out.println("\n👨‍🏫 Teachers who teach JAVA:");
            while (rs.next()) {
                int tno = rs.getInt("Tno");
                String tname = rs.getString("Tname");
                String subject = rs.getString("Subject");
                System.out.println("Teacher Number: " + tno + ", Name: " + tname + ", Subject: " + subject);
            }

            // Close resources
            rs.close();
            selectStmt.close();
            insertStmt.close();
            con.close();
            System.out.println("\n✅ Connection closed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
