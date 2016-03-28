package lims;


/*
    Currently testing this as a way to save Usernames and Passwords
    as a binary file using hashtable and serialization. Also, trying
    to implement someway to distinguish between Management, Analysis,
    and Client. Still work in progress.
*/

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class UserList implements java.io.Serializable {
    
    private static final long SERIAL_VERSION_UID = 1L;
    private Hashtable<String,User> list = new Hashtable<String, User>();
    
    public void addUser(String username){
        
        User newUser = new User();
        list.put(username, newUser);
    }
    
    public void deleteUser(String username){
        
        list.remove(username);
    }
    
    public boolean checkUser(String username){
        
        if(list.containsKey(username))
            return true;
        else  
            return false;
    }
    
    public Enumeration<String> getUsernames(){
        
        return list.keys();
    }
    
    public ArrayList<String> getUserGroups(String username){
        
        return list.get(username).getGroups();
    }
    
    public ArrayList<String> getUserOwnerships(String username){
        
        return list.get(username).getOwnership();
    }
    
    public void addGroup(String user, String groupname){
        list.get(user).addGroup(groupname);
    }
    
    public void removeGroup(String user, String groupname){
        list.get(user).removeGroup(groupname);
    }
    
    public void removeOwnerships(String user, String groupname){
        list.get(user).removeOwnership(groupname);
    }
    
    public void addOwnerships(String user, String groupname){
        list.get(user).addOwnerships(groupname);
    }
    
}

class User implements java.io.Serializable{
    
    private static final long serialVersionUID = 1L;
    private ArrayList<String> groups;
    private ArrayList<String> ownerships;
    
    public User(){
        
        groups = new ArrayList<String>();
        ownerships = new ArrayList<String>();
    }
    
    public ArrayList<String> getGroups(){
        return groups;
    }
    
    public ArrayList<String> getOwnership(){
        return ownerships;
    }
    
    public void addGroup(String group){
        groups.add(group);
    }
    
    public void removeGroup(String group){
        if(!groups.isEmpty()){
            if(groups.contains(group)){
                groups.remove(group.indexOf(group));
            }
        }
    }
    
    public void addOwnerships(String group){
        ownerships.add(group);
    }
    
    public void removeOwnership(String group){
        
        if(!ownerships.isEmpty())
            if(ownerships.contains(group))
                ownerships.remove(ownerships.indexOf(group));
    }
}
