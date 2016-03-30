/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lims;

import java.io.Serializable;
import java.util.Hashtable;

/**
 *
 * @author reticent
 */
public class UserList implements Serializable {
    
    
    private Hashtable<String, User> list = new Hashtable<String, User>();
    
    public UserList(){
        
    }
    
    //Adds user
    public synchronized void addUser(String username, String password, String firstName, String lastName, String status){
        if (status.equals("Management")){
            User test = new ManagementUser(username, password,firstName, lastName);
            list.put(username, test);
        }
        else if(status.equals("Analysis")){
            User test = new AnalysisUser(username, password,firstName, lastName);
            list.put(username, test);
        }
        
        else if (status.equals("Client")){
            User test = new ClientUser(username, password,firstName, lastName);
            list.put(username, test);
        }
    }
    
    //Check if user exist
    public synchronized boolean checkUser(String username){
        
        if(list.containsKey(username))
            return true;
        else  
            return false;
    }
    
    //Gets the User Object
    public User getUser(String username){
        return (User)list.get(username);
    }
    
}
