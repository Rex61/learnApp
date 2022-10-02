package ru.agasbek.learnapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class LearnAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnAppApplication.class, args);
    }
}
