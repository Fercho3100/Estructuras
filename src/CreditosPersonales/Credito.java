/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CreditosPersonales;

import Dashboard.dashboardAdmin;
import datos.connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import estructuras.Lista;
import estructuras.operacion;
import estructuras.Persona;


/**
 *
 * @author Fernando
 */
public class Credito extends javax.swing.JFrame {

    /**
     * Creates new form Credito
     */
    DefaultTableModel modelo;
    connect con = new connect();
    datosPersonales datosp = new datosPersonales();

    public Credito() {

        initComponents();
        try {
            this.Asociados();
        } catch (SQLException ex) {
            Logger.getLogger(Credito.class.getName()).log(Level.SEVERE, null, ex);
        }
        btn_credito.setVisible(false);
        modelo = new DefaultTableModel();
        modelo.addColumn("Mes");
        modelo.addColumn("Monto");
        modelo.addColumn("Interes");
        modelo.addColumn("Amortizacion");
        modelo.addColumn("Total");
        modelo.addColumn("Total Saldo");
        this.tabledata.setModel(modelo);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        i_interes = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        i_plazo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        c_asociados = new javax.swing.JComboBox<ComboItem>();
        jLabel5 = new javax.swing.JLabel();
        i_monto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabledata = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btn_calcular = new javax.swing.JButton();
        btn_credito = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(3, 41, 79));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Interés Corriente");

        i_interes.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        i_interes.setText("2.5");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Interés Plazo");

        i_plazo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        i_plazo.setText("24");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("mes(es)");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cliente");

        c_asociados.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        c_asociados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_asociadosActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Monto");

        i_monto.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Creación de Crédito");

        tabledata.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tabledata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mes", "Monto", "Interes", "Amortizacion", "Total", "Total Saldo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabledata);

        jButton1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton1.setText("Atrás");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_calcular.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btn_calcular.setText("Calcular Abonos");
        btn_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcularActionPerformed(evt);
            }
        });

        btn_credito.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btn_credito.setText("Aplicar Crédito");
        btn_credito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_creditoActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(0, 169, 184));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 169, 184));
        jLabel8.setText("AseIsthmus");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Desloguearme");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_credito, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(i_interes)
                    .addComponent(i_plazo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(i_monto, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c_asociados, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(233, 233, 233)
                        .addComponent(jLabel9)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(342, 342, 342))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(i_interes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(i_plazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(30, 30, 30)
                        .addComponent(btn_calcular))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(i_monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(c_asociados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btn_credito))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void abono(int plazo, double interes, double interesmora, double monto) {

        interes = (interes / 100);
        interesmora = (interesmora / 100);
        double facsec = 1 + interes;
        double factor = (double) Math.pow(facsec, plazo);
        double seccion1 = (interes * factor);
        double seccion2 = (factor - 1);
        double abonoMen = 0;
        double abonosem = 0;

        if (interes > 0) {
            double total = monto * seccion1 / seccion2;
            abonoMen = total;
            abonosem = total / 4;
        } else {
            double total = monto / plazo;
            abonoMen = total;
            abonosem = total / 4;
        }
        tablaAmort(interes, interesmora, monto, abonoMen, abonosem, plazo);
    }

    private void tablaAmort(double interes, double interesmora, double monto, double abonoMen, double abonosem, int plazo) {
        double capital = 0;
        for (int i = 0; i <= plazo; i++) {
            int fecha = i;
            double icorriente = 0;
            double imoratorio = 0;
            double itotal = 0;
            double ipendiente = 0;
            double DegloAboAmort = 0;
            double DegloTotal = 0;
            System.out.println(abonoMen);
            if (fecha == 0) {
                capital = monto;
            } else {
                icorriente = capital * interes;
                //                imoratorio = capital * interesmora;
                imoratorio = 0;
                itotal = icorriente + imoratorio;
                DegloAboAmort = abonoMen - icorriente;
                DegloTotal = abonoMen;
                capital = capital - DegloAboAmort;
                if (capital < 1) {
                    capital = 0;
                }
            }

            String[] info = new String[8];
            info[0] = "Mes " + i;
            info[1] = String.format("%,.2f", capital);
            info[2] = String.format("%,.2f", icorriente);
            info[3] = String.format("%,.2f", DegloAboAmort);
            info[4] = String.format("%,.2f", DegloTotal);
            info[5] = String.format("%,.2f", capital);

            modelo.addRow(info);
            

        }

    }

    public void Asociados() throws SQLException {
        ResultSet resultado = null;
        resultado = datosp.Asociados();
        if (resultado != null) {
            int numeroColumna = resultado.getMetaData().getColumnCount();
            c_asociados.addItem(new ComboItem( "Seleccione un Asociado", "-1"));
            Lista lista = new Lista();
            while(resultado.next()){
                    // Lista
                    
                    lista.insertar(new Persona((int) resultado.getObject(1),""+resultado.getObject(2),""+resultado.getObject(3)));
                    
                    c_asociados.addItem(new ComboItem( ""+resultado.getObject(3)+" "+resultado.getObject(4), ""+resultado.getObject(1)));
                    
                    
                }
                    System.out.println(lista.toString());
        }
    }

    private void btn_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcularActionPerformed
        // TODO add your handling code here:
        try{
            int meses = Integer.parseInt(i_plazo.getText());
            double monto = Double.parseDouble(i_monto.getText());
            double interes = Double.parseDouble(i_interes.getText());
            Object item = c_asociados.getSelectedItem();
            String value = ((ComboItem)item).getValue();
            
            if(value == "-1"){
                JOptionPane.showMessageDialog(null, "Seleccione un asociado válido.");
            }else{
                //int meses = Integer.parseInt(i_plazo.getText()); 
                modelo.setRowCount(0);
                this.abono(meses, interes, interes, monto);
                btn_credito.setVisible(true);
            }
            
        }catch(java.lang.NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Complete todos los campos.");
        }
        
    }//GEN-LAST:event_btn_calcularActionPerformed

    private void c_asociadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_asociadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_asociadosActionPerformed

    private void btn_creditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_creditoActionPerformed
        // TODO add your handling code here:
        int plazo = Integer.parseInt(i_plazo.getText());
        double monto = Double.parseDouble(i_monto.getText());
        double interes = Double.parseDouble(i_interes.getText());
        Object item = c_asociados.getSelectedItem();
        String value = ((ComboItem)item).getValue();
        Lista op = new Lista();
        boolean verifica = datosp.InsertaOperacion(new operacion(Integer.parseInt(value),plazo,monto,interes));
        if(verifica){
            JOptionPane.showMessageDialog(null, "Operacián registrada con éxito.");
            btn_credito.setVisible(false);
            dashboardAdmin da = new dashboardAdmin();
            da.setVisible(true);
            this.dispose();
            
        }
        
    }//GEN-LAST:event_btn_creditoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dashboardAdmin da = new dashboardAdmin();
        da.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Credito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Credito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Credito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Credito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Credito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_calcular;
    private javax.swing.JButton btn_credito;
    private javax.swing.JComboBox<ComboItem> c_asociados;
    private javax.swing.JTextField i_interes;
    private javax.swing.JTextField i_monto;
    private javax.swing.JTextField i_plazo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTree jTree1;
    private javax.swing.JTable tabledata;
    // End of variables declaration//GEN-END:variables
}
