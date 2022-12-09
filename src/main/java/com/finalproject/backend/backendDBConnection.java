/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalproject.backend;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author tarush
 */
public class backendDBConnection {
    
    public Connection connectoDB(){
        Connection con = null;
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:backendDB.sqlite");
            System.out.println("Connected successfully");
            con = conn;
        }catch(Exception e){
            System.out.println("Connection failed due to: " + e);
            return null;
        }
        return con;
    }
}
