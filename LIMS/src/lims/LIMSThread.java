/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lims;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author reticent
 */
public class LIMSThread extends Thread{
    private final Socket socket; //The socket where the communication will be held
    private final LIMSServer gs;    //Groupserver Object 
    
    public LIMSThread(Socket socket, LIMSServer name){
        this.socket = socket;
        this.gs = name;
    }
    
    @Override
    public void run(){
        
        try{
            // Print incoming message
            System.out.println("** New connection from " + socket.getInetAddress() + ":" + socket.getPort() + " **");

            // set up I/O streams with the client
            final ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            final ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            
            boolean loop = true;    //Used for the disconnect
            
            do{
                //read and print message
                Message received = (Message)input.readObject();
                Message response;
                System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "] " + received.getMessage());
                
                ///*********************************************************************************************************
                //Login
                if (received.getMessage().equals("login")){
                    
                    String username = (String)received.getObjCont().get(0);
                    String password = (String)received.getObjCont().get(1);
                    
                    //if there is no username
                    if (username == null){
                        response = new Message("FAIL");
                        response.addObject(null);
                        output.writeObject(response);
                    }
                    else{
                        //TODO: Maybe Implement adding the corresponding sample list 
                        //      and/or appropriate User Class ahead of time
                        if( login(username, password)){
                            response = new Message("OK");
                            response.addObject(gs.userL.getUser(username));
                            output.writeObject(response);
                        }
                        else{
                            response = new Message("FAIL");
                            output.writeObject(response);
                        }    
                    }
                }
                //****************************************************************************************
                //Create New User
                else if(received.getMessage().equals("createNewUser")){
                    
                    String username = (String)received.getObjCont().get(0);
                    String password = (String)received.getObjCont().get(1);
                    String firstName = (String)received.getObjCont().get(2);
                    String lastName = (String)received.getObjCont().get(3);
                    long phoneNumber = (long)received.getObjCont().get(4);
                    String status = (String)received.getObjCont().get(5);
                    
                    //Checks if there if username is taken
                    if (gs.userL.checkUser(username)){
                        response = new Message("FAIL");
                        response.addObject(null);
                        output.writeObject(response);
                    }
                    //Else username is not taken
                    else{
                        gs.userL.addUser(username, password, firstName, lastName, phoneNumber, status);
                        
                        //Saves UserList.bin
                        ObjectOutputStream obj_out = new ObjectOutputStream (new FileOutputStream("UserListTest"));
                        obj_out.writeObject (gs.userL);
                        
                        response = new Message("OK");
                        response.addObject(null);
                        output.writeObject(response);   
                    }
                }
                
            }while(loop);
        }
        catch(Exception e){
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace(System.err);
        } 
    }
    
    //Login Method
    public boolean login(String username, String password){
        
        //Checks if username exist
        if (gs.userL.checkUser(username)){
            
            String stored_password = gs.userL.getUser(username).getPassword();
            
            if (stored_password.equals(password)){
                return true;
            }   
        }
        return false;
    }
}
