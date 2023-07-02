package com.example.demo.SideEffect;

import jakarta.persistence.*;

/**
 * Represents a peice of information pertaining to an adverse reaction & some advice associated with it.
 */
@Entity
@Table(name = "advice")
public class DrugAdvice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adviceId;
    private String description;
    private String severity;


}
