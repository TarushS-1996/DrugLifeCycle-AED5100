/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalproject.backend;

import java.util.ArrayList;

/**
 *
 * @author dotaw
 */
public class MedicalReport extends ClinicalResearcherReport{
    private String toxicologySpecialist;
    private String finalApproval = "Under review.";
    private String toxinsFound;
    private String medicalOfficer;

    public String getMedicalOfficer() {
        return medicalOfficer;
    }

    public void setMedicalOfficer(String medicalOfficer) {
        this.medicalOfficer = medicalOfficer;
    }

    public String getToxicologySpecialist() {
        return toxicologySpecialist;
    }

    public void setToxicologySpecialist(String toxicologySpecialist) {
        this.toxicologySpecialist = toxicologySpecialist;
    }

    public String getFinalApproval() {
        return finalApproval;
    }

    public void setFinalApproval(String finalApproval) {
        this.finalApproval = finalApproval;
    }

    public String getToxinsFound() {
        return toxinsFound;
    }

    public void setToxinsFound(String toxinsFound) {
        this.toxinsFound = toxinsFound;
    }



}
