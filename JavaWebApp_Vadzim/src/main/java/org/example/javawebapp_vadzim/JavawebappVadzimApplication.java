package org.example.javawebapp_vadzim;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Steam Tracker API",
                version = "1.0",
                description = "Steam game tracking application"
        )
)
public class JavawebappVadzimApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                JavawebappVadzimApplication.class,
                args
        );
    }
}