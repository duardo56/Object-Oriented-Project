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
import java.util.ArrayList;

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
                
<<<<<<< HEAD
                //******************************************************************************************************
                //Retrieve Clients and Analysist for Management
                else if(received.getMessage().equals("getFilesForManagement")){
                    
                    ArrayList<User> clients = null; //Stores clients
                    ArrayList<User> analysist = null;  //Stores analysist
                    ArrayList<SampleFile> sampleFile = null;    //Samples Files

                    clients = gs.userL.getUsersWithCertainClass("ClientUser");
                    analysist = gs.userL.getUsersWithCertainClass("AnalysisUser");
                    sampleFile = gs.fileL.getAllSampleFiles();
                    
                    response = new Message ("OK");
                    response.addObject(clients);
                    response.addObject(analysist);
                    response.addObject(sampleFile);
                    
                    output.writeObject(response);
                }
                
                else if(received.getMessage().equals("mgntAccept")){
                    
                    //Instanced Variables
                    ArrayList<String> status = (ArrayList<String>)received.getObjCont().get(0);
                    ArrayList<Integer> sampleID = (ArrayList<Integer>)received.getObjCont().get(1);
                    ArrayList<Integer> analysistID = (ArrayList<Integer>)received.getObjCont().get(2);
                    
                    for (int x = 0; x <status.size();x++){
                        gs.fileL.getUserSpecificSampleFile(sampleID.get(x)).setAnalysisID(analysistID.get(x));
                        gs.fileL.getUserSpecificSampleFile(sampleID.get(x)).setStatus(status.get(x));
                    }
                    
                    //Saves UserList.bin 
                    ObjectOutputStream obj_out = new ObjectOutputStream (new FileOutputStream("SampleFileList")); 
                    obj_out.writeObject (gs.fileL);
                    
                    response = new Message("OK");
                    response.addObject(null);
                    
                    output.writeObject(response);
                    
                    output.reset();
=======
                else if (received.getMessage().equals("retriveAnalysisFiles"))
                {
                        int id = (Integer)received.getObjCont().get(0);
                        
                        ArrayList <SampleFile> list_ana =  gs.fileL.getFilesAssignedToAnalysis(id);
                        
                        response = new Message("OK");
                        response.addObject(list_ana);
                        output.writeObject(response);
                        output.reset(); 
>>>>>>> master
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
