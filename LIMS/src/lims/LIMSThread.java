/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lims;

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
                Message sent = (Message)input.readObject();
                Message response;
                System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "] " + sent.getMessage());
                
                //login
                
                //
                
            }while(loop);
    
        }
        catch(Exception e){
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace(System.err);
        } 
    }
}
