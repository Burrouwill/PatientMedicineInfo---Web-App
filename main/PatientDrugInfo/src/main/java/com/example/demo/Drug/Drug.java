package com.example.demo.Drug;

import com.example.demo.Adr.Adr;
import jakarta.persistence.*;

import java.util.List;

/**
 * Represents a Drug and some of the characteristics of that Drug.
 */
@Entity
@Table(name = "Drug")
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int drugId;

    private String drugName;

    @ManyToMany
    @JoinTable(name = "drug_advice",
            joinColumns = @JoinColumn(name = "drug_id"),
            inverseJoinColumns = @JoinColumn(name = "advice_id"))
    private List<Adr> advice;

    @ElementCollection
    private List<String> pseudonyms;

    @Enumerated(EnumType.STRING)
    private List<DrugClass> drugClass;

    private String strength;
    private String dosing;

    @Enumerated(EnumType.STRING)
    private DrugForm form;
    private String brandName;

    public Drug() {

    }

    public Drug(String drugName, List<Adr> advice, List<String> pseudonyms, List<DrugClass> drugClass, String strength, String dosing, DrugForm form, String brandName) {
        this.drugName = drugName;
        this.advice = advice;
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
        ANTIDEPRESSANT("Commonly used to treat depression & anxiety."),
        ANALGESIC("Used for pain relief."),
        ANTIHYPERTENSIVE("Used to lower blood pressure."),
        ANTIHISTAMINE_1STGEN("Used to relieve allergy symptoms."),
        ANTIHISTAMINE_2NDGEN("Used to relieve allergy symptoms."),
        ANTIINFLAMMATORY("Used to reduce inflammation."),
        ANTICOAGULANT("Used to prevent blood clotting."),
        ANTICONVULSANT("Used to control seizures."),
        ANTIDIABETIC("Used to manage diabetes."),
        ANTIEMETIC("Used to prevent or treat nausea and vomiting."),
        ANTIFUNGAL("Used to treat fungal infections."),
        ANTIPLATELET("Used to prevent blood clots."),
        ANTIPSYCHOTIC("Used to manage mental health disorders."),
        ANTIVIRAL("Used to treat viral infections."),
        DIURETIC("Used to increase urine production."),
        IMMUNOSUPPRESSANT("Used to suppress the immune system."),
        LAXATIVE("Used to promote bowel movements."),
        MUSCLE_RELAXANT("Used to relax muscles."),
        NSAID("Nonsteroidal anti-inflammatory drugs used for pain and inflammation."),
        SEDATIVE("Used to promote relaxation and sleep."),
        STEROID("Used for their anti-inflammatory properties."),
        THYROID("Used to manage thyroid disorders."),
        VITAMIN("Used to supplement vitamin deficiencies.");

        private final String description;

        DrugClass(String description) {
            this.description = description;
        }

        public String getDesription() {
            return description;
        }
    }

    /**
     * The different physical forms / delivery systems a Drug can be delivered in.
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

    public List<DrugClass> getDrugClass() {
        return drugClass;
    }

    public void setDrugClass(List<DrugClass> drugClass) {
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
