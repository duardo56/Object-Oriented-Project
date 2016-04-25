/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lims;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 *
 * @author reticent
 */
public class LIMS {
    
    public static void main(String[] args) throws IOException  {
        
        ///***********************************************************
        //
        //    Testing: UserList class save and retrieval
        //
        ///***********************************************************
        
//        try{
//            //UserList Hashtable test
//            UserList list = new UserList();
//            list.addUser("Number1","testPass1","testName1","testName1","Management");
//            list.addUser("Number2","testPass2","testName2","testLast2","Analysis");
//            list.addUser("Number3","testPass3","testName3","testLast3","Client");
//            
//            //Saves UserList.bin
//            File file = new File("UserListTest");
//            OutputStream fileOutputStream = new FileOutputStream(file);
//            ObjectOutput outputStream = new ObjectOutputStream(fileOutputStream);
//            outputStream.writeObject(list);
//            
//            System.out.println("I've stored the UserList object into the file: " + file.getName());
//            
//            //Retrieves and displays UserList.bin
//            FileInputStream fInput = new FileInputStream("UserListTest");
//            ObjectInputStream ois = new ObjectInputStream(fInput);
//            UserList testing = (UserList)ois.readObject();
//            
//           System.out.println(testing.getUser("Number1").getPassword());
//           
//           ArrayList<String> arr = new ArrayList<String> (testing.getUsersWithCertainClass("AnalysisUser"));
//           System.out.println(arr.get(0));
//            
//        }
//        catch (FileNotFoundException e){
//            e.printStackTrace();
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//        catch(ClassNotFoundException e){
//            e.printStackTrace();
//        }
//        
//            try{
//                //Create SampleFileList for test purpose
//                SampleFileList test = new SampleFileList();
//                test.addFile("Number1", "Gas", "TestComp", 68.0, "12/12/2012", "10/10/2010");
//                test.addFile("Number1", "Solid", "TestSolidComp", 68.0, "09/06/2012", "06/12/2010");
//                test.addFile("Number2", "Solid", "TestComp2", 50.0, "10/02/2014", "7/06/2000");
//                test.addFile("Number3", "Liquid", "DifferentComp", 99.0, "03/02/2020", "10/10/2010");
//                
//                //Saves SampleFileList.bin
//                File file = new File("SampleFileList");
//                OutputStream fileOutputStream = new FileOutputStream(file);
//                ObjectOutput outputStream = new ObjectOutputStream(fileOutputStream);
//                outputStream.writeObject(test);
//                
//                System.out.println("I've stored the SampleFileList object into the file: " + file.getName());
//            }
//            catch (FileNotFoundException e){
//                e.printStackTrace();
//            }
//            catch (IOException e){
//                e.printStackTrace();
//            }
//            
        //****************************************************************
        //*********************End of Testing****************************

         

        
        LIMSClient lc = new LIMSClient();
        lc.connect("localhost", 8765);
        
        //MainMenu GUI = new MainMenu();
        
        LoginMenu GUI = new LoginMenu("localhost", 8765);
        GUI.setVisible(true);
    }
    
}
