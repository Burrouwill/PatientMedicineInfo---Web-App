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
            Drug amoxicillin = new Drug(
                    "Amoxicillin",
                    null,
                    List.of("Alphamox", "Apotex", "m-Amoxicillin"),
                    Drug.DrugClass.ANTIBIOTIC,
                    "500mg",
                    "500mg capsule every 8 hours",
                    Drug.DrugForm.CAPSULE,
                    null);
            repository.saveAll(List.of(amoxicillin));
        };
    }
}
