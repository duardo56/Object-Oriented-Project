/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lims;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author reticent
 */
public class LIMS {
    
    public static void main(String[] args) throws IOException  {
        
        ///***********************************************************
        /*
            Testing: UserList class save and retrieval functions
        *///**********************************************************
        try{
            //UserList Hashtable test
            UserList list = new UserList();
            list.addUser("TestUserList","password","Carlos","Rios","Management");
            list.addUser("Number2","testPass2","testName2","testLast2","Analysis");
            list.addUser("Number3","testPass3","testName3","testLast3","Client");
            
            //Saves UserList.bin
            File file = new File("UserListTest");
            OutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutput outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(list);
            
            System.out.println("I've stored the UserList object into the file: " + file.getName());
            
            //Retrieves and displays UserList.bin
            FileInputStream fInput = new FileInputStream("UserListTest");
            ObjectInputStream ois = new ObjectInputStream(fInput);
            UserList testing = (UserList)ois.readObject();
            
           System.out.println(testing.getUser("TestUserList").getPassword());
            
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        //Don't forget to uncomment
        //***********************************************************
        //LoginMenu gui = new LoginMenu();    //Creates LoginMenu Gui
        //gui.setVisible(true);   //Sets visibility of gui to true
    }
    
}
