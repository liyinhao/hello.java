package example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.net.URI;

//@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(Application.class, args);

        System.setProperty("java.awt.headless", "false");

        Desktop.getDesktop().browse(new URI("http://localhost:8080"));
    }
}
