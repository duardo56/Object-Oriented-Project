/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lims;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author reticent
 */
public class LIMS {
    
    public static void main(String[] args) throws IOException  {
        
        //************************************************************
        /*
            Testing: User class and System Class
        */
        
        User user = new User();
        user.setPassword("Password");
        user.setUsername("User");
        
        File file = new File("testFile");
        OutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutput outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(user);
        
        System.out.println("I've stored the User object into the file: " + file.getName());
        
        //***********************************************************
        //LoginMenu gui = new LoginMenu();    //Creates LoginMenu Gui
        //gui.setVisible(true);   //Sets visibility of gui to true
    }
    
}
