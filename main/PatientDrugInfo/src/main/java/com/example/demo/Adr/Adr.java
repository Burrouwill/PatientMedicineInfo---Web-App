package com.example.demo.Adr;

import jakarta.persistence.*;

/**
 * Represents a peice of information pertaining to an adverse reaction & some advice associated with it.
 */
@Entity
@Table(name = "advice")
public class Adr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adviceId;
    @Column(length = 500)
    private String effect;
    @Column(length = 1000)
    private String advice;

    public Adr(){}

    public Adr(String effect, String advice) {
        this.effect = effect;
        this.advice = advice;
    }

    public int getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(int adviceId) {
        this.adviceId = adviceId;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    @Override
    public String toString() {
        return "Adr{" +
                "adviceId=" + adviceId +
                ", description='" + effect + '\'' +
                ", severity='" + advice + '\'' +
                '}';
    }
}
