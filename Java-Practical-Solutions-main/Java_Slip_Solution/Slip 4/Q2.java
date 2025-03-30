/* 2. Write a Java program to store city names and their STD codes using an appropriate
collection and perform following operations:
i. Add a new city and its code (No duplicates)
ii. Remove a city from the collection
iii. Search for a city name and display the code */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class Q2 extends JFrame implements ActionListener 
{
    // UI Components
    JTextField t1, t2, t3;
    JButton b1, b2, b3;
    JTextArea t;
    JPanel p1, p2;

    // Using HashMap instead of Hashtable for better performance and modern features
    HashMap<String, Integer> cityCodes;

    // Constructor to set up UI
    Q2() 
    {
        cityCodes = new HashMap<>();

        // Text fields for input
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);

        // Buttons
        b1 = new JButton("Add");
        b2 = new JButton("Search");
        b3 = new JButton("Remove");

        // Text area for displaying the collection
        t = new JTextArea(20, 20);

        // Top panel for display
        p1 = new JPanel();
        p1.add(t);

        // Bottom panel for inputs and buttons
        p2 = new JPanel();
        p2.setLayout(new GridLayout(2, 3));
        p2.add(new JLabel("City Name:"));
        p2.add(t1);
        p2.add(new JLabel("STD Code:"));
        p2.add(t2);
        p2.add(b1);

        p2.add(new JLabel("City (Search/Remove):"));
        p2.add(t3);
        p2.add(b2);
        p2.add(b3);

        // Add panels to frame
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.SOUTH);

        // Button action listeners
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        // Frame settings
        setLayout(new FlowLayout());
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Handling button actions
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) 
        {  
            // Add city and code
            String city = t1.getText();
            try {
                int code = Integer.parseInt(t2.getText());
                if (!cityCodes.containsKey(city)) 
                {
                    cityCodes.put(city, code);
                    displayCities();
                    t1.setText("");
                    t2.setText("");
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "City already exists!");
                }
            } 
            catch (NumberFormatException ex) 
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid number for STD code!");
            }

        } 
        else if (e.getSource() == b2) 
        {  
            // Search for city
            String city = t3.getText();
            if (cityCodes.containsKey(city)) 
            {
                t.setText("City: " + city + "\nSTD Code: " + cityCodes.get(city));
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "City not found...");
            }

        } 
        else if (e.getSource() == b3) 
        {  
            // Remove city
            String city = t3.getText();
            if (cityCodes.containsKey(city)) 
            {
                cityCodes.remove(city);
                JOptionPane.showMessageDialog(null, "City Deleted...");
                displayCities();
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "City not found...");
            }
        }
    }

    // Helper method to display city codes
    private void displayCities() 
    {
        StringBuilder msg = new StringBuilder("City Name = STD Code\n");
        for (Map.Entry<String, Integer> entry : cityCodes.entrySet()) 
        {
            msg.append(entry.getKey()).append(" = ").append(entry.getValue()).append("\n");
        }
        t.setText(msg.toString());
    }

    // Main method
    public static void main(String[] args) 
    {
        new Q2();
    }
}
