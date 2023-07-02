package com.example.demo.drug;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "drug")
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int drugId;

    private String drugName;

    @ElementCollection
    private List<String> pseudonyms;

    @Enumerated(EnumType.STRING)
    private DrugClass drugClass;

    private String strength;
    private String dosing;

    @Enumerated(EnumType.STRING)
    private DrugForm form;
    private String brandName;

    public Drug() {
        // Default constructor required by JPA
    }

    public Drug(String drugName, List<String> pseudonyms, DrugClass drugClass, String strength, String dosing, DrugForm form, String brandName) {
        this.drugName = drugName;
        this.pseudonyms = pseudonyms;
        this.drugClass = drugClass;
        this.strength = strength;
        this.dosing = dosing;
        this.form = form;
        this.brandName = brandName;
    }

    /**
     * Contains information about the general class of medicine & what it typically used to treat.
     */
    public enum DrugClass {

        ANTIBIOTIC("Used to treat bacterial infections."),
        ANTIDEPRESSANT("Commonly used to treat depression & anxiety.");

        private final String description;

        DrugClass(String description) {
            this.description = description;
        }

        public String getDesription() {
            return description;
        }
    }

    /**
     * The different physical forms / delivery systems a drug can be delivered in.
     */
    public enum DrugForm {
        BUCCAL_FILM,
        BUCCAL_TABLET,
        CAPSULE,
        CREAM,
        DROPS,
        EAR_DROPS,
        EYE_DROPS,
        GEL,
        IMPLANT,
        INHALER,
        INJECTION,
        INTRAARTICULAR_INJECTION,
        INTRACARDIAC_INJECTION,
        INTRACAVITARY_INJECTION,
        INTRACEREBRAL_INJECTION,
        INTRACRANIAL_INJECTION,
        INTRADERMAL_INJECTION,
        INTRAHEPATIC_INJECTION,
        INTRALENTICULAR_INJECTION,
        INTRALESIONAL_INJECTION,
        INTRAMENINGEAL_INJECTION,
        INTRAMUSCULAR_INJECTION,
        INTRAMUSCULAR_INJECTION_SUSPENSION,
        INTRAOCULAR_INJECTION,
        INTRAOSSEOUS_INJECTION,
        INTRAPERITONEAL_INJECTION,
        INTRAPLEURAL_INJECTION,
        INTRAPROSTATIC_INJECTION,
        INTRAPULMONARY_INJECTION,
        INTRASYNOVIAL_INJECTION,
        INTRATESTICULAR_INJECTION,
        INTRATHECAL_INJECTION,
        INTRATUMORAL_INJECTION,
        INTRAUTERINE_DEVICE,
        INTRAUTERINE_INJECTION,
        INTRAUTERINE_SYSTEM,
        INTRAVAGINAL_RING,
        INTRAVASCULAR_INJECTION,
        INTRAVENOUS_INJECTION,
        INTRAVENOUS_INJECTION_EMULSION,
        INTRAVENOUS_INJECTION_LIPOSOMES,
        INTRAVENOUS_INJECTION_MICELLES,
        INTRAVENOUS_INJECTION_SOLUTION,
        INTRAVENOUS_INJECTION_SUSPENSION,
        INTRAVITREAL_INJECTION,
        LOTION,
        MOUTH_RINSE,
        MOUTH_WASH,
        NASAL_DROPS,
        NASAL_SPRAY,
        OINTMENT,
        ORAL_CAPSULE,
        ORAL_DISINTEGRATING_TABLET,
        ORAL_FILM,
        ORAL_GEL,
        ORAL_LOZENGE,
        ORAL_PASTE,
        ORAL_POWDER,
        ORAL_SOLUTION,
        ORAL_SPRAY,
        ORAL_SUSPENSION,
        ORAL_SYRUP,
        ORAL_TABLET,
        PATCH,
        POWDER,
        RECTAL_CAPSULE,
        RECTAL_CREAM,
        RECTAL_ENEMA,
        RECTAL_FOAM,
        RECTAL_GEL,
        RECTAL_OINTMENT,
        RECTAL_POWDER,
        RECTAL_SOLUTION,
        RECTAL_SUPPOSITORY,
        RECTAL_SUSPENSION,
        RECTAL_TABLET,
        SOLUTION,
        SPRAY,
        SUBCUTANEOUS_IMPLANT,
        SUBCUTANEOUS_INJECTION,
        SUPPOSITORY,
        SUSPENSION,
        SYRUP,
        TABLET,
        TOPICAL_AEROSOL,
        TOPICAL_CREAM,
        TOPICAL_FOAM,
        TOPICAL_GEL,
        TOPICAL_LOTION,
        TOPICAL_OINTMENT,
        TOPICAL_POWDER,
        TOPICAL_SOLUTION,
        TOPICAL_SPRAY,
        TOPICAL_SUSPENSION,
        TOPICAL_TRANSDERMAL_GEL,
        TRANSDERMAL_GEL,
        TRANSDERMAL_PATCH,
        VAGINAL_CREAM,
        VAGINAL_RING,
        VAGINAL_SUPPOSITORY,
    }

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public List<String> getPseudonyms() {
        return pseudonyms;
    }

    public void setPseudonyms(List<String> pseudonyms) {
        this.pseudonyms = pseudonyms;
    }

    public DrugClass getDrugClass() {
        return drugClass;
    }

    public void setDrugClass(DrugClass drugClass) {
        this.drugClass = drugClass;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getDosing() {
        return dosing;
    }

    public void setDosing(String dosing) {
        this.dosing = dosing;
    }

    public DrugForm getForm() {
        return form;
    }

    public void setForm(DrugForm form) {
        this.form = form;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "drugId=" + drugId +
                ", drugName='" + drugName + '\'' +
                ", pseudonyms=" + pseudonyms +
                ", drugClass=" + drugClass +
                ", strength='" + strength + '\'' +
                ", dosing='" + dosing + '\'' +
                ", form=" + form +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
