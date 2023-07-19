package com.example.demo.Configs;

import com.example.demo.Repositories.DrugRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DrugConfig {

    @Bean
    CommandLineRunner commandLineRunner(DrugRepository repository) {
        return args -> {

        };
    }
}
