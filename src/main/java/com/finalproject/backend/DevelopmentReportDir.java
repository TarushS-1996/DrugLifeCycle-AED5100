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
public class DevelopmentReportDir {
    private ArrayList<DevelopmentReport> devRepDir = new ArrayList<>();
    
    public DevelopmentReportDir(){
        this.devRepDir = new ArrayList<>();
    }

    public ArrayList<DevelopmentReport> getDevRepDir() {
        return devRepDir;
    }

    public void setDevRepDir(ArrayList<DevelopmentReport> devRepDir) {
        this.devRepDir = devRepDir;
    }
    
    public DevelopmentReport addDevRep(){
        DevelopmentReport devRep = new DevelopmentReport();
        devRepDir.add(devRep);
        return devRep;
    }
}
