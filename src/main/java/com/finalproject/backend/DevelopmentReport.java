/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalproject.backend;

import java.util.ArrayList;

/**
 *
 * @author Harshveen
 */
public class DevelopmentReport extends ResearchReport{
    private String devAssigned;
    private String Distribution;
    private ArrayList<String> dosage;
    private String status = "Under review";
    private String ClinicalResearchEnterprise;

    public String getClinicalResearchEnterprise() {
        return ClinicalResearchEnterprise;
    }

    public void setClinicalResearchEnterprise(String ClinicalResearchEnterprise) {
        this.ClinicalResearchEnterprise = ClinicalResearchEnterprise;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDistribution() {
        return Distribution;
    }

    public void setDistribution(String Distribution) {
        this.Distribution = Distribution;
    }

    public ArrayList<String> getDosage() {
        return dosage;
    }

    public void setDosage(ArrayList<String> dosage) {
        this.dosage = dosage;
    }

    public String getDevAssigned() {
        return devAssigned;
    }

    public void setDevAssigned(String devAssigned) {
        this.devAssigned = devAssigned;
    }
}
