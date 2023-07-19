package com.example.demo.Data;

import com.example.demo.Models.Adr;
import com.example.demo.Repositories.AdrRepository;
import com.example.demo.Services.AdrService;
import com.example.demo.Models.Drug;
import com.example.demo.Repositories.DrugRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Handles the parsing of Drug and Adr informtation.
 * Loads this parsed data into database upon startup.
 */
@Component
public class DataSeeder {

    private final AdrRepository adrRepository; // For mapping adrs to postgres
    private final AdrService adrService; // To call findAdrById(), as this is business logic and not CRUD? Unsure if it really belongs here
    private final DrugRepository drugRepository;
    private final ResourceLoader resourceLoader;

    public DataSeeder(AdrRepository adrRepository, AdrService adrService, DrugRepository drugRepository, ResourceLoader resourceLoader) {
        this.adrRepository = adrRepository;
        this.adrService = adrService;
        this.drugRepository = drugRepository;
        this.resourceLoader = resourceLoader;
    }

    @PostConstruct
    public void seedData(){
        Resource drugResource = resourceLoader.getResource("classpath:DrugData");
        Resource adrResource = resourceLoader.getResource("classpath:AdrData");

        parseAndLoadAdrs(adrResource);
        parseAndLoadDrugs(drugResource);
    }

    private void parseAndLoadDrugs(Resource data){
        DrugParser drugParser = new DrugParser(adrService);

        List<Drug> drugs = drugParser.parseDrugsFromText(data);
        drugRepository.saveAll(drugs);
    }

    private void parseAndLoadAdrs(Resource data){
        AdrParser adrParser = new AdrParser();

        List<Adr> adrs = adrParser.parseAdrsFromText(data);
        adrRepository.saveAll(adrs);
    }
}

