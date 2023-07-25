package com.example.demo.Controllers;

import com.example.demo.Services.DrugService;
import com.example.demo.Models.Drug;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/drug")
public class DrugController {

    private final DrugService drugService;

    @Autowired
    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping("/all")
    @Transactional
    public List<Drug> getDrugs() {
        return drugService.getDrugs();
    }

}
