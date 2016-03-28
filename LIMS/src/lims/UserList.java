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
    private Hashtable <String, String> list = new Hashtable<String, String>();
    
       public UserList(String username, String password){
           
       }
    
}