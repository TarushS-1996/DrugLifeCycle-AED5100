/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalproject.SQLDB;

import com.finalproject.backend.DevelopmentReport;
import com.finalproject.backend.Employee;
import com.finalproject.backend.EmployeeDirectory;
import com.finalproject.backend.ResearchReport;
import com.finalproject.backend.ResearchReportDirectory;
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
import java.util.Arrays;
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
     
     public void addResearchReport(Connection conn, ResearchReport rr)throws SQLException{
         String insertIntoResearcTable = "INSERT INTO ResearchReport(ResearchBy, DrugName, DiseaseTarget, Date, DrugNotes, ReportTo, ReportID, EnterpriseName, Composition) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
         PreparedStatement pstmt = conn.prepareStatement(insertIntoResearcTable);
         pstmt.setString(1, rr.getResearchBy());
         pstmt.setString(2, rr.getDrugName());
         pstmt.setString(3, rr.getDiseaseTarget());
         pstmt.setString(4, rr.getDate().toString());
         pstmt.setString(5, rr.getDrugNotes());
         pstmt.setString(6, rr.getReportTo());
         pstmt.setString(7, rr.getReportID());
         pstmt.setString(8, rr.getEnterpriseName());
         String compString = String.join(", ", rr.getComposition());
         pstmt.setString(9, compString);
         pstmt.executeUpdate();
     }
     
     public void retrieveResearchReport(Connection con, ResearchReportDirectory rrd) throws SQLException{
         String retrieveResearchReportData = "SELECT * from ResearchReport";
         ResearchReportDirectory rrD = rrd;
         ArrayList<ResearchReport> rrTemp = rrd.getResearchReportdsDir();
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(retrieveResearchReportData);
         while (rs.next()){
             ResearchReport rr = new ResearchReport();
             rr.setResearchBy(rs.getString("ResearchBy"));
             rr.setDrugName(rs.getString("DrugName"));
             rr.setDiseaseTarget(rs.getString("DiseaseTarget"));
             rr.setDate(rs.getString("Date"));
             rr.setDrugNotes(rs.getString("DrugNotes"));
             rr.setReportTo(rs.getString("ReportTo"));
             rr.setReportID(rs.getString("ReportID"));
             rr.setEnterpriseName(rs.getString("EnterpriseName"));
             String temp = rs.getString("Composition");
             String[] strSplit = temp.split(", ");
             ArrayList<String> compList = new ArrayList<String>(Arrays.asList(strSplit));
             rr.setComposition(compList);
             
             rrTemp.add(rr);
         }
         rrD.setResearchReportdsDir(rrTemp);
     }
     
     public void addDevelopmentReport(Connection con, DevelopmentReport dr) throws SQLException{
         String insertIntoDevelopmentReport = "INSERT INTO DevelopmentReport(ReportID, Composition, ResearchBy, DrugName, DiseaseTarget, Date, DrugNotes, ReportTo, DevAssigned, EnterpriseName) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
         PreparedStatement stmt = con.prepareStatement(insertIntoDevelopmentReport);
         stmt.setString(1, dr.getReportID());
         String compString = String.join(", ", dr.getComposition());
         stmt.setString(2, compString);
         stmt.setString(3, dr.getResearchBy());
         stmt.setString(4, dr.getDrugName());
         stmt.setString(5, dr.getDiseaseTarget());
         stmt.setString(6, dr.getDate());
         stmt.setString(7, dr.getDrugNotes());
         stmt.setString(8, dr.getReportTo());
         stmt.setString(9, dr.getDevAssigned());
         stmt.setString(10, dr.getEnterpriseName());
         stmt.executeUpdate();
     }
     
     public void retrieveDevReport(){}
}
