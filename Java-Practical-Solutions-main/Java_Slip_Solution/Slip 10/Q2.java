/* 2. Write a Java program to display first record from student table (RNo, SName, Per) onto
the TextFields by clicking on button. (Assume Student table is already created).  */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Q2 extends JFrame implements ActionListener {
    JTextField t1, t2, t3;
    JLabel l1, l2, l3;
    JButton b1, b2;

    // Constructor
    StudDb() {
        setLayout(new FlowLayout());
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels and text fields
        l1 = new JLabel("RollNo");
        add(l1);

        t1 = new JTextField(10);
        add(t1);

        l2 = new JLabel("Name");
        add(l2);

        t2 = new JTextField(10);
        add(t2);

        l3 = new JLabel("Percentage");
        add(l3);

        t3 = new JTextField(10);
        add(t3);

        // Buttons
        b1 = new JButton("Insert");
        add(b1);
        b1.addActionListener(this);

        b2 = new JButton("Display First Record");
        add(b2);
        b2.addActionListener(this);

        // Load PostgreSQL Driver
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            System.out.println("Error loading driver: " + e.getMessage());
        }
    }

    // Handle button events
    public void actionPerformed(ActionEvent e2) {
        if (e2.getSource() == b1) {
            // Insert new student record
            try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/amresh", "postgres", "8624807723")) {
                int rno = Integer.parseInt(t1.getText());
                String sname = t2.getText();
                float percentage = Float.parseFloat(t3.getText());

                String query = "INSERT INTO student VALUES(?,?,?)";
                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, rno);
                st.setString(2, sname);
                st.setFloat(3, percentage);

                int rows = st.executeUpdate();
                if (rows > 0) JOptionPane.showMessageDialog(this, "Record Inserted Successfully!");

                st.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }

        if (e2.getSource() == b2) {
            // Fetch and display the first student record
            try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/amresh", "postgres", "8624807723")) {
                String query = "SELECT * FROM student LIMIT 1";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);

                if (rs.next()) {
                    t1.setText(String.valueOf(rs.getInt("RNo")));
                    t2.setText(rs.getString("SName"));
                    t3.setText(String.valueOf(rs.getFloat("Per")));
                    JOptionPane.showMessageDialog(this, "First Record Loaded!");
                } else {
                    JOptionPane.showMessageDialog(this, "No records found.");
                }

                rs.close();
                st.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        new Q2();
    }
}
