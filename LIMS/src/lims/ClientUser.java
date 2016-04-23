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
public class ClientUser extends User implements Serializable{
    
    //Declared Member Variables
    private String companyName; //Holds client user's company name
    
    //Defualt Constructor
    public ClientUser(String username, String password, String firstName, String lastName, int uniqueID){
        super(username, password, uniqueID);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
