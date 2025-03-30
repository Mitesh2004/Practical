/* ************ Slip 23 ************** */

/* 1. Write a java program to accept a String from a user and display each vowel from a
String after every 3 seconds.  */


import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine().toLowerCase();

        // Loop through each character
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);

            // Check if the character is a vowel
            if (isVowel(c)) {
                System.out.print(c + " ");

                // Pause for 3 seconds
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        scanner.close();
    }

    // Method to check if a character is a vowel
    public static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
