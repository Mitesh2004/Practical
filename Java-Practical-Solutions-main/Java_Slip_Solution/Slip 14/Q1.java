/* ************** Slip 14 *************** */
/* 1. Write a Java program for a simple search engine. Accept a string to be searched. Search
the string in all text files in the current folder. Use a separate thread for each file. The
result should display the filename and line number where the string is found. */

import java.io.*;

public class Q1 extends Thread {
    private File file;
    private String searchString;

    // Constructor to initialize the file and search string
    public SearchThread(File file, String searchString) {
        this.file = file;
        this.searchString = searchString;
    }

    // Thread's run() method — searches line by line
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;

            // Read each line and check for the search string
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.contains(searchString)) {
                    System.out.println("String found in " + file.getName() + " at line " + lineNumber);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + file.getName());
        }
    }

    // Main method to start the search engine
    public static void main(String[] args) {
        try {
            // Get user input for the search string
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the string to search: ");
            String searchString = br.readLine();

            // Filter .txt files in the current directory
            File dir = new File(".");
            File[] files = dir.listFiles((dir1, name) -> name.endsWith(".txt"));

            if (files == null || files.length == 0) {
                System.out.println("No .txt files found in the current directory.");
                return;
            }

            // Create and start a thread for each file
            for (File file : files) {
                SearchThread searchThread = new SearchThread(file, searchString);
                searchThread.start();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
