/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.TaskController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Project;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class EditTaskDialogScreen extends javax.swing.JDialog {

    TaskController taskController = new TaskController();
    Project project;
    private boolean hasTask;
    
    public EditTaskDialogScreen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        hideErrorFields();
        
        Task task = new Task();
        taskController = new TaskController();
        
        loadInformation();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelSaveTask = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jFormattedTextFieldDeadline = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaNotes = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jLabelRequiredNameField = new javax.swing.JLabel();
        jLabelRequiredDeadlineField = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 0, 153)));

        jPanel3.setBackground(new java.awt.Color(102, 0, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, java.awt.Color.white));

        jLabel1.setFont(new java.awt.Font("Aharoni", 1, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Tasks");

        jLabelSaveTask.setIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))); // NOI18N
        jLabelSaveTask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSaveTaskMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelSaveTask)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelSaveTask)
                    .addComponent(jLabel1))
                .addGap(7, 7, 7))
        );

        jTextFieldName.setBackground(java.awt.Color.white);
        jTextFieldName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextFieldName.setForeground(new java.awt.Color(102, 0, 153));
        jTextFieldName.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 0, 153)));

        jLabel2.setFont(new java.awt.Font("Aharoni", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Edit task");

        jLabel4.setFont(new java.awt.Font("Aharoni", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 153));
        jLabel4.setText("Name");

        jLabel5.setFont(new java.awt.Font("Aharoni", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 153));
        jLabel5.setText("Description");

        jLabel6.setFont(new java.awt.Font("Aharoni", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 153));
        jLabel6.setText("Deadline");

        jFormattedTextFieldDeadline.setBackground(java.awt.Color.white);
        jFormattedTextFieldDeadline.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 0, 153)));
        jFormattedTextFieldDeadline.setForeground(new java.awt.Color(102, 0, 153));

        jLabel7.setBackground(java.awt.Color.white);
        jLabel7.setFont(new java.awt.Font("Aharoni", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 153));
        jLabel7.setText("Notes");

        jScrollPane2.setBackground(java.awt.Color.white);

        jTextAreaNotes.setBackground(java.awt.Color.white);
        jTextAreaNotes.setColumns(20);
        jTextAreaNotes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextAreaNotes.setForeground(new java.awt.Color(102, 0, 153));
        jTextAreaNotes.setRows(5);
        jTextAreaNotes.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 0, 153)));
        jScrollPane2.setViewportView(jTextAreaNotes);

        jTextAreaDescription.setBackground(java.awt.Color.white);
        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextAreaDescription.setForeground(new java.awt.Color(102, 0, 153));
        jTextAreaDescription.setRows(5);
        jTextAreaDescription.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 0, 153)));
        jScrollPane3.setViewportView(jTextAreaDescription);

        jLabelRequiredNameField.setFont(new java.awt.Font("Aharoni", 3, 10)); // NOI18N
        jLabelRequiredNameField.setForeground(java.awt.Color.red);
        jLabelRequiredNameField.setText("Name field is required");

        jLabelRequiredDeadlineField.setFont(new java.awt.Font("Aharoni", 3, 10)); // NOI18N
        jLabelRequiredDeadlineField.setForeground(java.awt.Color.red);
        jLabelRequiredDeadlineField.setText("Deadline field is required");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(jFormattedTextFieldDeadline)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelRequiredNameField))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelRequiredDeadlineField)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelRequiredNameField))
                .addGap(5, 5, 5)
                .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelRequiredDeadlineField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextFieldDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelSaveTaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSaveTaskMouseClicked
            try{
                if ((!jTextFieldName.getText().isEmpty()) && (!jFormattedTextFieldDeadline.getText().isEmpty())){
                    Task task = new Task();
                    
                    task.setIdproject(project.getId());
                    task.setName(jTextFieldName.getText());
                    task.setDescription(jTextAreaDescription.getText());

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date deadline = null;
                    deadline = sdf.parse(jFormattedTextFieldDeadline.getText());
                    task.setDeadline(deadline);


                    task.setNotes(jTextAreaNotes.getText());
                    task.setCompleted(false);
                    taskController.update(task);
                    JOptionPane.showMessageDialog(rootPane, "Task was sucessful save!");
                    this.dispose();
            } else {
                    hideErrorFields();

                    if(jTextFieldName.getText().isEmpty()){
                        jLabelRequiredNameField.setVisible(true);
                    } 

                    if(jFormattedTextFieldDeadline.getText().isEmpty()){
                        jLabelRequiredDeadlineField.setVisible(true);
                    }
                }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(rootPane, "Error saving task!");
       }
    }//GEN-LAST:event_jLabelSaveTaskMouseClicked

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
                if ("Java swing".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditTaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditTaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditTaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditTaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditTaskDialogScreen dialog = new EditTaskDialogScreen(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField jFormattedTextFieldDeadline;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelRequiredDeadlineField;
    private javax.swing.JLabel jLabelRequiredNameField;
    private javax.swing.JLabel jLabelSaveTask;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JTextArea jTextAreaNotes;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables
    
    public void hideErrorFields (){
        jLabelRequiredNameField.setVisible(false);
        jLabelRequiredDeadlineField.setVisible(false);
    }

    public void setProject(Project project) {
        this.project = project;
    }
    
    public void loadInformation(){
            String sql = "SELECT name, description, deadline, notes FROM tasks WHERE id = ?";

            Connection con = null;
            PreparedStatement stm = null;
            ResultSet rs = null;
            
        try{
               Task task = new Task();
               con = ConnectionFactory.getConnetion();
               stm = con.prepareStatement(sql);
               stm.setInt(1, task.getId());
               rs = stm.executeQuery();
                while(rs.next()){
                    jTextFieldName.setText(rs.getString("name"));
                    jTextAreaDescription.setText(rs.getString("description"));
                    jFormattedTextFieldDeadline.setText("deadline");
                    jTextAreaNotes.setText(rs.getString("notes"));
                }    
        } catch (Exception ex){
            throw new RuntimeException("Erro ao carregar dados da tarefa.");
        } finally {
            ConnectionFactory.closeConnection(con, stm, rs);
        }
    }
}