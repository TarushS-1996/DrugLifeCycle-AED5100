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
public class EmployeeDirectory {
    private ArrayList<Employee> empDir = new ArrayList<>();
    
    public EmployeeDirectory(){
        this.empDir = new ArrayList<>();
    }

    public ArrayList<Employee> getEmpDir() {
        return empDir;
    }

    public void setEmpDir(ArrayList<Employee> empDir) {
        this.empDir = empDir;
    }
    
    public Employee addEmployee(){
        Employee scientist = new Employee();
        empDir.add(scientist);
        return scientist;
    }
    
    public Employee sendParticularUser(String username, String password){
        Employee dr = new Employee();
        for(Employee d: empDir){
            if (username.equals(d.getUsername()) && password.equals(d.getPassword())){
                dr = d;                            
            }
        }return dr;
    }
}
