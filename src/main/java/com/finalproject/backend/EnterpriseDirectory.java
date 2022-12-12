/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalproject.backend;

import java.util.ArrayList;

/**
 *
 * @author tarush
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> entDir = new ArrayList();
    
    public EnterpriseDirectory(){
        this.entDir = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEntDir() {
        return entDir;
    }

    public void setEntDir(ArrayList<Enterprise> entDir) {
        this.entDir = entDir;
    }
    
    public Enterprise addEnterprise(){
        Enterprise ent = new Enterprise();
        entDir.add(ent);
        return ent;
    }
}
