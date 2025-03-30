/* 2. Write a java program to simulate traffic signal using threads */

import java.applet.*;  
import java.awt.*;  

// Extend Applet and implement Runnable for threading
public class Q2 extends Applet implements Runnable {  
    Thread t;  
    int red, yellow, green;  
    
    // Initialize the applet and thread
    public void init() {  
        t = new Thread(this);  
        t.start();  
        red = 1; yellow = 0; green = 0;  
    }  
    
    // Thread's run method to control signal changes
    public void run() {  
        try {  
            while (true) {  
                // Red light for 5 seconds
                red = 1; yellow = 0; green = 0;  
                repaint();  
                Thread.sleep(5000);  
                
                // Green light for 5 seconds
                red = 0; yellow = 0; green = 1;  
                repaint();  
                Thread.sleep(5000);  
                
                // Yellow light for 2 seconds (transition)
                red = 0; yellow = 1; green = 0;  
                repaint();  
                Thread.sleep(2000);  
            }  
        } catch (Exception e) {  
            System.out.println(e);  
        }  
    }  
    
    // Paint method to draw the signal
    public void paint(Graphics g) {  
        g.drawRect(100, 100, 100, 300);  

        // Red light  
        if (red == 1) {  
            g.setColor(Color.red);  
            g.fillOval(100, 100, 100, 100);  
        } else {  
            g.setColor(Color.black);  
            g.drawOval(100, 100, 100, 100);  
        }  

        // Yellow light  
        if (yellow == 1) {  
            g.setColor(Color.yellow);  
            g.fillOval(100, 200, 100, 100);  
        } else {  
            g.setColor(Color.black);  
            g.drawOval(100, 200, 100, 100);  
        }  

        // Green light  
        if (green == 1) {  
            g.setColor(Color.green);  
            g.fillOval(100, 300, 100, 100);  
        } else {  
            g.setColor(Color.black);  
            g.drawOval(100, 300, 100, 100);  
        }  
    }  
}  
