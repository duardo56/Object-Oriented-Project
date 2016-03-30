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
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String username;    //Stores user's username
    private String password;    //Stores user's password (Needs to encrypt password)
    private String firstName;   //Stores user's first name
    private String lastName;    //Stores user's last name
    
    //Constructor w/ 2 parameters (String, String)
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    //Get Username 
    public String getUsername(){
        return username;
    }
    
    //Get Password
    public String getPassword(){
        return password;
    }
    
    //Get First name
    public String getFirstName(){
        return firstName;
    }
    
    //Get Last name
    public String getLastName(){
        return lastName;
    }
    
    //Set Username
    public void setUsername(String username){
        this.username = username;
    }
    
    //Set Password
    public void setPassword(String password){
        this.password = password;
    }
    
    //Set Firstname
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    //Set Lastname
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
}
    

