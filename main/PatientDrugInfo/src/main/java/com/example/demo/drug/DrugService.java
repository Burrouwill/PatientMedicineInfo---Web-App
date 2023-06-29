package com.example.demo.drug;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
// Service / Componet do the same thing --> Service is  a spring
// thing that is more specific, allows StudentService to be used as
// a Spring Bean
public class DrugService {
    public List<Drug> getDrugs(){
        return List.of(
                new Drug("Insulin", "Pfizer")
        );
    }
}
