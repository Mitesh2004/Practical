
//******************Slip 4******************* */
//1. Write a Java program using Runnable interface to blink Text on the frame
import java.awt.*;

class Q1 extends Frame implements Runnable {
    Thread t;
    Label l1;
    boolean visible;

    // Constructor
    Q1() {
        // Initialize and start the thread
        t = new Thread(this);
        t.start();

        // Set layout and add label
        setLayout(null);
        l1 = new Label("Hello JAVA");
        l1.setBounds(100, 100, 100, 40);
        add(l1);

        // Set frame properties
        setSize(300, 300);
        setVisible(true);

        visible = true; // Track visibility
    }

    // Runnable's run method
    public void run() 
    {
        try 
        {
            // Continuous blinking loop
            while (true) 
            {
                // Toggle visibility
                if (visible) 
                {
                    l1.setText("");
                } 
                else 
                {
                    l1.setText("Hello Amresh");
                }
                visible = !visible;

                // Sleep for 500 milliseconds between blinks
                Thread.sleep(500);
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error: " + e);
        }
    }

    // Main method
    public static void main(String[] args) 
    {
        new Q1();
    }
}
