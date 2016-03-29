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
    
    public UserList(String username, String password, String firstName, String lastName, String status){
        checkStatus(username, password, firstName, lastName, status);
    }
    
    private boolean checkStatus(String username, String password, String firstName, String lastName, String status){
        
        if (status.equals("Management")){
            User test = new ManagementUser(username, password,firstName, lastName);
            list.put(username, test);
            return true;
        }
        else if(status.equals("Analysis")){
            User test = new AnalysisUser(username, password,firstName, lastName);
            list.put(username, test);
            return true;
        }
        
        else if (status.equals("Client")){
            User test = new ClientUser(username, password,firstName, lastName);
            list.put(username, test);
            return true;
        }
        
        else if (status == null){
            
            return false;
        }
        
        return false;
    }
    
}
