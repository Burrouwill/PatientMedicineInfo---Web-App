package com.example.demo.drug;

import jakarta.persistence.*;

@Entity
@Table
public class Drug {
    @Id
    @SequenceGenerator(
            name = "drug_id_sequence",
            sequenceName = "drug_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "drug_id_sequence"
    )
    private Long drug_id;
    private String drug_name;
    private String brand;

    public Drug(Long drug_id, String drug_name, String brand){
        this.drug_id = drug_id;
        this.drug_name = drug_name;
        this.brand = brand;
    }

    //DB handles id generation using serialisable attribute
    // Do I need both constructors?
    public Drug(String drug_name, String brand){
        this.drug_name = drug_name;
        this.brand = brand;
    }


}
