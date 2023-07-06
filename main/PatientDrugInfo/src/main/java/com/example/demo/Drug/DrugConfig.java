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
            // (drugName, pseudonyms, drugClass, strength, dosing, form, brandName);
            Drug amoxicillin = new Drug();
            repository.saveAll(List.of(amoxicillin));
        };
    }
}
