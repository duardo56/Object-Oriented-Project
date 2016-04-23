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
    
    
    
}
