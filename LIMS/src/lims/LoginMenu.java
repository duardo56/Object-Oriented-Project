/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lims;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

/**
 *
 * @author reticent
 */
public class LoginMenu extends javax.swing.JFrame {

    /**
     * Creates new form LoginMenu
     */
    
    public LoginMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LIMS System Log In");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Login"));

        jLabel1.setText("Username:");

        txtUsername.setPreferredSize(new java.awt.Dimension(10, 37));

        jLabel2.setText("Password: ");

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Create User");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(txtPassword)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Login to the LIMS system
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        //Local Variables
        String user = txtUsername.getText().toLowerCase();    //Holds typed username
        char [] input = txtPassword.getPassword();  //Holds typed password
        char [] password;   //Holds password from UserListTest
        String gui; //Holds String for what kind of gui to open (Analysis, management, or client)
        
        boolean login = false;  //Login if True, else display error in username/password
        
        //Tries to read the UserListTest.bin file
        try{
            //Retrieves UserList.bin 
            FileInputStream fInput = new FileInputStream("UserListTest");
            ObjectInputStream ois = new ObjectInputStream(fInput);
            list = (UserList)ois.readObject();
        }
        catch(FileNotFoundException q){
            javax.swing.JOptionPane.showMessageDialog(null,"Can't find a text file");
        } 
        
        catch (IOException ex) {
            javax.swing.JOptionPane.showMessageDialog(null,"Error reading UserList.bin file");
        } 
        
        catch (ClassNotFoundException ex) {
            javax.swing.JOptionPane.showMessageDialog(null,"Error reading UserList.bin file");
        }
        
        //Text Box Username and Password Box Password are not empty
        if (!(txtUsername.getText().equals("") || txtPassword.getPassword().length ==0)){
            
            //Checks if user exist
            if (list.checkUser(user)){

                password = list.getUser(user).getPassword().toCharArray();  //retrieves password

                //If password is equal to current password input
                if(Arrays.equals(input,password)){
                    login = true;

                }
            }
        }

            //If user has incorrect login
            if (!login){ 
                   javax.swing.JOptionPane.showMessageDialog(null, "Wrong username or password.");
                   txtPassword.setText(""); //Clears Password Textfield
                   txtUsername.setText(""); //Clears Username Textfield
            }
            //If user has correct login
            else{
                
                if (list.getUserClass(user).equals("ManagementUser")){
                    ManagementMenu m = new ManagementMenu();    //Creates management menu object
                    m.setVisible(true); //Sets visibility of m to true
                    this.dispose(); //disposes of login menu window
                }
                
                else if ((list.getUserClass(user).equals("AnalysisUser"))){
<<<<<<< HEAD
<<<<<<< HEAD
//                    AnalysisMenuDelete m = new AnalysisMenuDelete();    //Creates Analysis menu object
       //             m.setVisible(true); //Sets visibility of m to true 
=======
=======
>>>>>>> 1a623ebd205b7d993c811a605f9e9568b440f0f1
                    AnalysisMenu m = new AnalysisMenu();    //Creates Analysis menu object
                    m.setVisible(true); //Sets visibility of m to true 
>>>>>>> 1a623ebd205b7d993c811a605f9e9568b440f0f1
                    this.dispose(); //disposes of login menu window
                }
                
                else if((list.getUserClass(user).equals("ClientUser"))){
                    ClientMenu m = new ClientMenu();    //Creates client menu  pbject
                    m.setVisible(true); //Sets visibility of m to true
                    this.dispose(); //disposes of login menu window
                }
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    //Closes the program
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
           MainMenu GUI = new MainMenu();
        GUI.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    //Opens a new window to create a new login
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        LoginCreateUser gui = new LoginCreateUser();
        gui.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    //Declared Variables
    public UserList list;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
