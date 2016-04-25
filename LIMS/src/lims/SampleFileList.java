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
    
    //Declared Member Variables
    private Hashtable<String,ArrayList<SampleFile>> list = new Hashtable<>();  //Stores username (as String) w/ corresponding file
    private ArrayList<Integer> IDList = new ArrayList<Integer>();   //Stores ID's already used in system (Implemented to keep track of ID's)
    
    //Default constructor (dummy)
    public SampleFileList(){}
    
    //Creates new SampleFile object for user
    public void addFile(String username, String testType, String company, double expectedFidelity,String dueDate, String sentDate){
        
        ArrayList<SampleFile> t = new ArrayList<SampleFile>();  
        SampleFile temp = new SampleFile(testType,createID(),company, expectedFidelity,dueDate,sentDate);
        
        t.add(temp);
        
        //if user does not exist in hashtable
        if (!checkUser(username.toLowerCase()))
            list.put(username.toLowerCase(), t); //Adds new user w/ SampleFile into the hashtable
        else
            list.get(username.toLowerCase()).add(temp);   //Adds file to exisitng user into the hashtable
    }
    
    //Creates new SampleFile object for user
    public void addFile(String username, String testType, String company, double expectedFidelity,String dueDate, String sentDate, int userID){
        
        ArrayList<SampleFile> t = new ArrayList<SampleFile>();  
        SampleFile temp = new SampleFile(testType,createID(),company, expectedFidelity,dueDate,sentDate, userID);
        
        t.add(temp);
        
        //if user does not exist in hashtable
        if (!checkUser(username.toLowerCase()))
            list.put(username.toLowerCase(), t); //Adds new user w/ SampleFile into the hashtable
        else
            list.get(username.toLowerCase()).add(temp);   //Adds file to exisitng user into the hashtable
    }
    
    //Check if user exist within SimpleFileList Hashtable
    public boolean checkUser(String username){
        
        if(list.containsKey(username.toLowerCase()))
            return true;
        else  
            return false;
    }
    
    //Get SampleFile (returns an arrayList of all SimpleFiles for all users)
    public ArrayList getAllSampleFiles(){
        
        //Instanced Varibles
        ArrayList<SampleFile> arr = new ArrayList<SampleFile>();
        Enumeration uc = list.keys();
        String temp;    //Holds username
        
        while(uc.hasMoreElements()){
            
            temp = (String) uc.nextElement();   //Stores username
            
            for (int x =0 ; x < list.get(temp).size(); x++)
                arr.add(list.get(temp).get(x)); //Adds SampleFiles' object to arr
        }
        return arr;
    }
    
    //Gets User's SampleFiles (All of them)
    public ArrayList getAllUsersSampleFiles(String username){
        
        //Instanced Varibles
        ArrayList<SampleFile> arr = new ArrayList<SampleFile>();
        Enumeration uc = list.keys();
        String temp;    //Holds username from hashtable
        
        while(uc.hasMoreElements()){
            
            temp = (String) uc.nextElement();   //Stores username
            
            if (temp.equalsIgnoreCase(username)){
                for (int x =0 ; x < list.get(temp).size(); x++){
                    //System.out.println("testing...");
                    arr.add(list.get(temp).get(x));
                }
                break;
            }
        }
        return arr;
    }
    
    //Gets Specific SampleFile Object of User
    public SampleFile getUserSpecificSampleFile(int id){
        
        //Instanced Varibles
        SampleFile file = null;  //Holds SampleFile obj
        Enumeration uc = list.keys();
        String temp;    //Holds username from hashtable
        
        while(uc.hasMoreElements()){
            
            temp = (String) uc.nextElement();   //Stores username

                for (int x =0 ; x < list.get(temp).size(); x++){
                    if (list.get(temp).get(x).getSampleID() == id){
                        file = list.get(temp).get(x);
                        break;
                    }
                }
        }
        return file;
    }
    
    //Get SampleFile (returns an arrayList of all SimpleFiles for all users)
    public ArrayList getFilesAssignedToAnalysis(int id){
        
        //Instanced Varibles
        ArrayList<SampleFile> arr = new ArrayList<SampleFile>();
        Enumeration uc = list.keys();
        String temp;    //Holds username
        
        while(uc.hasMoreElements()){
            
            temp = (String) uc.nextElement();   //Stores username
            
            for (int x =0 ; x < list.get(temp).size(); x++){
                if(list.get(temp).get(x).getAnalysisID() == id){
                    arr.add(list.get(temp).get(x)); //Adds SampleFiles' object to arr
                }
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
