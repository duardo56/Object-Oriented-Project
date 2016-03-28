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
public class System implements Serializable {
    
    
    private Hashtable<User, String> list = new Hashtable<User, String>();
    
    public System(String username, String password, String status){
        User newUser = new User(username,password);
        list.put(newUser, status);
    }
}
