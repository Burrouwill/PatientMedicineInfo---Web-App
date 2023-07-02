package com.example.demo.drug;

public enum DrugClassDescription {

    ANTIBIOTIC("Used to treat bacterial infections."),
    ANTIDEPRESSANT("Commonly used to treat depression & anxiety.");

    private final String description;

    DrugClassDescription(String description) {
        this.description = description;
    }

    public String getDesription() {
        return description;
    }
}
