/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lims;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author reticent
 */
public class LIMSClient extends Client {
    
    //Communicates back and forth with server to get ACK for Login
    public User login(String username, String password){
        
        try {
           
             //Local Varibles
            Message sendM = null;    //Holds message sent to server
            Message receiveM = null; //Receives the response from the server
            User temp = null;
            
            //Reads, sends, and receives the message
            sendM =  new Message("login");
            sendM.addObject(username);   //adds username
            sendM.addObject(password);   //adds password
            output.writeObject(sendM);   //writes to the server
            receiveM = (Message)input.readObject();  //receives from the server
            
            //Successful Response from server
            if (receiveM.getMessage().equals("OK"))
            {
                ArrayList<Object> list = null;
                list = receiveM.getObjCont();
               
                temp = (User)list.get(0);
                
             return temp;   
            }
            return null;
        }
        catch (Exception e){
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace(System.err);
            return null;
        }
    }
    
    //Create new user
    public boolean createNewUser (String username, String password, String firstName, String lastName, long phoneNumber, String status){
        
        try {
           
            //Local Varibles
            Message sendM = null;    //Holds message sent to server
            Message receiveM = null; //Receives the response from the server
            
            //Reads, sends, and receives the message
            sendM =  new Message("createNewUser");
            sendM.addObject(username);   //adds username
            sendM.addObject(password);   //adds password
            sendM.addObject(firstName);  //adds first name
            sendM.addObject(lastName);   //adds last name
            sendM.addObject(phoneNumber); //adds phone number
            sendM.addObject(status);    //adds the status
            output.writeObject(sendM);   //writes to the server
            receiveM = (Message)input.readObject();  //receives from the server
            
            //Successful Response from server
            if (receiveM.getMessage().equals("OK"))
            {
             return true;   
            }
            return false;
        }
        catch (Exception e){
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace(System.err);
            return false;
        }
    }
    
    public ArrayList<Object> getFilesForManagement(){
        
        ArrayList<Object> list = null;
        
        try {
           
             //Local Varibles
            Message sendM = null;    //Holds message sent to server
            Message receiveM = null; //Receives the response from the server
            
            //Reads, sends, and receives the message
            sendM =  new Message("getFilesForManagement");
            output.writeObject(sendM);   //writes to the server
            receiveM = (Message)input.readObject();  //receives from the server
            
            //Successful Response from server
            if (receiveM.getMessage().equals("OK"))
            {
                ArrayList<Object> temp = receiveM.getObjCont();
                
                return temp;   
            }
            return null;
        }
        catch (Exception e){
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace(System.err);
            return null;
        }
    }
    
    public boolean mgntAccept(ArrayList<String> status, ArrayList<Integer> sampleID, ArrayList<Integer> analysistID){
        
        try{
        //Local Varibles
        Message sendM = null;    //Holds message sent to server
        Message receiveM = null; //Receives the response from the server
            
        //Reads, sends, and receives the message
        sendM =  new Message("mgntAccept");
        sendM.addObject(status);
        sendM.addObject(sampleID);
        sendM.addObject(analysistID);
        
        output.writeObject(sendM);
        receiveM = (Message)input.readObject();
        
         //Successful Response from server
            if (receiveM.getMessage().equals("OK"))
            {
             return true;   
            }
            return false;
        }
        catch (Exception e){
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace(System.err);
            return false;
        }
    }

    public ArrayList <SampleFile> retriveAnalysisFiles(int id)
    {
        try{
            ArrayList <SampleFile> list = null; 
      
            Message sendM = null;    //Holds message sent to server
            Message receiveM = null; //Receives the response from the server
      
            sendM = new Message("retriveAnalysisFiles");
            sendM.addObject(id);
      
            output.writeObject(sendM);
            receiveM = (Message)input.readObject();
        
            if(receiveM.getMessage().equals("OK"))
            {
                return (ArrayList <SampleFile>) receiveM.getObjCont().get(0); 
            }
        }
        catch (Exception e){
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace(System.err);
            return null;
        }
      return null;   
    } 
    
    public ArrayList<Object> getFilesForClient(){
        
        ArrayList<Object> list = null;
        
        try {
           
             //Local Varibles
            Message sendM = null;    //Holds message sent to server
            Message receiveM = null; //Receives the response from the server
            
            //Reads, sends, and receives the message
            sendM =  new Message("getFilesForClient");
            output.writeObject(sendM);   //writes to the server
            receiveM = (Message)input.readObject();  //receives from the server
            
            //Successful Response from server
            if (receiveM.getMessage().equals("OK"))
            {
                ArrayList<Object> temp = receiveM.getObjCont();
                
                return temp;   
            }
            return null;
        }
        catch (Exception e){
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace(System.err);
            return null;
        }
    }
    
}
