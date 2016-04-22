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
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author reticent
 */
public class AnalysisMenu extends javax.swing.JFrame {

    /**
     * Creates new form AnalysisMenu
     */
    public AnalysisMenu(){
        
        //Initializes GUI
        initComponents();
        
        username = "Number2";
        
        //Reads UserListTest and SampleFileList file 
        //and store into UserList list object and SampleFileList object
        try{
            FileInputStream fInput = new FileInputStream("UserListTest");
            ObjectInputStream ois = new ObjectInputStream(fInput);
            list = (UserList)ois.readObject();
            
             userID = list.getUser(username).getUserID();    //Gets userID
            
            fInput = new FileInputStream("SampleFileList");
            ois = new ObjectInputStream(fInput);
            sampleList =  (SampleFileList)ois.readObject();
            
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        fillSampleTable(); //call method here 
    }
    
    //Constructor
    public AnalysisMenu(String username){
        
        //Initializes GUI
        initComponents();
        
        this.username = username;
        
        //Reads UserListTest and SampleFileList file 
        //and store into UserList list object and SampleFileList object
        try{
            FileInputStream fInput = new FileInputStream("UserListTest");
            ObjectInputStream ois = new ObjectInputStream(fInput);
            list = (UserList)ois.readObject();
            
            userID = list.getUser(username).getUserID();    //Gets userID
            
            fInput = new FileInputStream("SampleFileList");
            ois = new ObjectInputStream(fInput);
            sampleList =  (SampleFileList)ois.readObject();
            
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        fillSampleTable(); //call method here 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SampleView = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAnalystSample = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemLogout = new javax.swing.JMenuItem();
        jMenuItemExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(640, 400));

        SampleView.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1022, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );

        SampleView.addTab("Analysis", jPanel2);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel6.setText("Current List of Samples");

        tblAnalystSample.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sample ID", "Status", "Test Type", "Expected Fieleity", "Due Date ", "Sent Date ", "Recieved Date", "Completed Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblAnalystSample);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 996, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 43, Short.MAX_VALUE))
        );

        SampleView.addTab("View Sample", jPanel1);

        jMenu1.setText("Menu");

        jMenuItemLogout.setText("Logout");
        jMenuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogoutActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemLogout);

        jMenuItemExit.setText("Exit");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemExit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SampleView, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SampleView)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Closes current AnalysisMenu window and opens LoginMenu
    private void jMenuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogoutActionPerformed
        this.dispose();
        LoginMenu window = new LoginMenu();
        window.setVisible(true);
    }//GEN-LAST:event_jMenuItemLogoutActionPerformed

    //Closes the program when exit from Menu is clicked
    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    //Populate the Jlist with Samples
    private void fillSampleTable (){
        DefaultTableModel tbl = (DefaultTableModel) tblAnalystSample.getModel();
        
        tbl.setRowCount(0); //Set model row count = 0
        
        ArrayList  <SampleFile> fileList = sampleList.getFilesAssignedToAnalysis(userID); 
        
        for (int i = tblAnalystSample.getRowCount(); i < fileList.size(); i++) {
                int ID = fileList.get(i).getSampleID(); 
                String getStatus = fileList.get(i).getStatus();
                String testType = fileList.get(i).getTestType();
                double expFidelity = fileList.get(i).getExpectedFidelity();
                String dueDate = fileList.get(i).getDueDate();
                String sentDate = fileList.get(i).getSentDate();
                String recievedDate = fileList.get(i).getReceivedDate();
                String compDate = fileList.get(i).getCompletedDate();
                
                Object [] arr = {ID, getStatus, testType, expFidelity, dueDate, sentDate, recievedDate, compDate}; 
                tbl.addRow(arr);
            
                        //set the combobox on the 2nd coloumn 
   //     JComboBox comboBox = new JComboBox();
     //   TableColumn  sampleColoumn = tblAnalystSample.getColumnModel().getColumn(1);
     //   sampleColoumn.setCellEditor(new DefaultCellEditor(comboBox));
                
                
        }
        tblAnalystSample.setModel(tbl);
    }
    
    //Declared variable
    private UserList list;  //Holds UserList object
    private int userID;
    private DefaultListModel listModel;
    private SampleFileList sampleList; //Holds SampleFileList
    private String username;
    private SampleFile samplefiles;
    private User clientInfo; 
    private ClientUser userClient;
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane SampleView;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemLogout;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblAnalystSample;
    // End of variables declaration//GEN-END:variables
}
