//2. Write a java program to blink image on the JFrame continuously. 

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel; 
import javax.swing.Timer; 
public class Q2 extends JPanel implements ActionListener
{ 
private static final long serialVersionUID = 1L; 
private Image image; 
private boolean blinkOn = true; 
public Q2(Image image) { 
this.image = image; 
Timer timer = new Timer(500, this);  
 timer.start(); 
 } 
  
 protected void paintComponent(Graphics g) 
 { 
 super.paintComponent(g); 
 if (blinkOn) { 
 g.drawImage(image, 0, 0, this); 
 } 
 } 
 
 public void actionPerformed(ActionEvent e) { 
 blinkOn = !blinkOn; 
 repaint(); 
 } 
 public static void main(String[] args) { 
 try { 

 Image image = ImageIO.read(new File("path/to/image.png")); 
 JPanel contentPane = new Q2(image); 
 contentPane.setPreferredSize(new Dimension(image.getWidth(null), 
 image.getHeight(null))); 
 JFrame frame = new JFrame("Blinking Image"); 
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 frame.getContentPane().add(contentPane, BorderLayout.CENTER); 
 frame.pack(); 
 frame.setLocationRelativeTo(null); 
 frame.setVisible(true); 
 } 
 catch (IOException e) 
 { 
 e.printStackTrace(); 
 } 
 } 
 } 