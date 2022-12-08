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
public class MedicalReportDirectory {
    private ArrayList<MedicalReport> mediRep = new ArrayList<>();
    
    public MedicalReportDirectory(){
        this.mediRep = new ArrayList<>();
    }

    public ArrayList<MedicalReport> getMediRep() {
        return mediRep;
    }

    public void setMediRep(ArrayList<MedicalReport> mediRep) {
        this.mediRep = mediRep;
    }
    
    public MedicalReport addMediReport(){
        MedicalReport med = new MedicalReport();
        mediRep.add(med);
        return med;        
    }
    
    public MedicalReport sendSpecificMedicalReport(String ID){
        MedicalReport med = new MedicalReport();
        for(MedicalReport md: mediRep){
            if(md.getReportID().equals(ID)){
                med = md;
            }
        }return med;
    }
    
}
