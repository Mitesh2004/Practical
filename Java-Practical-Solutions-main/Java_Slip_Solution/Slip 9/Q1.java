
/* ****************** Slip 9 ****************** */
/* 1. Write a Java program to create a thread for moving a ball inside a panel vertically. The
ball should be created when the user clicks on the start button */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q1 extends JFrame {

    private BallPanel ballPanel;
    private JButton startButton;
    private BallThread ballThread;

    public BallMovement() {
        setTitle("Ball Movement");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create custom panel that supports ball drawing
        ballPanel = new BallPanel();
        startButton = new JButton("Start");

        // Add action listener to start the ball on button click
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startBall();
            }
        });

        // Set layout and add components
        ballPanel.setLayout(null);
        ballPanel.add(startButton);
        startButton.setBounds(150, 10, 100, 30);

        getContentPane().add(ballPanel);
    }

    private void startBall() {
        // Start the ball animation if not already running
        if (ballThread == null || !ballThread.isAlive()) {
            ballThread = new BallThread(ballPanel);
            ballThread.start();
        }
    }

    public static void main(String[] args) {
        // Launch the application on the event dispatch thread
        SwingUtilities.invokeLater(() -> new BallMovement().setVisible(true));
    }
}

// Custom JPanel that handles ball movement and repainting
class BallPanel extends JPanel {
    private static final int DIAMETER = 20;
    private int y = 50;
    private int ySpeed = 2;

    public void moveBall() {
        // Bounce logic
        if (y + DIAMETER >= getHeight() || y <= 0) {
            ySpeed = -ySpeed;
        }
        y += ySpeed;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the ball
        g.setColor(Color.BLUE);
        g.fillOval(150, y, DIAMETER, DIAMETER);
    }
}

// Thread that keeps the ball moving
class BallThread extends Thread {
    private BallPanel ballPanel;

    public BallThread(BallPanel ballPanel) {
        this.ballPanel = ballPanel;
    }

    public void run() {
        while (true) {
            ballPanel.moveBall();
            try {
                Thread.sleep(10); // Control the speed of movement
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
