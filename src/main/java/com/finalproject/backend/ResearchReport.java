/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalproject.backend;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ramit
 */
public class ResearchReport extends Employee{
    private String reportID;
    private String researchBy;
    private String drugName;
    private String diseaseTarget;
    private Date date;
    private String drugNotes;
    private String reportTo;
    private ArrayList<String> composition;
    private String status;
    /*private Employee empDet;
    
    public ResearchReport(){
        ResearchReport res = new ResearchReport();
    }
    
    public ResearchReport(Employee emp){
        this.empDet = emp;
    }

    public Employee getEmpDet() {
        return empDet;
    }*/

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public ArrayList<String> getComposition() {
        return composition;
    }

    public String getReportID() {
        return reportID;
    }

    public void setReportID(String reportID) {
        this.reportID = reportID;
    }
        
    public String getResearchBy() {
        return researchBy;
    }

    public void setResearchBy(String researchBy) {
        this.researchBy = researchBy;
    }

    public void setComposition(ArrayList<String> composition) {
        this.composition = composition;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDiseaseTarget() {
        return diseaseTarget;
    }

    public void setDiseaseTarget(String diseaseTarget) {
        this.diseaseTarget = diseaseTarget;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDrugNotes() {
        return drugNotes;
    }

    public void setDrugNotes(String drugNotes) {
        this.drugNotes = drugNotes;
    }

    public String getReportTo() {
        return reportTo;
    }

    public void setReportTo(String reportTo) {
        this.reportTo = reportTo;
    }
}
