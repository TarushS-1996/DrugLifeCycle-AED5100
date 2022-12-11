/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalproject.backend;

import java.util.Date;

/**
 *
 * @author kalzayy
 */
public class InspectionReview extends MedicalReport{
    private String inspectionRemarks;
    private String inspectionType;
    private String inspectionDate;
    private String inspectionResult;

    public String getInspectionRemarks() {
        return inspectionRemarks;
    }

    public void setInspectionRemarks(String inspectionRemarks) {
        this.inspectionRemarks = inspectionRemarks;
    }

    public String getInspectionType() {
        return inspectionType;
    }

    public void setInspectionType(String inspectionType) {
        this.inspectionType = inspectionType;
    }

    public String getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getInspectionResult() {
        return inspectionResult;
    }

    public void setInspectionResult(String inspectionResult) {
        this.inspectionResult = inspectionResult;
    }
}
