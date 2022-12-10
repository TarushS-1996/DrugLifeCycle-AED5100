/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalproject.SQLDB;

import com.finalproject.backend.Employee;
import com.finalproject.backend.EmployeeDirectory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public void addEmployeeToDB(Connection conn, Employee emp) throws SQLException{
        String insertEmployeeSQL = "INSERT INTO Employee(Name, Age, DateOfBirth, Username, Passwrd, Gender, PhoneNumber, MailID, Address, Zipcode, EnterpriseName, OrganizationName, Role) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(insertEmployeeSQL);
        pstmt.setString(1, emp.getName());
        pstmt.setInt(2, emp.getAge());
        pstmt.setString(3, emp.getDateofBirth().toString());
        pstmt.setString(4, emp.getUsername());
        pstmt.setString(5, emp.getPassword());
        pstmt.setString(6, emp.getGender());
        pstmt.setInt(7, emp.getPhoneNumber());
        pstmt.setString(8, emp.getMailID());
        pstmt.setString(9, emp.getAddress());
        pstmt.setInt(10, emp.getZipcode());
        pstmt.setString(11, emp.getEnterpriseName());
        pstmt.setString(12, emp.getOrganizationName());
        pstmt.setString(13, emp.getRole());
        pstmt.executeUpdate();
        System.out.println(pstmt);
    }
     public void retrieveEmployeeDirectory(Connection conn, EmployeeDirectory empDir) throws SQLException{
         String retrieveData = "SELECT * from Employee";
         EmployeeDirectory emdir = empDir;
         ArrayList<Employee> empdir = empDir.getEmpDir();
         Statement stmt = conn.createStatement();
         DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
         ResultSet rs = stmt.executeQuery(retrieveData);
         while (rs.next()){
             Employee emp = new Employee();
             String date = rs.getString("DateOfBirth");
             emp.setName(rs.getString("Name"));
             emp.setAge(rs.getInt("Age"));
             emp.setDateofBirth(rs.getString("DateOfBirth"));
             emp.setUsername(rs.getString("Username"));
             emp.setPassword(rs.getString("Passwrd"));
             emp.setGender(rs.getString("Gender"));
             emp.setPhoneNumber(rs.getInt("PhoneNumber"));
             emp.setMailID(rs.getString("MailID"));
             emp.setAddress(rs.getString("Address"));
             emp.setZipcode(rs.getInt("Zipcode"));
             emp.setEnterpriseName(rs.getString("EnterpriseName"));
             emp.setOrganizationName(rs.getString("OrganizationName"));
             emp.setRole(rs.getString("Role"));
             empdir.add(emp);
         }
         emdir.setEmpDir(empdir);
     }
}
