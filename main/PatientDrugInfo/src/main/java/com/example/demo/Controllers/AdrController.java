package com.example.demo.Controllers;


import com.example.demo.Services.AdrService;
import com.example.demo.Models.Adr;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
@RestController
@RequestMapping(path = "api/v1/adr")
public class AdrController {

    private final AdrService adrService;

    @Autowired
    public AdrController(AdrService adrService) {
        this.adrService = adrService;
    }

    @GetMapping("/")
    @Transactional
    public List<Adr> getAdrs() {
        return adrService.getAdrs();
    }

    @GetMapping("/id/{id}")
    @Transactional
    public Adr getAdrById(@PathVariable int id) {
        return adrService.getAdrById(id);
    }
}

