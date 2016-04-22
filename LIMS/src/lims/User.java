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
    private String phoneNumber; //Stores user's phone number
    private int userID;   //User's unique ID
    
    //Constructor w/ 3 parameters (String, String)
    public User(String username, String password, int userID){
        this.username = username;
        this.password = password;
        this.userID = userID;
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
    
    //Get Phone Number
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    public int getUserID(){
        return this.userID;
    }
    
    //Set Phone Number
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
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
    

