package com.example.demo.Services;

import com.example.demo.Models.Adr;
import com.example.demo.Repositories.AdrRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdrService {

    private final AdrRepository adrRepository;

    @Autowired
    public AdrService(AdrRepository adrRepository) {
        this.adrRepository = adrRepository;
    }

    @Transactional
    public List<Adr> getAdrs() {
        return adrRepository.findAll();
    }

    @Transactional
    public Adr getAdrById(int adrId) {
        return adrRepository.findById(adrId).orElseThrow((() -> new IllegalArgumentException("Couldn't find any Adr with id: "+adrId)));
    }
}

