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
public class AddAdvertisingDirectory {
    private ArrayList<AddAdvertising> advertisingDir = new ArrayList<>();
    
    public AddAdvertisingDirectory(){
        this.advertisingDir = new ArrayList<>();
    }

    public ArrayList<AddAdvertising> getAdvertisingDir() {
        return advertisingDir;
    }

    public void setAdvertisingDir(ArrayList<AddAdvertising> advertisingDir) {
        this.advertisingDir = advertisingDir;
    }
    
    public AddAdvertising addAdvertisingData(){
        AddAdvertising addv = new AddAdvertising();
        advertisingDir.add(addv);
        return addv;
    }
}
