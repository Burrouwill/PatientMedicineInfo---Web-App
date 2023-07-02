package com.example.demo.drug;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// Service / Componet do the same thing --> Service is  a spring
// thing that is more specific, allows StudentService to be used as
// a Spring Bean
public class DrugService {

    private final DrugRepository drugRepository;

    @Autowired
    public DrugService(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    @Transactional
    public List<Drug> getDrugs(){
        return drugRepository.findAll();
    }
}
