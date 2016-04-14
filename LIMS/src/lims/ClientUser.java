/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lims;

/**
 *
 * @author reticent
 */
public class ClientUser extends User{
    //TODO: Add and implement companyName
    
    //Defualt Constructor
    public ClientUser(String username, String password, String firstName, String lastName){
        super(username, password);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }
}
