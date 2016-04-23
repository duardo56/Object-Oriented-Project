/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lims;

import java.io.Serializable;

/**
 *
 * @author reticent
 */
public class ManagementUser extends User implements Serializable{
   
    //Defualt Constructor (Soon to be removed!!!!!!!!)
    public ManagementUser(String username, String password, String firstName, String lastName, int uniqueID){
        super(username, password, uniqueID);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }
    
    //Defualt Constructor
    public ManagementUser(String username, String password, String firstName, String lastName, int uniqueID, long phoneNumber){
        super(username, password, uniqueID);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPhoneNumber(phoneNumber);
    }
    
}
