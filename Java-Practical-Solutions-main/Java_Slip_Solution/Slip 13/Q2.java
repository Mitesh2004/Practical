

/* 2. Write a Java program to show lifecycle (creation, sleep, and dead) of a thread. Program
should print randomly the name of thread and value of sleep time. The name of the
thread should be hard coded through constructor. The sleep time of a thread will be a
random integer in the range 0 to 4999 */

class MyThread extends Thread {
    // Constructor to name the thread
    public MyThread(String name) {
        super(name);
    }

    // Define thread behavior in run()
    public void run() {
        System.out.println(getName() + " thread created.");

        // Simulate thread lifecycle
        while (true) {
            try {
                // Random sleep time between 0 to 4999 milliseconds
                int sleepTime = (int) (Math.random() * 5000);
                System.out.println(getName() + " is sleeping for: " + sleepTime + " msec");

                // Put the thread to sleep
                Thread.sleep(sleepTime);

                // Simulate thread completion
                System.out.println(getName() + " thread completed work.");
                break;

            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted.");
            }
        }
    }
}

// Main class to test thread lifecycle
public class Q2 {
    public static void main(String args[]) {
        // Create two threads with hardcoded names
        MyThread t1 = new MyThread("Shradha");
        MyThread t2 = new MyThread("Pooja");

        // Start both threads
        t1.start();
        t2.start();

        try {
            // Wait for both threads to complete
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        // Threads have finished, print final message
        System.out.println(t1.getName() + " thread dead.");
        System.out.println(t2.getName() + " thread dead.");
    }
}
