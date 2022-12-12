/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalproject.backend;

import java.util.Random;

/**
 *
 * @author tarush
 */
public class ConfigurationApp {
    
    public String entIDGen(){
        Random ran = new Random();
        int idInt = ran.nextInt(100);
        String encID = "ENI-"+idInt;
        return encID;
    }
    
    public void populateEnterprise(EnterpriseDirectory entD){
        //EnterpriseDirectory entDir = new EnterpriseDirectory();
        Enterprise en1 = entD.addEnterprise();
        en1.setEnterpriseName("Medical Institute");
        en1.setEnterpriseType("Discovery and development");
        en1.setEnterpriseID(entIDGen());
        
        Enterprise en2 = entD.addEnterprise();
        en2.setEnterpriseName("Clinical Research Institute");
        en2.setEnterpriseType("Clinical testing");
        en2.setEnterpriseID(entIDGen());
        
        Enterprise en3 = entD.addEnterprise();
        en3.setEnterpriseName("FDA");
        en3.setEnterpriseType("Review");
        en3.setEnterpriseID(entIDGen());
        
        Enterprise en4 = entD.addEnterprise();
        en4.setEnterpriseName("Safety Monitoring");
        en4.setEnterpriseType("Inspection");
        en4.setEnterpriseID(entIDGen());
    }
}
