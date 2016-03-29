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
public class AnalysisUser extends User {
    
    //Defualt Constructor
    public AnalysisUser(String username, String password, String firstName, String lastName){
        super(username, password);
        this.setFirstName(username);
        this.setLastName(lastName);
    }
    
}
