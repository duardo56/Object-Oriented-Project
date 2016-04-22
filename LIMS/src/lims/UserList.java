/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lims;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;

/**
 *
 * @author reticent
 */
public class UserList implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Hashtable<String, User> list = new Hashtable<String, User>();
    private ArrayList<Integer> IDList = new ArrayList<Integer>();   //Stores ID's already used in system (Implemented to keep track of ID's)
    
    //Default Constructor
    public UserList(){}
    
    //Adds user according to the status/type of user
    public void addUser(String username, String password, String firstName, String lastName, String status){
        if (status.equals("Management")){
            User user = new ManagementUser(username.toLowerCase(), password,firstName, lastName,createID());
            list.put(username.toLowerCase(), user);
        }
        else if(status.equals("Analysis")){
            User user = new AnalysisUser(username.toLowerCase(), password,firstName, lastName, createID());
            list.put(username.toLowerCase(), user);
        }
        
        else if (status.equals("Client")){
            User user = new ClientUser(username.toLowerCase(), password,firstName, lastName, createID());
            list.put(username.toLowerCase(), user);
        }
    }
    
    //Check if user exist
    public boolean checkUser(String username){
        
        if(list.containsKey(username.toLowerCase()))
            return true;
        else  
            return false;
    }
    
    //Gets the User Object
    public User getUser(String username){
        return (User)list.get(username.toLowerCase());
    }
    
    //Gets the class of the User
    public String getUserClass (String username){
        return getUser(username).getClass().getSimpleName();
    }
    
    //Method returns an ArrayList of users of a certain type (Management, Analysis, or Client)
    public ArrayList getUsersWithCertainClass(String typeOfUser){
        ArrayList<String> arr= new ArrayList<String>();
        Enumeration uc = list.keys();
        String temp;
        
        while(uc.hasMoreElements()){
            
            temp = (String) uc.nextElement();   //Stores username
            
            if (this.getUserClass(temp).equals(typeOfUser)){
                arr.add(temp);
            }
        }
        
        return arr;
    }
    //Creates new ID for current Sample
    private int createID(){
        
        //Instanced Variables
        int temp = 0;   //Holds randomized ID Number (9-Digits Long)
        Random rand = new Random();
        
        do{
            temp = rand.nextInt(1000000000);    //Creates a random # b/w 0-999999999 (9-digits)
            
        }while(checkSampleID(temp));    //Checks if sampleID has been taken
        
        return temp;
    }
    
    //Checks if there current ID is being used by another sample
    private boolean checkSampleID(int n){
        //Checks if current number n exist within list.
        return IDList.contains(n);
    }
}
