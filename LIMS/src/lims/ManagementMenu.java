/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lims;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author reticent
 */
public class ManagementMenu extends javax.swing.JFrame {

    /**
     * Creates new form ManagementMenu
     */
    public ManagementMenu() {
        
        //Initializes GUI
        initComponents();
        
        //Reads UserListTest and SampleFileList file 
        //and store into UserList list object and SampleFileList object
        try{
            FileInputStream fInput = new FileInputStream("UserListTest");
            ObjectInputStream ois = new ObjectInputStream(fInput);
            list = (UserList)ois.readObject();
            
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
        
        //Fills tables with proper information
        fillJTable();
        fillClientList(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        SampleView = new javax.swing.JTabbedPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        btnAcceptChanges = new javax.swing.JButton();
        btnUpdateTable = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblWorkOrder = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listClients = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblFName = new javax.swing.JLabel();
        lblLName = new javax.swing.JLabel();
        lblPNumber = new javax.swing.JLabel();
        lblComp = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listUFiles = new javax.swing.JList<>();
        jLabel16 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("jRadioButtonMenuItem2");

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Management Main Menu");
        setName("ManagementMenu"); // NOI18N
        setResizable(false);

        SampleView.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        btnAcceptChanges.setText("Accept");
        btnAcceptChanges.setToolTipText("Accept Changes in Table");
        btnAcceptChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptChangesActionPerformed(evt);
            }
        });

        btnUpdateTable.setText("Update");
        btnUpdateTable.setToolTipText("Updates table");
        btnUpdateTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTableActionPerformed(evt);
            }
        });

        tblWorkOrder.setAutoCreateRowSorter(true);
        tblWorkOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sample ID", "Analysist", "Status", "Company", "Test Type", "Expected Fidelity", "Due Date", "Sent Date", "Received Date", "Completed Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblWorkOrder.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblWorkOrder.setAutoscrolls(false);
        tblWorkOrder.setColumnSelectionAllowed(true);
        tblWorkOrder.setFocusCycleRoot(true);
        tblWorkOrder.getTableHeader().setResizingAllowed(false);
        tblWorkOrder.getTableHeader().setReorderingAllowed(false);
        tblWorkOrder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblWorkOrderKeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(tblWorkOrder);
        tblWorkOrder.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAcceptChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateTable, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1086, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnAcceptChanges)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdateTable))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jPanel4);

        SampleView.addTab("Manage Work Order", jSplitPane1);

        listClients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listClientsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listClients);

        jLabel5.setText("Current List of Clients");

        jLabel7.setText("First Name");

        jLabel8.setText("Last Name:");

        jLabel10.setText("Phone Number:");

        jLabel11.setText("Company Name:");

        lblFName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblLName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblPNumber.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblComp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jScrollPane4.setViewportView(listUFiles);

        jLabel16.setText("Sample ID ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 414, Short.MAX_VALUE)
                                    .addComponent(lblFName, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(272, 272, 272)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel11))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblComp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblPNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblLName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addGap(520, 520, 520))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblFName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(30, 30, 30)
                                .addComponent(jLabel8))
                            .addComponent(lblLName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(lblPNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(lblComp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        SampleView.addTab("View Clients", jPanel2);

        jMenu1.setText("Menu");

        jMenuItem1.setText("Log Out");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SampleView))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SampleView)
                .addContainerGap())
        );

        SampleView.getAccessibleContext().setAccessibleName("ViewSample");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //*************************************************************
    //Logout from current Session back to login Menu
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        //Saves Files
        saveSampleFile();
        
        //Disposes GUI then returns back to login menu
        this.dispose();
        LoginMenu m = new LoginMenu();
        m.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    //*************************************************************
    //Exit from LIMS System
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        //Saves Files
        saveSampleFile();
        
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    //*************************************************************
    //View Clients Clients List mouse click event
    private void listClientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listClientsMouseClicked
        
        //Instanced Member Variables
        JList source =(javax.swing.JList)evt.getSource();
        int index = source.getSelectedIndex();  //Holds currently selected index of the list
        ClientUser temp = (ClientUser)list.getUser(clientUsers.get(index)); //Stores ClientUser Object
        DefaultListModel listModel = new DefaultListModel();
        ArrayList<SampleFile> tempFile = sampleList.getAllUsersSampleFiles(temp.getUsername());
        
        //Sets and Displays each label
        lblLName.setText(list.getUser(clientUsers.get(index)).getLastName());   //Get and Display Last Name of User
        lblFName.setText(list.getUser(clientUsers.get(index)).getFirstName());  //Get and Display First Name of User
        if (list.getUser(clientUsers.get(index)).getPhoneNumber() == 0)
        {
            lblPNumber.setText("");  //Get and Display Phone Number of User
        }
        else{
            lblPNumber.setText(String.valueOf(list.getUser(clientUsers.get(index)).getPhoneNumber()));
        }
        lblComp.setText(temp.getCompanyName()); //Get and Display Company Name that user represents
        
        for (int x = 0; x < sampleList.getAllUsersSampleFiles(temp.getUsername()).size(); x++){
            
            listModel.addElement((int)tempFile.get(x).getSampleID());
        }
        
        listUFiles.setModel(listModel);
        
    }//GEN-LAST:event_listClientsMouseClicked

    //*************************************************************
    //After pressing the Enter button, this event runs in order to verify the change and store it
    private void tblWorkOrderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblWorkOrderKeyReleased

        //Instanced Variables
        ArrayList <SampleFile> fileList = sampleList.getAllSampleFiles();
        row = tblWorkOrder.getSelectedRow();    //Holds current selected row
        column = tblWorkOrder.getSelectedColumn();  //Holds current selected column
        String currentInput = (String) tblWorkOrder.getValueAt(row, column);
        int currentID = (int)tblWorkOrder.getValueAt(row, 0);

        try{
            //Checks if button pressed is the Enter key
            if (evt.getKeyChar() == KeyEvent.VK_ENTER){

                //Checks if selected column is either Analysis (1) or Status(2)
                if (column == 2){

                    //Compares current value in the selected cell
                    //with status of corresponding file for any changes.
                    if (currentInput.equalsIgnoreCase("approved")
                        || currentInput.equalsIgnoreCase("rejected")){

                        //Checks to see if current selected ID exist in the idHolder ArrayList
                        if (!(idHolder.contains(currentID))){
                            idHolder.add(currentID);

                            //If currentInput is equal to approved, then add WIP to the status
                            if (currentInput.equalsIgnoreCase("approved"))
                            statusHolder.add("WIP");
                            else
                            statusHolder.add("Rejected");
                        }

                        //If current sampleID exist within the ArrayList and management wants to change
                        else{
                            int index = idHolder.indexOf(currentID);    //holds index

                            //If currentInput is equal to approved, then add WIP to the status
                            if (currentInput.equalsIgnoreCase("approved"))
                            statusHolder.set(index, "WIP");
                            else
                            statusHolder.set(index, "Rejected");
                        }
                    }
                }
            }
        }
        catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, "Array is out of bounds");
        }
    }//GEN-LAST:event_tblWorkOrderKeyReleased

    //*************************************************************
    //Updates the JTable
    private void btnUpdateTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTableActionPerformed
        try{
            FileInputStream fInput = new FileInputStream("UserListTest");
            ObjectInputStream ois = new ObjectInputStream(fInput);
            list = (UserList)ois.readObject();

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

        fillJTable();
        fillClientList();
//*************************************************************
//          Code dedicated to reset the values of the status and analysist (TESTING PURPOSES)
//        for (int x = 0 ; x<tblWorkOrder.getRowCount();x++){
//             sampleList.getUserSpecificSampleFile((int)tblWorkOrder.getValueAt(x, 0)).setAnalysis("");
//             sampleList.getUserSpecificSampleFile((int)tblWorkOrder.getValueAt(x, 0)).setStatus("revision");
//        }
//        
//        //Saves Files
//        try{
//            //Saves SampleFileList.bin
//            File file = new File("SampleFileList");
//            OutputStream fileOutputStream = new FileOutputStream(file);
//            ObjectOutput outputStream = new ObjectOutputStream(fileOutputStream);
//            outputStream.writeObject(sampleList);
//            
//            //Saves UserList.bin
//            //file = new File("UserListTest");
//            //fileOutputStream = new FileOutputStream(file);
//            //outputStream = new ObjectOutputStream(fileOutputStream);
//            //outputStream.writeObject(list);
//        }
//        catch (FileNotFoundException e){
//            e.printStackTrace();
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }

    }//GEN-LAST:event_btnUpdateTableActionPerformed

    //*************************************************************
    //Writes the changes to corresponding files
    private void btnAcceptChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptChangesActionPerformed

        for (int x = 0; x < idHolder.size();x++ ){
            sampleList.getUserSpecificSampleFile(idHolder.get(x)).setStatus(statusHolder.get(x));
            
            //Loops through the rows until it find correspnding Sample ID that has been changed
            for (int y = 0; y < tblWorkOrder.getRowCount();y++){
                
                //Checks for corresponding SampleId with row to check and store the value of status
                if ((int)tblWorkOrder.getValueAt(y, 0) == idHolder.get(x) && tblWorkOrder.getValueAt(y, 1) !=null ){
                    sampleList.getUserSpecificSampleFile(idHolder.get(x)).setAnalysisID(Integer.parseInt((String)tblWorkOrder.getValueAt(y, 1)));
                    
                    break;
                }
            }
        }
        
        //Saves Files
        saveSampleFile();
    }//GEN-LAST:event_btnAcceptChangesActionPerformed
    
    //*************************************************************
    //Populate the Jlist with Client User's information
    private void fillClientList(){
        
        //Instanced Member Variables
        DefaultListModel listModel1 = new DefaultListModel();
        
        clientUsers = (list.getUsersWithCertainClass("ClientUser"));
       
        for (int x = 0; x < clientUsers.size(); x++){
            
            listModel1.addElement(list.getUser(clientUsers.get(x)).getUserID());   
        }
        
        listClients.setModel(listModel1);
    }
    
    //****************************************************************
    //Populates the JTable in 
    private void fillJTable(){
        
        //Instanced Variables
        DefaultTableModel tbl = (DefaultTableModel)tblWorkOrder.getModel();
        
        tbl.setRowCount(0); //Set Table Row Count = 0
        
        //TableModel tbl = tblWorkOrder.getModel();
        ArrayList <SampleFile> fileList = sampleList.getAllSampleFiles();   //Holds all Sample Files
        
        //combobox to chooose sample types 
        JComboBox StatusComboBox = new JComboBox();
        JComboBox AnalystcomboBox = new JComboBox();
        
        //initiate combobox in the analyst cell 
        TableColumn analystcoloumn = tblWorkOrder.getColumnModel().getColumn(1);
        analystcoloumn.setCellEditor(new DefaultCellEditor(AnalystcomboBox));
       
        //initate combobox in the status cell
        TableColumn  StatusColoumn = tblWorkOrder.getColumnModel().getColumn(2);
        StatusColoumn.setCellEditor(new DefaultCellEditor(StatusComboBox));
     
        //add items for the status combobox
        StatusComboBox.addItem("        "); //empty string 
        StatusComboBox.addItem("Approved");
        StatusComboBox.addItem("Rejected");
       
        analysistUsers = (list.getUsersWithCertainClass("AnalysisUser"));
        
        //populate the analyst combobox 
        for (int x = 0; x < analysistUsers.size(); x++){
            
            AnalystcomboBox.addItem(list.getUser(analysistUsers.get(x)).getUserID());
        }

        //Stores each variable from corresponding SampleFile into an Object arr to add to the JTable row
        for (int x = tblWorkOrder.getRowCount(); x < fileList.size();x++){
            
            String analysis = null;
            
            int ID = fileList.get(x).getSampleID();
            if (fileList.get(x).getAnalysisID() == 0){
                analysis = null;
            }
            else{
                analysis = String.valueOf(fileList.get(x).getAnalysisID());
            }
            
            if (fileList.get(x).getReceivedDate() ==null){
                Date temp = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                String receivedDate = sdf.format(temp);
                fileList.get(x).setReceivedDate(receivedDate);
            }
            else{
                fileList.get(x).getReceivedDate();
            }
            
            String getStatus = fileList.get(x).getStatus();
            String company = fileList.get(x).getCompany();
            String testType = fileList.get(x).getTestType();
            double expFidelity = fileList.get(x).getExpectedFidelity();
            String dueDate = fileList.get(x).getDueDate();
            String sentDate = fileList.get(x).getSentDate();
            String recDate = fileList.get(x).getReceivedDate();
            String compDate = fileList.get(x).getCompletedDate();
            
            Object [] arr = {ID, analysis, getStatus,company, testType, expFidelity,
                             dueDate, sentDate, recDate, compDate};
            
            tbl.addRow(arr);
        }
        tblWorkOrder.setModel(tbl);
    }
    
    private void saveSampleFile(){
        //Saves Files
        try{
            //Saves SampleFileList.bin
            File file = new File("SampleFileList");
            OutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutput outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(sampleList);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    //Declared variable
    private SampleFileList sampleList;  //Holds SampleFileList class
    private ArrayList <String> statusHolder = new ArrayList<String>(); //Holds the changed status of the sample
    private ArrayList <Integer> idHolder = new ArrayList<Integer>();    //Holds the changed sample 
    private ArrayList <String> clientUsers; //Holds users that are clients of the system
    private ArrayList <String> analysistUsers; //Holds users that are clients of the system
    private UserList list;  //Holds UserList (specifically Clients) object    
    private int row;    //Current Clicked row
    private int column; //Current Clicked Column    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane SampleView;
    private javax.swing.JButton btnAcceptChanges;
    private javax.swing.JButton btnUpdateTable;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblComp;
    private javax.swing.JLabel lblFName;
    private javax.swing.JLabel lblLName;
    private javax.swing.JLabel lblPNumber;
    private javax.swing.JList<String> listClients;
    private javax.swing.JList<String> listUFiles;
    private javax.swing.JTable tblWorkOrder;
    // End of variables declaration//GEN-END:variables
}
