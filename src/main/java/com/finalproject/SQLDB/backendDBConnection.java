/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalproject.SQLDB;

import com.finalproject.backend.ClinicalResearcherReport;
import com.finalproject.backend.ClinicalResearcherReportDirectory;
import com.finalproject.backend.DevelopmentReport;
import com.finalproject.backend.DevelopmentReportDir;
import com.finalproject.backend.Employee;
import com.finalproject.backend.EmployeeDirectory;
import com.finalproject.backend.InspectionReportDirectory;
import com.finalproject.backend.InspectionReview;
import com.finalproject.backend.MedicalReport;
import com.finalproject.backend.MedicalReportDirectory;
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
    
    public ArrayList<String> convertStringToArray(String data){
     String[] strSplit = data.split(", " );
     ArrayList<String> array = new ArrayList<String>(Arrays.asList(strSplit));
     return array;
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
     
     public void retrieveDevReport(Connection con, DevelopmentReportDir drr) throws SQLException{
         String retrieveFromDevReports = "SELECT * from DevelopmentReport";
         DevelopmentReportDir drrTemp = drr;
         ArrayList<DevelopmentReport> drrArray = drr.getDevRepDir();
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(retrieveFromDevReports);
         while(rs.next()){
             DevelopmentReport dr = new DevelopmentReport();
             dr.setReportID(rs.getString("ReportID"));
             dr.setComposition(convertStringToArray(rs.getString("Composition")));
             dr.setResearchBy(rs.getString("ResearchBy"));
             dr.setDrugName(rs.getString("DrugName"));
             dr.setDiseaseTarget(rs.getString("DiseaseTarget"));
             dr.setDate(rs.getString("Date"));
             dr.setDrugNotes(rs.getString("DrugNotes"));
             dr.setReportTo(rs.getString("ReportTo"));
             dr.setDevAssigned(rs.getString("DevAssigned"));
             dr.setEnterpriseName(rs.getString("EnterpriseName"));
             drrArray.add(dr);
         }
         drrTemp.setDevRepDir(drrArray);
     }
     
     public void addClinicalResearcherReport(Connection conn, ClinicalResearcherReport crr) throws SQLException{
         String insertIntoClincalResearchReport = "INSERT INTO ClinicalResearchReport(ReportID, DrugName, Composition, Date, DiseaseTarget, ResearchBy, ReportTo, EnterpriseName, Dosage, Distribution, DevAssigned, AssignedGLPOfficer, AssignedClinicalResearcher, Reactions, SideEffects) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
         PreparedStatement stmt = conn.prepareStatement(insertIntoClincalResearchReport);
         stmt.setString(1, crr.getReportID());
         stmt.setString(2, crr.getDrugName());
         String compString = String.join(", ", crr.getComposition());
         stmt.setString(3, compString);
         stmt.setString(4, crr.getDate());
         stmt.setString(5, crr.getDiseaseTarget());
         stmt.setString(6, crr.getResearchBy());
         stmt.setString(7, crr.getReportTo());
         stmt.setString(8, crr.getEnterpriseName());
         String dosage = String.join(", ", crr.getDosage());
         stmt.setString(9, dosage);
         stmt.setString(10, crr.getDistribution());
         stmt.setString(11, crr.getDevAssigned());
         stmt.setString(12, crr.getAssignedGLPOfficer());
         stmt.setString(13, crr.getAssignedClinicalResearcher());
         stmt.executeUpdate();
     }    
     
     public void updateClinicalResearcherReport(Connection conn, ClinicalResearcherReport crr)throws SQLException{
         //String getOneResult = String.format("SELECT * from ClinicalResearchReport WHERE ReportID = '{}'", ID);
         String updateOneRow = "UPDATE ClinicalResearcherReport set Reactions = ?, SideEffects = ? WHERE ReportID = ?";
         PreparedStatement stmt = conn.prepareStatement(updateOneRow);
         stmt.setString(1, crr.getDrugReaction());
         stmt.setString(2, crr.getSideEffects());
         stmt.setString(3, crr.getReportID());
         stmt.executeUpdate();         
     }
     
     public void retrieveClinicalResearchReport(Connection conn, ClinicalResearcherReportDirectory crd) throws SQLException{
         String retrieveFromDevReports = "SELECT * from DevelopmentReport";
         ClinicalResearcherReportDirectory crdTemp = crd;
         ArrayList<ClinicalResearcherReport> crTe = crd.getClinicalReportDir();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(retrieveFromDevReports);
         while(rs.next()){
             ClinicalResearcherReport cr = new ClinicalResearcherReport();
             cr.setReportID(rs.getString("ReportID"));
             cr.setDrugName(rs.getString("DrugName"));
             cr.setComposition(convertStringToArray(rs.getString("Composition")));
             cr.setDate(rs.getString("Date"));
             cr.setDiseaseTarget(rs.getString("DiseaseTarget"));
             cr.setResearchBy(rs.getString("ResearchBy"));
             cr.setReportTo(rs.getString("ResearchTo"));
             cr.setEnterpriseName(rs.getString("EnterpriseName"));
             cr.setDosage(convertStringToArray(rs.getString("Dosage")));
             cr.setDistribution(rs.getString("Distribution"));
             cr.setDevAssigned(rs.getString("DevAssigned"));
             cr.setAssignedGLPOfficer(rs.getString("AssignedGLPOfficer"));
             cr.setAssignedClinicalResearcher(rs.getString("AssignedClinicalResearcher"));
             cr.setSideEffects(rs.getString("SideEffects"));
             cr.setDrugReaction(rs.getString("Reactions"));
             crTe.add(cr);
         }
         
         crdTemp.setClinicalReportDir(crTe);
     }
     
     public void addInspectionReport(Connection conn, InspectionReview ir) throws SQLException{
         String insertIntoInspectionReport = "INSERT INTO InspectionReport(ReportID, EnterpriseName, InspectorName, DrugName, Date, DiseaseTarget, InspectionType, InspectionDate, InspectionRemarks, InspectionResult) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
         PreparedStatement stmt = conn.prepareStatement(insertIntoInspectionReport);
         stmt.setString(1, ir.getReportID());
         stmt.setString(2, ir.getEnterpriseName());
         stmt.setString(3, ir.getName());
         stmt.setString(4, ir.getDrugName());
         stmt.setString(5, ir.getDate());
         stmt.setString(6, ir.getDiseaseTarget());
         stmt.setString(7, ir.getInspectionType());
         stmt.setString(8, ir.getInspectionDate());
         stmt.setString(9, ir.getInspectionRemarks());
         stmt.setString(10, ir.getInspectionResult());
         stmt.executeUpdate();
     }
     
     public void retrieveInspectionReport(Connection conn, InspectionReportDirectory ird) throws SQLException{
         String retrieveFromDevReports = "SELECT * from DevelopmentReport";
         InspectionReportDirectory irdTemp = ird;
         ArrayList<InspectionReview> irArray = ird.getInspectionRepo();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(retrieveFromDevReports);
         while(rs.next()){
             InspectionReview ir = new InspectionReview();
             ir.setReportID(rs.getString("ReportID"));
             ir.setEnterpriseName(rs.getString("EnterpriseName"));
             ir.setName(rs.getString("InspectorName"));
             ir.setDrugName(rs.getString("DrugName"));
             ir.setDate(rs.getString("Date"));
             ir.setDiseaseTarget(rs.getString("DiseaseTarget"));
             ir.setInspectionType(rs.getString("InspectionType"));
             ir.setInspectionDate(rs.getString("InspectionDate"));
             ir.setInspectionRemarks(rs.getString("InspectionRemarks"));
             ir.setInspectionResult(rs.getString("InpsectionResult"));
             irArray.add(ir);
         }
         irdTemp.setInspectionRepo(irArray);
     }
     
     public void addMedicalReport(Connection conn, MedicalReport mr) throws SQLException{
         String insertIntoMedicalReport = "INSERT INTO MedicalReport(ReportID, EnterpriseName, DrugName, Date, DiseaseTarget, ReportTo, FinalApproval, ToxicologySpecialist, MedicalOfficer, ToxinsFound) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
         PreparedStatement stmt = conn.prepareStatement(insertIntoMedicalReport);
         stmt.setString(1, mr.getReportID());
         stmt.setString(2, mr.getEnterpriseName());
         stmt.setString(3, mr.getDrugName());
         stmt.setString(4, mr.getDate());
         stmt.setString(5, mr.getDiseaseTarget());
         stmt.setString(6, mr.getReportTo());
         stmt.setString(7, mr.getFinalApproval());
         stmt.setString(8, mr.getToxicologySpecialist());
         stmt.setString(9, mr.getMedicalOfficer());
         stmt.setString(10, mr.getToxinsFound());
         stmt.executeUpdate();
     }
     
     public void updateMedicalReport(Connection conn, MedicalReport ir) throws SQLException{
         String updateOneRow = "UPDATE ClinicalResearcherReport set FinalApproval = ? WHERE ReportID = ?";
         PreparedStatement stmt = conn.prepareStatement(updateOneRow);
         stmt.setString(1, ir.getFinalApproval());
         stmt.setString(2, ir.getReportID());
         stmt.executeUpdate();
     }
     
     public void retrieveMedicalReport(Connection conn, MedicalReportDirectory medrd) throws SQLException{
         String retrieveFromMedicalReport = "SELECT * from MedicalReport";
         MedicalReportDirectory mrdTemp = medrd;
         ArrayList<MedicalReport> medArray = medrd.getMediRep();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(retrieveFromMedicalReport);
         while(rs.next()){
             MedicalReport med = new MedicalReport();
             med.setReportID(rs.getString("ReportID"));
             med.setEnterpriseName(rs.getString("EnterpriseName"));
             med.setDrugName(rs.getString("DrugName"));
             med.setDate(rs.getString("Date"));
             med.setDiseaseTarget(rs.getString("DiseaseTarget"));
             med.setReportTo(rs.getString("ReportTo"));
             med.setFinalApproval(rs.getString("FinalApproval"));
             med.setToxicologySpecialist(rs.getString("ToxicologySpecialist"));
             med.setMedicalOfficer(rs.getString("MedicalOfficer"));
             med.setToxinsFound(rs.getString("ToxinsFound"));
             medArray.add(med);
         }
         mrdTemp.setMediRep(medArray);
     }
     
}
