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
public class SampleFileList implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Hashtable<String,ArrayList<SampleFile>> list = new Hashtable<>();  //Stores username (as String) w/ corresponding file
    private ArrayList<Integer> IDList = new ArrayList<Integer>();   //Stores ID's already used in system (Implemented to keep track of ID's)
    
    //Default constructor (dummy)
    public SampleFileList(){}
    
    //Create new file
    //TODO: Needs fixing. Need to ensure that i don't overwrite the hastable by ensuring it checks for User and just adds to the list
    public void addFile(String username, String testType, String company, double expectedFidelity,String dueDate, String sentDate){
        
        ArrayList<SampleFile> t = new ArrayList<SampleFile>();  
        SampleFile temp = new SampleFile(testType,createID(),company, expectedFidelity,dueDate,sentDate);
        
        t.add(temp);
        
        //if user does not exist in hashtable
        if (!checkUser(username))
            list.put(username , t); //Adds user w/ file in the hashtable
        else
            list.get(username).add(temp);   //Adds file to exisitng user in the hashtable
        
        t.clear();
    }
    
    //Check if user exist
    public boolean checkUser(String username){
        
        if(list.containsKey(username.toLowerCase()))
            return true;
        else  
            return false;
    }
    
    //Get SampleFile
    //TODO: Finish implementing algorithm to list all files from all Clients
    public ArrayList getSampleFileList(){
        ArrayList<SampleFile> arr = new ArrayList<SampleFile>();
        Enumeration uc = list.keys();
        String temp;
        
        while(uc.hasMoreElements()){
            
            temp = (String) uc.nextElement();   //Stores username
            
            for (int x =0 ; x < list.get(temp).size(); x++)
                arr.add(list.get(temp).get(x));
        }
        
        return arr;
    }
    
    //Gets User's SampleFiles
    //private 
    
    //Creates new ID for current Sample
    private int createID(){
        
        //Instanced Variables
        int temp = 0;   //Holds randomized ID Number (9-Digits Long)
        Random rand = new Random();
        
        do{
            temp = rand.nextInt(1000000000);    //Creates a random # b/w 0-999999999
            
        }while(checkSampleID(temp));
        
        return temp;
    }
    
    //Checks if there current ID is being used by another sample
    private boolean checkSampleID(int n){
        //Checks if current number n exist within list.
        return IDList.equals(n);
    }
}
