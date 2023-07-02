package com.example.demo.drug;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DrugConfig {

    @Bean
    CommandLineRunner commandLineRunner(DrugRepository repository){
        return args -> {
            Drug aspirin_1 = new Drug("Aspirin", "Ethics");
            Drug aspirin_2 = new Drug("Aspirin", "Pfizer");
            Drug a3 = new Drug("Kappa", "123");
            repository.saveAll(List.of(aspirin_1,aspirin_2,a3));
        };
    }
}
