package fr.lernejo.chat;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Launcher {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Launcher.class);
        RabbitTemplate objet = context.getBean(RabbitTemplate.class);

        Scanner scanner = new Scanner(System.in);
        String userInput;
        boolean again = true;

        System.out.println("Input a message, we will send it for you (q to quit)");
        userInput = scanner.nextLine();
        objet.convertAndSend("", "chat_messages", userInput);

        while (again) {
            System.out.println("Message sent. Input a message, we will send it for you (q to quit)");
            userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("q")) {
                again = false;
                continue;
            }
            objet.convertAndSend("", "chat_messages", userInput);
        }
    }
}
