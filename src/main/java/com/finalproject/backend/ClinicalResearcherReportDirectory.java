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
public class ClinicalResearcherReportDirectory {
    private ArrayList<ClinicalResearcherReport> clinicalReportDir = new ArrayList<>();
    
    public ClinicalResearcherReportDirectory(){
        this.clinicalReportDir = new ArrayList<>();
    }

    public ArrayList<ClinicalResearcherReport> getClinicalReportDir() {
        return clinicalReportDir;
    }

    public void setClinicalReportDir(ArrayList<ClinicalResearcherReport> clinicalReportDir) {
        this.clinicalReportDir = clinicalReportDir;
    }
    
    public ClinicalResearcherReport addTrails(){
        ClinicalResearcherReport crr = new ClinicalResearcherReport();
        clinicalReportDir.add(crr);
        return crr;
    }
    
    public ClinicalResearcherReport sendSpecificReport(String ID){
        ClinicalResearcherReport c = new ClinicalResearcherReport();
        for (ClinicalResearcherReport cr : clinicalReportDir){
            if(cr.getReportID().equals(ID)){
                c = cr;
            }
        }
        return c;
    }
    
}
