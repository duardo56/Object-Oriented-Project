/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lims;
import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author reticent
 */

public class SampleFile implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    //Declared Member Variables
    private String analysis;    //Person working on the sample
    private String status;  //Progress of the sample (accepted/rejected/work in progress/completed/revision)
    private int sampleID;   //The identifier of the sample (9-digit number)
    private String testType;    //The type of sample (gas/water/metal/ground)
    private String company; //Name of company working on order
    private double fidelity;    //The quality of the completed sample 
    private double expectedFidelity;    //Fidelity expected by company for analysis to achieve
    private String dueDate; //The date the sample needs to be completed by analysis
    private String sentDate;    //The date the sample sent by Client
    private String receivedDate;    //The date of the sample when it arrived at the enviroment lab
    private String completedDate;   //The date the sample was completed on
    
    
    //Default w/6 parameters(String, int, String, String, String, String)
    public SampleFile(String testType, int sampleID, String company, double expectedFidelity,String dueDate, String sentDate){
        this.status = "revision";
        this.sampleID = sampleID;
        this.company = company;
        this.expectedFidelity = expectedFidelity;
        this.dueDate = dueDate;
        this.sentDate = sentDate;
    }
    
    //Setters/Mutators
    //Set Current Status of the Sample
    public void setStatus(String status){
        this.status = status;
    }
    
    //Sets Analysis working on sample
    public void setAnalysis(String analysis){
        this.analysis = analysis;
    }
    
    //Sets Received Date of the Sample
    public void setReceivedDate(String receivedDate){
        this.receivedDate = receivedDate;
    }
    
    public void setFidelity(double fidelity){
        this.fidelity = fidelity;
    }
    
    //Accessors/Getters
    //Gets name of the Analsis working on sample
    public String getAnalysis() {
        return analysis;
    }

    //Gets current status of the sample (incomplete,WIP,complete,needsApproval)
    public String getStatus() {
        return status;
    }

    //Gets sampleID of the sample
    public int getSampleID() {
        return sampleID;
    }

    //Gets the type of testing this sample is
    public String getTestType() {
        return testType;
    }

    //Gets the company of the Client
    public String getCompany() {
        return company;
    }

    //Gets the fidelity of the sample size that was recorded by the Analysis
    public double getFidelity() {
        return fidelity;
    }

    //Gets the expected fidelity requested by the Client
    public double getExpectedFidelity() {
        return expectedFidelity;
    }

    //Gets the Due Date of the sample (requested by the Client)
    public String getDueDate() {
        return dueDate;
    }

    //Gets the Date when the sample was sent by the Client
    public String getSentDate() {
        return sentDate;
    }

    //Gets the date when the laboratory received the sample
    public String getReceivedDate() {
        return receivedDate;
    }

    //Gets the completion date of the sample
    public String getCompletedDate() {
        return completedDate;
    }
    
    
    
}
