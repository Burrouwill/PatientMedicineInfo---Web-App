package com.example.demo.drug;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/drug")
public class DrugController {

    private final  DrugService drugService;

    @Autowired
    // Dependency Injection --> LetsSpring know that
    // ddrugservice instance must be instantiated via dependency injection
    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping
    @Transactional
    public List<Drug> getDrugs(){
        return drugService.getDrugs();
    }

}
