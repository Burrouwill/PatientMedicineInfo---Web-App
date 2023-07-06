package com.example.demo.Data;

import com.example.demo.Adr.Adr;
import com.example.demo.Drug.Drug;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Parses data from Drugs text file. Creates Drug objects and adds to postgres.
 */
public class DrugParser {
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
                            if (parts.length == 8){

                                String drugName = parseDrugname(parts[0]);
                                List<Adr> advice = parseAdvice(parts[1]);
                                List<String> pseudonyms = parsePseuonyms(parts[2]);
                                List<Drug.DrugClass> drugClass = parseDrugClass(parts[3]);
                                String strength = parseStrength(parts[4]);
                                String dosing = parseDosing(parts[5]);
                                Drug.DrugForm form = parseDrugForm(parts[6]);
                                String brandName = parseBrandName(parts[7]);

                                drugs.add(new Drug(drugName,advice,pseudonyms,drugClass,strength,dosing,form,brandName));
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

            if (isReading) {
                // Handle last Drug if no empty line
                String drugText = drugBuilder.toString();
                if (!drugText.isEmpty()) {
                    String[] parts = drugText.split("\n");
                    if (parts.length == 8){

                        String drugName = parseDrugname(parts[0]);
                        List<Adr> advice = parseAdvice(parts[1]);
                        List<String> pseudonyms = parsePseuonyms(parts[2]);
                        List<Drug.DrugClass> drugClass = parseDrugClass(parts[3]);
                        String strength = parseStrength(parts[4]);
                        String dosing = parseDosing(parts[5]);
                        Drug.DrugForm form = parseDrugForm(parts[6]);
                        String brandName = parseBrandName(parts[7]);

                        drugs.add(new Drug(drugName,advice,pseudonyms,drugClass,strength,dosing,form,brandName));
                    }
                }
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
    }

    private Drug.DrugForm parseDrugForm(String part) {
    }

    private String parseDosing(String part) {
    }

    private String parseStrength(String part) {
    }

    private List<Drug.DrugClass> parseDrugClass(String part) {
    }

    private List<String> parsePseuonyms(String part) {
    }

    private List<Adr> parseAdvice(String part) {
    }

    private String parseDrugname(String part) {
    }
}
