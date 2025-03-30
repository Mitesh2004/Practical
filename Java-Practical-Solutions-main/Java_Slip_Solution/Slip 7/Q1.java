
/* ********* Slip 7 ******** */
/* 1. Write a java program that implements a multi-thread application that has three threads.
First thread generates random integer number after every one second, if the number is
even; second thread computes the square of that number and print it. If the number is
odd, the third thread computes the of cube of that number and print it. */

import java.util.Random;

// Thread to calculate square of even numbers
class Square extends Thread {
    int x;

    Square(int n) {
        x = n;
    }

    public void run() {
        int sqr = x * x;
        System.out.println("Square of " + x + " = " + sqr);
    }
}

// Thread to calculate cube of odd numbers
class Cube extends Thread {
    int x;

    Cube(int n) {
        x = n;
    }

    public void run() {
        int cub = x * x * x;
        System.out.println("Cube of " + x + " = " + cub);
    }
}

// Main Number generator thread
class Number extends Thread {
    public void run() {
        Random random = new Random();

        // Generate 5 random integers
        for (int i = 0; i < 5; i++) {
            int randomInteger = random.nextInt(100);
            System.out.println("\nRandom Integer generated: " + randomInteger);

            // Check if number is even or odd and start respective thread
            if (randomInteger % 2 == 0) {
                Square s = new Square(randomInteger);
                s.start();
            } else {
                Cube c = new Cube(randomInteger);
                c.start();
            }

            // Sleep for 1 second before generating the next number
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
}

// Main class
public class Q1 {
    public static void main(String args[]) {
        Number n = new Number();
        n.start();
    }
}
