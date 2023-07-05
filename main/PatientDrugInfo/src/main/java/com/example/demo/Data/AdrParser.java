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
            StringBuilder adrBuilder = new StringBuilder();
            boolean isReadingAdr = false;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty()) {
                    if (isReadingAdr) {
                        String adrText = adrBuilder.toString().trim();
                        if (!adrText.isEmpty()) {
                            String[] parts = adrText.split("\"");
                            if (parts.length >= 2) {
                                String effect = parts[1].replaceAll("\\s+", " ").replaceAll("\\n+", " ");
                                String advice = parts[3].replaceAll("\\s+", " ").replaceAll("\\n+", " ");; // Use index 3 for the advice part

                                adrs.add(new Adr(effect.trim(), advice.trim()));
                            }
                        }

                        adrBuilder.setLength(0);
                        isReadingAdr = false;
                    }
                    continue; // Skip empty lines
                }

                adrBuilder.append(line).append("\n");
                isReadingAdr = true;
            }

            if (isReadingAdr) {
                // Handle the last ADR if there is no empty line at the end
                String adrText = adrBuilder.toString().trim();
                if (!adrText.isEmpty()) {
                    String[] parts = adrText.split("\"");
                    if (parts.length >= 2) {
                        String effect = parts[1];
                        String advice = parts[3]; // Use index 3 for the advice part

                        adrs.add(new Adr(effect.trim(), advice.trim()));
                    }
                }
            }

            return adrs;
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse Adrs.");
        }
    }

}

