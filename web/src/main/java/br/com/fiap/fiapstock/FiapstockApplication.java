package br.com.fiap.fiapstock;

import br.com.fiap.fiapstock.config.CloudConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableConfigurationProperties(value = CloudConfigProperties.class)
public class FiapstockApplication {

    public static void main(String[] args) {
        SpringApplication.run(FiapstockApplication.class, args);
    }

}
