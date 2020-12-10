/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import Dashboard.dashboardAdmin;
import estructuras.Lista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import estructuras.Persona;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import datos.Db;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class adminRegistration extends javax.swing.JFrame {

    Lista lista = new Lista();

    Color errColor = Color.red;

    Color defLabelColor = Color.white;
    Color defTextColor = Color.black;

    String errText = " es requerido!";
    String defTextUsercode;
    String defTextName;
    String defTextLastname;
    String defTextRol;
    String defTextGrossAmount;
    String defTextStartDate;
    String defTextAsoDate;
    String defTextUsername;
    String defTextPassword;

    /**
     * Creates new form adminRegistration
     */
    public adminRegistration() {

        initComponents();

        this.defTextUsercode = jLabel_usercode.getText();
        this.defTextName = jLabel_name.getText();
        this.defTextLastname = jLabel_lastname.getText();
        this.defTextRol = jLabel_rol.getText();
        this.defTextGrossAmount = jLabel_grossAmount.getText();
        this.defTextStartDate = jLabel_startDate.getText();
        this.defTextAsoDate = jLabel_asoDate.getText();
        this.defTextPassword = jTextField_password.getText();

        jTextField_password.setVisible(false);
        jTextField_usercode.requestFocus();
    }

    public void clearTextFields(Container container) {

        for (Component c : container.getComponents()) {
            if (c instanceof JTextField) {
                JTextField f = (JTextField) c;

                f.setText("");
            } else if (c instanceof Container) {
                clearTextFields((Container) c);
            }
        }
        checkbox_isAdmin.setState(false);

    }

    private Boolean validateInputs() {
        int errCount = 0;

        errCount = errCount
                + checkBlankTextInput(jTextField_usercode, jLabel_usercode,
                        this.defTextUsercode, this.errText)
                + checkBlankTextInput(jTextField_name, jLabel_name,
                        this.defTextName, this.errText)
                + checkBlankTextInput(jTextField_lastname, jLabel_lastname,
                        this.defTextLastname, this.errText)
                + checkBlankTextInput(jTextField_rol, jLabel_rol,
                        this.defTextRol, this.errText)
                + checkBlankTextInput(jTextField_grossAmount, jLabel_grossAmount,
                        this.defTextGrossAmount, this.errText)
                + checkBlankCalInput(jDateChooser_startDate, jLabel_startDate,
                        this.defTextStartDate, this.errText)
                + checkBlankCalInput(jDateChooser_asoDate, jLabel_asoDate,
                        this.defTextAsoDate, this.errText);

        return errCount == 0;
    }

    private int checkBlankTextInput(JTextField fieldName, JLabel labelName, String defText, String errText) {
        int errCount = 0;

        if (fieldName.getText().length() == 0) {
            fieldName.setForeground(this.errColor);
            labelName.setText(defText + errText);
            labelName.setForeground(this.errColor);
            errCount++;
        } else {
            fieldName.setForeground(this.defTextColor);
            labelName.setText(defText);
            labelName.setForeground(this.defLabelColor);
        }
        return errCount;
    }

    private int checkBlankCalInput(JDateChooser calendarName, JLabel labelName,
            String defText, String errText) {
        int errCount = 0;

        if (calendarName.getDate() == null) {
            labelName.setText(defText + errText);
            labelName.setForeground(this.errColor);
            errCount++;

        } else {
            labelName.setText(defText);
            labelName.setForeground(this.defLabelColor);
        }
        return errCount;
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
        jLabel_usercode = new javax.swing.JLabel();
        jLabel_name = new javax.swing.JLabel();
        jTextField_name = new javax.swing.JTextField();
        jLabel_lastname = new javax.swing.JLabel();
        jTextField_usercode = new javax.swing.JTextField();
        jTextField_lastname = new javax.swing.JTextField();
        jLabel_rol = new javax.swing.JLabel();
        jTextField_rol = new javax.swing.JTextField();
        jLabel_grossAmount = new javax.swing.JLabel();
        jTextField_grossAmount = new javax.swing.JTextField();
        jLabel_startDate = new javax.swing.JLabel();
        jLabel_asoDate = new javax.swing.JLabel();
        checkbox_isAdmin = new java.awt.Checkbox();
        jTextField_password = new javax.swing.JTextField();
        button_send = new java.awt.Button();
        button_clear = new java.awt.Button();
        jDateChooser_asoDate = new com.toedter.calendar.JDateChooser();
        jDateChooser_startDate = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(3, 41, 79));
        jPanel1.setForeground(new java.awt.Color(0, 0, 255));

        jLabel1.setBackground(new java.awt.Color(0, 169, 184));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 169, 184));
        jLabel1.setText("AseIsthmus");

        jLabel_usercode.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel_usercode.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_usercode.setText("Codigo de empleado");

        jLabel_name.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel_name.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_name.setText("Nombre");

        jTextField_name.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTextField_name.setNextFocusableComponent(jTextField_lastname);

        jLabel_lastname.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel_lastname.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_lastname.setText("Apellido");

        jTextField_usercode.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTextField_usercode.setNextFocusableComponent(jTextField_name);
        jTextField_usercode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_usercodeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_usercodeKeyTyped(evt);
            }
        });

        jTextField_lastname.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTextField_lastname.setNextFocusableComponent(jTextField_rol);

        jLabel_rol.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel_rol.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_rol.setText("Posición");

        jTextField_rol.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTextField_rol.setNextFocusableComponent(jTextField_grossAmount);

        jLabel_grossAmount.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel_grossAmount.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_grossAmount.setText("Salario");

        jTextField_grossAmount.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTextField_grossAmount.setNextFocusableComponent(jDateChooser_startDate);
        jTextField_grossAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_grossAmountKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_grossAmountKeyTyped(evt);
            }
        });

        jLabel_startDate.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel_startDate.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_startDate.setText("Fecha de ingreso");

        jLabel_asoDate.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel_asoDate.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_asoDate.setText("Fecha de Asociación");

        checkbox_isAdmin.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        checkbox_isAdmin.setForeground(new java.awt.Color(255, 255, 255));
        checkbox_isAdmin.setLabel("Administrador");
        checkbox_isAdmin.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                checkbox_isAdminPropertyChange(evt);
            }
        });

        jTextField_password.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTextField_password.setNextFocusableComponent(button_send);

        button_send.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        button_send.setLabel("Enviar");
        button_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_sendActionPerformed(evt);
            }
        });

        button_clear.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        button_clear.setLabel("Borrar");
        button_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_clearActionPerformed(evt);
            }
        });

        jDateChooser_asoDate.setDateFormatString("yyyy-MM-dd");

        jDateChooser_startDate.setDateFormatString("yyyy-MM-dd");
        jDateChooser_startDate.setNextFocusableComponent(jDateChooser_asoDate);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_usercode, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField_password, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField_usercode, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel_lastname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField_name)
                                    .addComponent(jTextField_lastname)
                                    .addComponent(jTextField_rol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(105, 105, 105)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel_grossAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_startDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_asoDate, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(jTextField_grossAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jDateChooser_startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(button_clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button_send, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jDateChooser_asoDate, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(checkbox_isAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(checkbox_isAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel_grossAmount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_grossAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel_startDate)
                                    .addComponent(jLabel_lastname))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser_startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel_name)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_usercode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_usercode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_asoDate)
                    .addComponent(jLabel_rol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField_rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser_asoDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_send, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_sendActionPerformed
dashboardAdmin dashadmin = new dashboardAdmin();
        int ingresaInfo;

        Date asoDate = jDateChooser_asoDate.getDate();

        System.out.println(asoDate);

        Date startDate = jDateChooser_asoDate.getDate();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String strAsoDate = null;

        if (asoDate == null) {

            strAsoDate = null;

        } else {

            strAsoDate = dateFormat.format(asoDate);
        }

        String strStartDate = null;

        if (startDate == null) {

            strStartDate = null;

        } else {

            strStartDate = dateFormat.format(startDate);
        }

        if (validateInputs()) {
            ingresaInfo = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea continuar?", "Confirmacion", JOptionPane.YES_NO_OPTION);

            if (ingresaInfo != JOptionPane.NO_OPTION) {

                if (ingresaInfo == JOptionPane.YES_OPTION) {

                    lista.insertar(new Persona(Integer.parseInt(jTextField_usercode.getText()),
                            jTextField_name.getText(),
                            jTextField_lastname.getText(),
                            jTextField_rol.getText(),
                            Double.parseDouble(jTextField_grossAmount.getText()),
                            strStartDate,
                            strAsoDate,
                            checkbox_isAdmin.getState(),
                            ""));

                }
                dispose();
                dashadmin.setVisible(true);

            }
        }
    }//GEN-LAST:event_button_sendActionPerformed

    private void button_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_clearActionPerformed
        clearTextFields(this.getContentPane());
    }//GEN-LAST:event_button_clearActionPerformed

    private void checkbox_isAdminPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_checkbox_isAdminPropertyChange


    }//GEN-LAST:event_checkbox_isAdminPropertyChange

    private void jTextField_grossAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_grossAmountKeyTyped

        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') || (c == '.')
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_grossAmountKeyTyped

    private void jTextField_usercodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_usercodeKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_usercodeKeyTyped

    private void jTextField_grossAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_grossAmountKeyPressed
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') || (c == '.')
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_grossAmountKeyPressed

    private void jTextField_usercodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_usercodeKeyPressed
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_usercodeKeyPressed

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
            java.util.logging.Logger.getLogger(adminRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button_clear;
    private java.awt.Button button_send;
    private java.awt.Checkbox checkbox_isAdmin;
    private com.toedter.calendar.JDateChooser jDateChooser_asoDate;
    private com.toedter.calendar.JDateChooser jDateChooser_startDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_asoDate;
    private javax.swing.JLabel jLabel_grossAmount;
    private javax.swing.JLabel jLabel_lastname;
    private javax.swing.JLabel jLabel_name;
    private javax.swing.JLabel jLabel_rol;
    private javax.swing.JLabel jLabel_startDate;
    private javax.swing.JLabel jLabel_usercode;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField_grossAmount;
    private javax.swing.JTextField jTextField_lastname;
    private javax.swing.JTextField jTextField_name;
    private javax.swing.JTextField jTextField_password;
    private javax.swing.JTextField jTextField_rol;
    private javax.swing.JTextField jTextField_usercode;
    // End of variables declaration//GEN-END:variables
}
