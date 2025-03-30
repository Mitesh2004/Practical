/* *********** Slip 15 ************ */
/* 1. Write a java program to display name and priority of a Thread.  */

public class Q1
{
    public static void main(String[] args) {
        
        // Get the current thread
        Thread t = Thread.currentThread();

        // Display current thread info
        System.out.println("Current Thread: " + t);

        // Change the thread's name
        t.setName("My Custom Thread");

        // Set a higher priority
        t.setPriority(Thread.MAX_PRIORITY);

        // Display updated thread info
        System.out.println("After name and priority change: " + t);

        // Demonstrate the thread running with a countdown
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Countdown: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        System.out.println("Thread execution complete.");
    }
}
