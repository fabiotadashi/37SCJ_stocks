package br.com.fiap.fiapstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class FiapstockApplication {

    public static void main(String[] args) {
        SpringApplication.run(FiapstockApplication.class, args);
    }

}
