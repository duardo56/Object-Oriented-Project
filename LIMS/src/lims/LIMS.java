/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lims;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 *
 * @author reticent
 */
public class LIMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        
        LoginMenu gui = new LoginMenu();
        gui.setVisible(true);
    }
    
}
