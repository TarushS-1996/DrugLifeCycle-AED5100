/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalproject.backend;

import java.util.ArrayList;
import com.finalproject.backend.Employee;

/**
 *
 * @author tarush
 */
public class ResearchReportDirectory {
    private ArrayList<ResearchReport> researchReportdsDir = new ArrayList<>();
    
    public ResearchReportDirectory(){
        this.researchReportdsDir = new ArrayList<>();
    }

    public ArrayList<ResearchReport> getResearchReportdsDir() {
        return researchReportdsDir;
    }

    public void setResearchReportdsDir(ArrayList<ResearchReport> researchReportdsDir) {
        this.researchReportdsDir = researchReportdsDir;
    }
    
    public ResearchReport addNewReport(Employee emp){
        ResearchReport rr = new ResearchReport();
        researchReportdsDir.add(rr);
        return rr;
    }
    
}
