/* 2. Write a Java Program for the following: Assume database is already created */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.*;

public class Q2 extends JFrame implements ActionListener {
    JTextField queryField;
    JButton createButton, alterButton, dropButton;

    Connection conn;

    public Q2() {
        // Set up the GUI layout
        setTitle("DDL Query Executor");
        setSize(400, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Input field for query
        queryField = new JTextField(30);
        add(new JLabel("Type Your DDL Query Here"));
        add(queryField);

        // Buttons
        createButton = new JButton("Create Table");
        alterButton = new JButton("Alter Table");
        dropButton = new JButton("Drop Table");

        add(createButton);
        add(alterButton);
        add(dropButton);

        // Add action listeners
        createButton.addActionListener(this);
        alterButton.addActionListener(this);
        dropButton.addActionListener(this);

        // Database connection setup
        try {
            conn = DriverManager.getConnection("jdbc:postgresql:amresh", "postgres", "8624807723");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database Connection Failed");
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String query = queryField.getText().trim();
        if (query.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a query!");
            return;
        }

        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(this, "Query executed successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Q2();
    }
}
