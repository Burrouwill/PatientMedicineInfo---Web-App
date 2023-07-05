package com.example.demo.Data;

import com.example.demo.Adr.Adr;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class AdrParser {

    public List<Adr> parseAdrsFromText(Resource data) {
        try (Scanner scanner = new Scanner(data.getInputStream())) {
            List<Adr> adrs = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty()) {
                    continue; // Skip empty lines
                }

                String[] parts = line.split("\""); // Split the line using "
                if (parts.length >= 2) {
                    String effect = parts[1]; // Get the effect from the second element
                    String advice = parts[1]; // Get the advice from the third element

                    adrs.add(new Adr(effect.trim(), advice.trim()));
                }
            }

            return adrs;
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse Adrs.");
        }
    }
}

