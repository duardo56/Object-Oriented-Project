/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lims;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author reticent
 */
public class LIMS {

    
    public static UserList userL;
    
    public  void main(String[] args)  {
        
        
                String tempUser;
                String tempPass;
                String userFile = "UserList.bin";
		Scanner console = new Scanner(java.lang.System.in);
		ObjectInputStream userStream;
		
		//Open user file to get user list
		try
		{
			FileInputStream fis = new FileInputStream(userFile);
			userStream = new ObjectInputStream(fis);
			userL = (UserList)userStream.readObject();
		}
		catch(FileNotFoundException e)
		{
			java.lang.System.out.println("UserList File Does Not Exist. Creating UserList...");
			java.lang.System.out.println("No users currently exist. Your account will be the administrator.");
			java.lang.System.out.print("Enter your username and password: ");
			String username = console.next();
                        String password = console.next();
                        
			
			//Create a new list, add current user to the ADMIN group. They now own the ADMIN group.
			userL = new UserList(username, password);
		}
		catch(IOException e)
		{
			java.lang.System.out.println("Error reading from UserList file");
			java.lang.System.exit(-1);
		}
		catch(ClassNotFoundException e)
		{
			java.lang.System.out.println("Error reading from UserList file");
			java.lang.System.exit(-1);
		}
        LoginMenu gui = new LoginMenu();
        gui.setVisible(true);
    }
    
}
