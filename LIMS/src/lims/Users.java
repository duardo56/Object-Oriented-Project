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
public class Users implements Serializable{
    
    private String firstName;
    private String lastName;
    private long id;
    private String company;
    
    //Users Constructor w/ 4 parameters
    public Users(String firstName, String lastName , long id, String company){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.company = company;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCompanies(String companies) {
        this.company = companies;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getId() {
        return id;
    }

    public String getCompanies() {
        return company;
    }
    
    @Override
    public String toString(){
        return "First Name: " + firstName + "\nLast Name: " + lastName +
                "\nID: " + id +"\nCompany Name: " + company;
    }
    
    
    
    
}
