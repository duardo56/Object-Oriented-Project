/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lims;

import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JTabbedPane;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author reticent
 */
public class AnalysisMenu extends javax.swing.JFrame  {

    /**
     * Creates new form AnalysisMenu
     */
    public AnalysisMenu() {
        initComponents();
        
        //fills the sample list
        fillSampleList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneViewSample = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSampleList = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        lblCompany = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        menuItemLogOut = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        paneViewSample.setMaximumSize(new java.awt.Dimension(600, 600));
        paneViewSample.setPreferredSize(new java.awt.Dimension(450, 450));

        jLabel1.setText("Company:");

        jLabel2.setText("Type: ");

        jLabel3.setText("Stauts: ");

        jLabel4.setText("ID:");

        lblType.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblType.setPreferredSize(new java.awt.Dimension(10, 30));

        listSampleList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listSampleListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listSampleList);

        jLabel6.setText("Current List of Samples");

        lblCompany.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblCompany.setPreferredSize(new java.awt.Dimension(10, 30));

        lblStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblStatus.setPreferredSize(new java.awt.Dimension(10, 30));

        lblID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblID.setPreferredSize(new java.awt.Dimension(10, 30));

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneViewSampleLayout = new javax.swing.GroupLayout(paneViewSample);
        paneViewSample.setLayout(paneViewSampleLayout);
        paneViewSampleLayout.setHorizontalGroup(
            paneViewSampleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneViewSampleLayout.createSequentialGroup()
                .addGroup(paneViewSampleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneViewSampleLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(paneViewSampleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneViewSampleLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(paneViewSampleLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(paneViewSampleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(paneViewSampleLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel1))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addComponent(jLabel6)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(paneViewSampleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(lblID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCompany, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );
        paneViewSampleLayout.setVerticalGroup(
            paneViewSampleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneViewSampleLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(paneViewSampleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneViewSampleLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(paneViewSampleLayout.createSequentialGroup()
                        .addGroup(paneViewSampleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paneViewSampleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(lblType, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paneViewSampleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(lblStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paneViewSampleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneViewSampleLayout.createSequentialGroup()
                                .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(199, Short.MAX_VALUE))
                            .addGroup(paneViewSampleLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(51, 51, 51)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analysis Window");
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setPreferredSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setMaximumSize(new java.awt.Dimension(500, 400));
        jTabbedPane1.setName(""); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(500, 400));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Anlaysis", jPanel1);

        jMenu3.setText("Menu");

        menuItemLogOut.setText("Log Out");
        menuItemLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLogOutActionPerformed(evt);
            }
        });
        jMenu3.add(menuItemLogOut);

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Analysis");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Closes current AnalysisMenu window and opens LoginMenu
    private void menuItemLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLogOutActionPerformed
        this.dispose();
        LoginMenu window = new LoginMenu();
        window.setVisible(true);    
    }//GEN-LAST:event_menuItemLogOutActionPerformed

    //Closes the program when exit from Menu is clicked
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.dispose(); //closes the program
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    //Current Use implementation ideas for this is unknown since constructor
    // takes care of original problem.
    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
       JTabbedPane tabbedPane= (JTabbedPane)evt.getSource();
       int tab = tabbedPane.getSelectedIndex();
       
       //Implement some way to let the program know what current tab its on
       //and to not allow it to run if it is already on the current tab.
       
       if (tabNum ==-1){
           
           //If Analysis Tab is clicked on for the 1st time
           if (tab == 0 ){
               tabNum = tab;
               javax.swing.JOptionPane.showMessageDialog(null, "Analysis Tab was clicked!");
           } 

           //If View Sample tab is clicked on for the 1st time
           else if (tab == 1){
               tabNum = tab;
               javax.swing.JOptionPane.showMessageDialog(null, "View Sample Tab was clicked!");
           }    
        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    //Submits Sample Analysis to manager/management for further approval
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        /*
        Code dedicated to submit changes to the sample analysis to the management
        for further approval before client ends up receiving the final analysis.
        Client may be able to see updates, but may not see final analysis until 
        approved by management.
        */
    }//GEN-LAST:event_jButton2ActionPerformed

    //Refreshed current Sample List available to analysis
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       /*
        
        */
    }//GEN-LAST:event_jButton1ActionPerformed

    //When the User changes between files in the list
    private void listSampleListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listSampleListValueChanged
        JList test = (JList)evt.getSource();
        int num =test.getSelectedIndex();
        //javax.swing.JOptionPane.showMessageDialog(null,num);
        
        readClientFile(num);
    }//GEN-LAST:event_listSampleListValueChanged
    
    //Method to fill the Jlist with samples that analysis is working on
    private void fillSampleList(){
        listModel = new DefaultListModel();
        
        //Can implement an algorithm where it searchers files that
        //the analysis is currently working on then adds those files
        //to the list.
        File loginf = new File("userSample1");
        
        try{
            Scanner read = new Scanner(loginf);  
        }
        catch(FileNotFoundException q){
            javax.swing.JOptionPane.showMessageDialog(null,"Can't find a text file");
        }
        listModel.addElement(loginf.getName()); //gets the name of the file
        listModel.addElement("Testing Number 1");   //adds another element for testing purpose
        
        listSampleList.setModel(listModel); //adds elements to the JList
    }
    
    //Reads from file the Client's submitted information
    private void readClientFile(int e){
        
        File userSample;    //Stores file of sample
        String test;    //Stores the name of the file/sample
        /*
        String company; //Stores comapny name
        String typeT;   //Stores type (?)
        String status;  //Stores status
        String id;  //Stores id
        */
        Scanner read;   //Scanner object read
        
        listModel = (DefaultListModel) listSampleList.getModel(); //retrieves data from listSampleList

        test = listModel.getElementAt(e).toString();    //Stores whatever is at element e in test as a string
        javax.swing.JOptionPane.showMessageDialog(null,test);   //Test Purpose to make
        
        userSample = new File(test);
        
        try{
            read = new Scanner(userSample); 
            read.useDelimiter(",");
            
            /*
            Have to implement an algorithm where it does not exceed the
            use of delimiter (or the reason behind the errors we've gotten
            with the scanner. But as of now, all it does it read the next 4
            things.
            
                company = read.next();
                typeT = read.next();
                status = read.next();
                id = read.next();
              */  
                lblCompany.setText(read.next());
                lblType.setText(read.next());
                lblStatus.setText(read.next());
                lblID.setText(read.next());
            
        }
        catch(FileNotFoundException q){
            javax.swing.JOptionPane.showMessageDialog(null,"Can't find text file");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AnalysisMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnalysisMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnalysisMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnalysisMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnalysisMenu().setVisible(true);
            }
        });
    }
    
    //Declared Variables
    private DefaultListModel listModel;  //keeps track of files assign to analysis
    private int tabNum = -1; //Keeps track of the current tab user is on
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblCompany;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblType;
    private javax.swing.JList<String> listSampleList;
    private javax.swing.JMenuItem menuItemLogOut;
    private javax.swing.JPanel paneViewSample;
    // End of variables declaration//GEN-END:variables
}
