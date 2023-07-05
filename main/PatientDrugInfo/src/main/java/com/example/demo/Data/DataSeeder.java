package com.example.demo.Data;

import com.example.demo.Adr.Adr;
import com.example.demo.Adr.AdrRepository;
import com.example.demo.Drug.Drug;
import com.example.demo.Drug.DrugRepository;
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

    private final AdrRepository adrRepository;
    private final DrugRepository drugRepository;
    private final ResourceLoader resourceLoader;

    public DataSeeder(AdrRepository adrRepository, DrugRepository drugRepository, ResourceLoader resourceLoader) {
        this.adrRepository = adrRepository;
        this.drugRepository = drugRepository;
        this.resourceLoader = resourceLoader;
    }

    @PostConstruct
    public void seedData(){
        Resource drugResource = resourceLoader.getResource("classpath:DrugData");
        Resource adrResource = resourceLoader.getResource("classpath:AdrData");


        parseAndLoadDrugs(drugResource);
        parseAndLoadAdrs(adrResource);
    }

    private void parseAndLoadDrugs(Resource data){
        DrugParser drugParser = new DrugParser();
        List<Drug> drugs = drugParser.parseDrugsFromText(data);
        drugRepository.saveAll(drugs);
    }

    private void parseAndLoadAdrs(Resource data){
        AdrParser adrParser = new AdrParser();
        List<Adr> adrs = adrParser.parseAdrsFromText(data);
        adrRepository.saveAll(adrs);
    }

}

