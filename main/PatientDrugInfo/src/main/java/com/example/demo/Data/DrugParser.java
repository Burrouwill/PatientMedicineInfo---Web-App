package com.example.demo.Data;

import com.example.demo.Adr.Adr;
import com.example.demo.Adr.AdrService;
import com.example.demo.Drug.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Parses data from Drugs text file. Creates Drug objects and adds to postgres.
 */
@Component
public class DrugParser {

    private final AdrService adrService;

    @Autowired
    public DrugParser(AdrService adrService) {
        this.adrService = adrService;
    }


    public List<Drug> parseDrugsFromText(Resource data) {
        try (Scanner scanner = new Scanner(data.getInputStream())) {

            List<Drug> drugs = new ArrayList<>();
            StringBuilder drugBuilder = new StringBuilder();
            boolean isReading = false;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Process the block of text once we find an empty line
                if (line.trim().isEmpty()) {
                    if (isReading) {
                        String drugText = drugBuilder.toString();
                        if (!drugText.isEmpty()) {
                            String[] parts = drugText.split("\n");
                            if (parts.length == 8) {

                                String drugName = parseDrugname(parts[0]);
                                List<Adr> advice = parseAdvice(parts[1]);
                                List<String> pseudonyms = parsePseudonyms(parts[2]);
                                List<Drug.DrugClass> drugClass = parseDrugClass(parts[3]);
                                String strength = parseStrength(parts[4]);
                                String dosing = parseDosing(parts[5]);
                                Drug.DrugForm form = parseDrugForm(parts[6]);
                                String brandName = parseBrandName(parts[7]);

                                if (drugName != null){
                                    drugs.add(new Drug(drugName, advice, pseudonyms, drugClass, strength, dosing, form, brandName));
                                }
                            }
                        }

                        drugBuilder.setLength(0);
                        isReading = false;
                    }
                    continue;

                }
                drugBuilder.append(line).append("\n");
                isReading = true;
            }

            return drugs;
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse Drugs.");
        }
    }

    /**
     * Helper Methods
     */
    private String parseBrandName(String part) {
        if (part.trim().isEmpty()) {
            throw new IllegalArgumentException("Empty BrandName");
        }
        if (part == "null") {
            return null;
        }
        return part;
    }

    private Drug.DrugForm parseDrugForm(String part) {
        if (part == null || part.trim().isEmpty()) {
            throw new IllegalArgumentException("Drug must have a form.");
        }
        return Drug.DrugForm.valueOf(part);
    }

    private String parseDosing(String part) {
        if (part == null || part.trim().isEmpty()) {
            throw new IllegalArgumentException("Drug must have a dose.");
        }
        return part;
    }

    private String parseStrength(String part) {
        if (part == null || part.trim().isEmpty()) {
            throw new IllegalArgumentException("Drug must have a strength.");
        }
        return part;
    }

    private List<Drug.DrugClass> parseDrugClass(String part) {
        if (part == null || part.trim().isEmpty()) {
            throw new IllegalArgumentException("Drug must have a class.");
        }
        // Process part into tidy sub strings
        String[] subStrings = part.replace("[", "").replace("]", "").trim().split(",");
        // Sort DrugClasses alphabetically, return the equivalent DrugClass Enum
        return Arrays.stream(subStrings)
                .sorted()
                .map(e -> Drug.DrugClass.valueOf(e.trim()))
                .toList();
    }

    private List<String> parsePseudonyms(String part) {
        if (part == null || part.trim().isEmpty()) {
            throw new IllegalArgumentException("Drug must have a brand name as well as a drug name.");
        }
        // Process part into tidy substrings
        String[] subStrings = part.replace("[", "").replace("]", "").trim().split(",");
        // Sort and return list of pseudonyms
        return Arrays.stream(subStrings).sorted().toList();
    }

    private List<Adr> parseAdvice(String part) {
        if (part.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid advice argument.");
        }
        if (part == "null") {
            return null;
        }
        // Process part into tidy substrings
        String[] subStrings = part.replace("[", "").replace("]", "").replace(" ", "").split(",");




        // Retrive & return list of Adr's
        return Arrays.stream(subStrings)
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue) // Convert Integer to int
                .mapToObj(adrService::getAdrById)
                .toList();
    }

    private String parseDrugname(String part) {
        if (part == null || part.trim().isEmpty()) {
            throw new IllegalArgumentException("Drug must have a name.");
        }
        return part.trim();
    }
}
