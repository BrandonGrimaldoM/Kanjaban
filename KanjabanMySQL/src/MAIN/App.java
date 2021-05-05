/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAIN;

import BD.Conection;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author GON
 */
public class App extends javax.swing.JFrame {

    /**
     * Creates new form App
     */
    
    public Conection mysqldata = new Conection();
    DefaultListModel To = new DefaultListModel();
    DefaultListModel Doing = new DefaultListModel();
    DefaultListModel Done = new DefaultListModel();
    String DefaultItem = "Select..........................";
    public App() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/AppImages/icon.png")).getImage());
        cbxProject.addItem(DefaultItem);
        cbxProjectFull();
        ListTo.setModel(To);
        ListDoing.setModel(Doing);
        ListDone.setModel(Done);
        
    }
    
    public void cbxProjectFull(){
        try{
            mysqldata.getProyect();
          do{
                cbxProject.addItem(mysqldata.data.getString("name_project"));
            }
          while(mysqldata.data.next());
        }catch(Exception e){}
    }
    
    public void ListToDoingDone(){
        To.removeAllElements();
        Doing.removeAllElements();
        Done.removeAllElements();
        try{
            mysqldata.getTask(cbxProject.getItemAt(cbxProject.getSelectedIndex()));
          do{
              if(mysqldata.data.getInt("id_stage")== 1){
                  To.addElement(mysqldata.data.getString("name_task"));
              }else if (mysqldata.data.getInt("id_stage")== 2){
                  Doing.addElement(mysqldata.data.getString("name_task"));
              }else if(mysqldata.data.getInt("id_stage")== 3){
                  Done.addElement(mysqldata.data.getString("name_task"));
                  
              }
                
            }
          while(mysqldata.data.next());
        }catch(Exception e){}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnProfile = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        cbxProject = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListTo = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListDoing = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListDone = new javax.swing.JList<>();
        btnDetailsTo = new javax.swing.JButton();
        btnDetailsDoing = new javax.swing.JButton();
        btnDetailsDone = new javax.swing.JButton();
        btnNewTask = new javax.swing.JButton();
        btnToDoing = new javax.swing.JButton();
        btnToTo = new javax.swing.JButton();
        btnDoingDone = new javax.swing.JButton();
        btnDoneDoing = new javax.swing.JButton();
        btnFinishTask = new javax.swing.JButton();
        btnEditProject = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnProfile.setBackground(new java.awt.Color(0, 255, 0));
        btnProfile.setText("Profile");
        btnProfile.setBorderPainted(false);
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });
        getContentPane().add(btnProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel2.setText("Proyects:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 60, 40));

        btnNew.setBackground(new java.awt.Color(0, 255, 0));
        btnNew.setText("New");
        btnNew.setBorderPainted(false);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        getContentPane().add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, -1, -1));

        cbxProject.setBackground(new java.awt.Color(0, 255, 0));
        cbxProject.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbxProjectPopupMenuWillBecomeVisible(evt);
            }
        });
        cbxProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProjectActionPerformed(evt);
            }
        });
        getContentPane().add(cbxProject, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 229, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppImages/KANJABAN.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 240, 70));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setText("To");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setText("Doing");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setText("Done");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, -1));

        ListTo.setBackground(new java.awt.Color(255, 255, 102));
        ListTo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ListTo.setSelectionBackground(new java.awt.Color(255, 255, 255));
        ListTo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListToMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListTo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 102, 247, 236));

        ListDoing.setBackground(new java.awt.Color(102, 255, 204));
        ListDoing.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ListDoing.setSelectionBackground(new java.awt.Color(255, 255, 255));
        ListDoing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListDoingMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ListDoing);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 102, 247, 236));

        ListDone.setBackground(new java.awt.Color(153, 255, 153));
        ListDone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ListDone.setSelectionBackground(new java.awt.Color(255, 255, 255));
        ListDone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListDoneMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ListDone);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 102, 247, 236));

        btnDetailsTo.setBackground(new java.awt.Color(0, 255, 0));
        btnDetailsTo.setText("Details");
        btnDetailsTo.setBorderPainted(false);
        btnDetailsTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsToActionPerformed(evt);
            }
        });
        getContentPane().add(btnDetailsTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 344, -1, -1));

        btnDetailsDoing.setBackground(new java.awt.Color(0, 255, 0));
        btnDetailsDoing.setText("Details");
        btnDetailsDoing.setBorderPainted(false);
        btnDetailsDoing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsDoingActionPerformed(evt);
            }
        });
        getContentPane().add(btnDetailsDoing, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 344, 153, -1));

        btnDetailsDone.setBackground(new java.awt.Color(0, 255, 0));
        btnDetailsDone.setText("Details");
        btnDetailsDone.setBorderPainted(false);
        btnDetailsDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsDoneActionPerformed(evt);
            }
        });
        getContentPane().add(btnDetailsDone, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 344, 73, -1));

        btnNewTask.setBackground(new java.awt.Color(0, 255, 0));
        btnNewTask.setText("New Task");
        btnNewTask.setBorderPainted(false);
        btnNewTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewTaskActionPerformed(evt);
            }
        });
        getContentPane().add(btnNewTask, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 344, 120, -1));

        btnToDoing.setBackground(new java.awt.Color(0, 255, 0));
        btnToDoing.setText(">");
        btnToDoing.setBorderPainted(false);
        btnToDoing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToDoingActionPerformed(evt);
            }
        });
        getContentPane().add(btnToDoing, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 344, -1, -1));

        btnToTo.setBackground(new java.awt.Color(0, 255, 0));
        btnToTo.setText("<");
        btnToTo.setBorderPainted(false);
        btnToTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToToActionPerformed(evt);
            }
        });
        getContentPane().add(btnToTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 344, -1, -1));

        btnDoingDone.setBackground(new java.awt.Color(0, 255, 0));
        btnDoingDone.setText(">");
        btnDoingDone.setBorderPainted(false);
        btnDoingDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoingDoneActionPerformed(evt);
            }
        });
        getContentPane().add(btnDoingDone, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 344, -1, -1));

        btnDoneDoing.setBackground(new java.awt.Color(0, 255, 0));
        btnDoneDoing.setText("<");
        btnDoneDoing.setBorderPainted(false);
        btnDoneDoing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneDoingActionPerformed(evt);
            }
        });
        getContentPane().add(btnDoneDoing, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 344, -1, -1));

        btnFinishTask.setBackground(new java.awt.Color(0, 255, 0));
        btnFinishTask.setText("Finish Proyect");
        btnFinishTask.setBorderPainted(false);
        btnFinishTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishTaskActionPerformed(evt);
            }
        });
        getContentPane().add(btnFinishTask, new org.netbeans.lib.awtextra.AbsoluteConstraints(666, 344, 121, -1));

        btnEditProject.setBackground(new java.awt.Color(0, 255, 0));
        btnEditProject.setText("Edit");
        btnEditProject.setBorderPainted(false);
        btnEditProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProjectActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditProject, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppImages/3.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 380));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppImages/3.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 410, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProjectActionPerformed
        
        ListToDoingDone();
    }//GEN-LAST:event_cbxProjectActionPerformed

    private void ListToMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListToMouseClicked
         
         ListDoing.clearSelection();
         ListDone.clearSelection();
    }//GEN-LAST:event_ListToMouseClicked

    private void ListDoingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListDoingMouseClicked
         ListTo.clearSelection();
         ListDone.clearSelection();
    }//GEN-LAST:event_ListDoingMouseClicked

    private void ListDoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListDoneMouseClicked
         ListDoing.clearSelection();
         ListTo.clearSelection();
    }//GEN-LAST:event_ListDoneMouseClicked

    private void btnNewTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewTaskActionPerformed
        if(cbxProject.getItemAt(cbxProject.getSelectedIndex())!=DefaultItem){
            
            AddNewTask newTaskView = new AddNewTask(this,true);
            newTaskView.selectProject = cbxProject.getItemAt(cbxProject.getSelectedIndex());
            newTaskView.stageList = 1;
            newTaskView.txtProjectData.setText(cbxProject.getItemAt(cbxProject.getSelectedIndex()));
            cbxProject.setSelectedIndex(0);
            newTaskView.setVisible(true);
            
        }else{
            JOptionPane.showMessageDialog(null, "Select proyect","¡Ups!",JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnNewTaskActionPerformed

    private void btnToDoingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToDoingActionPerformed
        try{
        mysqldata.UpdateTask(2, (String) To.getElementAt(ListTo.getSelectedIndex()));
        mysqldata.UpdateStartDate((String) To.getElementAt(ListTo.getSelectedIndex()));
         ListToDoingDone();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Select task","¡Ups!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnToDoingActionPerformed

    private void btnToToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToToActionPerformed
       try{
        mysqldata.UpdateTask(1, (String) Doing.getElementAt(ListDoing.getSelectedIndex()));
        mysqldata.UpdateStartDateNull((String) Doing.getElementAt(ListDoing.getSelectedIndex()));
         ListToDoingDone();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Select task","¡Ups!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnToToActionPerformed

    private void btnDoingDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoingDoneActionPerformed
        try{
        mysqldata.UpdateTask(3, (String) Doing.getElementAt(ListDoing.getSelectedIndex()));
        mysqldata.UpdateEndDate((String) Doing.getElementAt(ListDoing.getSelectedIndex()));
         ListToDoingDone();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Select task","¡Ups!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDoingDoneActionPerformed

    private void btnDoneDoingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneDoingActionPerformed
        try{
        mysqldata.UpdateTask(2, (String) Done.getElementAt(ListDone.getSelectedIndex()));
        mysqldata.UpdateEndDateNull((String) Done.getElementAt(ListDone.getSelectedIndex()));
         ListToDoingDone();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Select task","¡Ups!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDoneDoingActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        Profile DescProfile = new Profile(this,true);
        DescProfile.setVisible(true);
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
       NewProject addproject = new NewProject(this,true);
       addproject.setVisible(true);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnFinishTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishTaskActionPerformed
       if(cbxProject.getSelectedIndex()!=0){
       EndProject end = new EndProject(this,true);
       end.txtendPro.setText(cbxProject.getItemAt(cbxProject.getSelectedIndex()));
       cbxProject.setSelectedIndex(0);
       end.setVisible(true);
       }else{
           JOptionPane.showMessageDialog(null, "Select project");
       }
    }//GEN-LAST:event_btnFinishTaskActionPerformed

    private void btnDetailsToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsToActionPerformed
       try{
       Details opendetailsTo = new Details(this,true);
       opendetailsTo.txtProject.setText(cbxProject.getItemAt(cbxProject.getSelectedIndex()));
       opendetailsTo.taskname = (String) To.getElementAt(ListTo.getSelectedIndex());
       opendetailsTo.load();
       cbxProject.setSelectedIndex(0);
       opendetailsTo.setVisible(true);
       }catch(Exception e){
         JOptionPane.showMessageDialog(null, "Select task","¡ups!",JOptionPane.WARNING_MESSAGE);
       }
    }//GEN-LAST:event_btnDetailsToActionPerformed

    private void btnDetailsDoingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsDoingActionPerformed
        try{
        Details opendetailsDoing = new Details(this,true);
        opendetailsDoing.txtProject.setText(cbxProject.getItemAt(cbxProject.getSelectedIndex()));
        opendetailsDoing.taskname = (String) Doing.getElementAt(ListDoing.getSelectedIndex());
        opendetailsDoing.load();
        cbxProject.setSelectedIndex(0);
        opendetailsDoing.setVisible(true);
        }catch(Exception e){
         JOptionPane.showMessageDialog(null, "Select task","¡ups!",JOptionPane.WARNING_MESSAGE);
       }
    }//GEN-LAST:event_btnDetailsDoingActionPerformed

    private void btnDetailsDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsDoneActionPerformed
        try{
        Details opendetailsDone = new Details(this,true);
        opendetailsDone.txtProject.setText(cbxProject.getItemAt(cbxProject.getSelectedIndex()));
        opendetailsDone.taskname = (String) Done.getElementAt(ListDone.getSelectedIndex());
        opendetailsDone.load();
        cbxProject.setSelectedIndex(0);
        opendetailsDone.setVisible(true);
        }catch(Exception e){
         JOptionPane.showMessageDialog(null, "Select task","¡ups!",JOptionPane.WARNING_MESSAGE);
       }
    }//GEN-LAST:event_btnDetailsDoneActionPerformed

    private void cbxProjectPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbxProjectPopupMenuWillBecomeVisible
        cbxProject.removeAllItems();
        cbxProject.addItem(DefaultItem);
        cbxProjectFull();
        
    }//GEN-LAST:event_cbxProjectPopupMenuWillBecomeVisible

    private void btnEditProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProjectActionPerformed
        if(!cbxProject.getItemAt(cbxProject.getSelectedIndex()).equals(DefaultItem)){
        
        EditProject editPro = new EditProject(this,true);
        editPro.name = cbxProject.getItemAt(cbxProject.getSelectedIndex());
        editPro.projectName();
        cbxProject.setSelectedIndex(0);
        editPro.setVisible(true);
        }else{
        JOptionPane.showMessageDialog(null, "Select project","¡Ups!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditProjectActionPerformed

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
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListDoing;
    private javax.swing.JList<String> ListDone;
    private javax.swing.JList<String> ListTo;
    private javax.swing.JButton btnDetailsDoing;
    private javax.swing.JButton btnDetailsDone;
    private javax.swing.JButton btnDetailsTo;
    private javax.swing.JButton btnDoingDone;
    private javax.swing.JButton btnDoneDoing;
    private javax.swing.JButton btnEditProject;
    private javax.swing.JButton btnFinishTask;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNewTask;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnToDoing;
    private javax.swing.JButton btnToTo;
    public javax.swing.JComboBox<String> cbxProject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
