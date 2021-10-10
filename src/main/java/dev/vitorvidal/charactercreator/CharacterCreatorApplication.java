package dev.vitorvidal.charactercreator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableWebSecurity
@EnableOpenApi
public class CharacterCreatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CharacterCreatorApplication.class, args);
    }
}
