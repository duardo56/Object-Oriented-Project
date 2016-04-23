/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lims;

import java.util.ArrayList;

/**
 *
 * @author reticent
 */
public class LIMSClient extends Client {
    
    //Login
    //Communicates back and forth with server to get ACK for token
    public boolean login(String username, String password){
        
        try {
           
             //Local Varibles
            Message sendM = null;    //Holds message sent to server
            Message receiveM = null; //Receives the response from the server
            
            //Reads, sends, and receives the message
            sendM =  new Message("login");
            sendM.addObject(username);   //adds username
            sendM.addObject(password);   //adds password
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
    
    
    
}
