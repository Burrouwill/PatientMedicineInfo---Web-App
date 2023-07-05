package com.example.demo.Adr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AdrConfig {

    @Bean
    CommandLineRunner commandLineRunner2(AdrRepository repository) {
        return args -> {

            /*
            Drug Specific Adrs to be added:

            warfarin, ciclosporin, oral contraceptives, s monoamine oxidase inhibitors (MAOIs) and tyramine containing foods

             */

        };
    }
}
