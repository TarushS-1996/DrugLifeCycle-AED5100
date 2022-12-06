/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalproject.backend;

/**
 *
 * @author Harshveen
 */
public class ClinicalResearcherReport extends DevelopmentReport{
    private String assignedClinicalResearcher;
    private String assignedGLPOfficer;
    private int numberOfVolunteers;
    private String drugReaction;
    private String sideEffects;

    public String getDrugReaction() {
        return drugReaction;
    }

    public void setDrugReaction(String drugReaction) {
        this.drugReaction = drugReaction;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public int getNumberOfVolunteers() {
        return numberOfVolunteers;
    }

    public void setNumberOfVolunteers(int numberOfVolunteers) {
        this.numberOfVolunteers = numberOfVolunteers;
    }

    public String getAssignedGLPOfficer() {
        return assignedGLPOfficer;
    }

    public void setAssignedGLPOfficer(String assignedGLPOfficer) {
        this.assignedGLPOfficer = assignedGLPOfficer;
    }

    public String getAssignedClinicalResearcher() {
        return assignedClinicalResearcher;
    }

    public void setAssignedClinicalResearcher(String assignedClinicalResearcher) {
        this.assignedClinicalResearcher = assignedClinicalResearcher;
    }
}
