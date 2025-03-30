/* 2. Write a Java program using Spring to display the message “If you can't explain it
simply, you don't understand it well enough”. */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Q2 {

    public static void main(String[] args) {
        SpringApplication.run(Q2.class, args);
    }
}

// Controller for handling requests
@RestController
class MessageController {

    @GetMapping("/")
    public String displayMessage() {
        return "<h1 style='color:blue; text-align:center;'>If you can't explain it simply, you don't understand it well enough</h1>";
    }

    @GetMapping("/quote")
    public String getAnotherQuote() {
        return "<h2 style='color:green; text-align:center;'>“Logic will get you from A to B. Imagination will take you everywhere.” - Albert Einstein</h2>";
    }
}
