package com.example.demo.Drug;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DrugConfig {

    @Bean
    CommandLineRunner commandLineRunner(DrugRepository repository) {
        return args -> {

        };
    }
}
