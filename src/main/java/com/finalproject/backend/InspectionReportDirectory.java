/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalproject.backend;

import java.util.ArrayList;

/**
 *
 * @author kalzayy
 */
public class InspectionReportDirectory {
    private ArrayList<InspectionReview> inspectionRepo = new ArrayList<>();
    
    public InspectionReportDirectory(){
        this.inspectionRepo = new ArrayList<>();
    }

    public ArrayList<InspectionReview> getInspectionRepo() {
        return inspectionRepo;
    }

    public void setInspectionRepo(ArrayList<InspectionReview> inspectionRepo) {
        this.inspectionRepo = inspectionRepo;
    }
    
    public InspectionReview addInspectionReport(){
        InspectionReview ir = new InspectionReview();
        inspectionRepo.add(ir);
        return ir;
    }
}
