package com.example.demo.Configs;

import com.example.demo.Repositories.AdrRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
