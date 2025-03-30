
/* *********** Slip 10 ********** */
/* 1. Write a Java program to display the Current Date using spring. */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class Q1 {

    public static void main(String[] args) {
        SpringApplication.run(Q1.class, args);
    }
}

@RestController
class DateController {

    @GetMapping("/currentdate")
    public String getCurrentDate() {
        // Format the date nicely
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy - hh:mm a");
        String formattedDate = LocalDateTime.now().format(formatter);

        // Return styled output
        return "<h1 style='color:purple; text-align:center;'>Current Date & Time: " + formattedDate + "</h1>";
    }
}
