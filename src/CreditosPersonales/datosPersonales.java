/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CreditosPersonales;
import datos.connect;
import estructuras.operacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Fernando
 */
public class datosPersonales extends connect {
   public ResultSet Asociados(){
    connect();
    ResultSet resultado = null;
    try {
        String sql = "SELECT * FROM affiliatedes;";
        resultado = consulta.executeQuery(sql);
    }catch (SQLException e) {
     JOptionPane.showMessageDialog(null, ""+e.getMessage());
    }
     return resultado;
   }
   
   
   public ResultSet Operaciones(int afiliado){
    connect();
    ResultSet resultado = null;
    try {
        String sql = "SELECT * FROM transactions where id_affiliatedes = "+afiliado+";";
        resultado = consulta.executeQuery(sql);
    }catch (SQLException e) {
     JOptionPane.showMessageDialog(null, ""+e.getMessage());
    }
     return resultado;
   }

   
   public ResultSet MovOperaciones(int trans){
       
    connect();
    ResultSet resultado = null;
    try {
        String sql = "SELECT move_transaciotions.*,types.name from move_transaciotions inner join types on move_transaciotions.id_type = types.id_type  where id_mov = "+trans+";";
        resultado = consulta.executeQuery(sql);
    }catch (SQLException e) {
        JOptionPane.showMessageDialog(null, ""+e.getMessage());
    }
    
    return resultado;
   }
   public ResultSet GetPersona(int code){
       
    connect();
    ResultSet resultado = null;
    try {
        String sql = "SELECT * from affiliatedes where user_code = "+code+";";
        resultado = consulta.executeQuery(sql);
    }catch (SQLException e) {
        JOptionPane.showMessageDialog(null, ""+e.getMessage());
    }
    
    return resultado;
   }
   
   
   public boolean AgregarAbonos (int trans,double monto){
       
    connect();
    boolean valor = true;
    ResultSet resultado = null;
    try {

        PreparedStatement pstmt = connect.prepareStatement("INSERT INTO move_transaciotions (id_mov,id_type,interest,amortization,total) VALUES ( ?, ?, ?, ?, ?);");
        pstmt.setInt(1, trans);
        pstmt.setDouble(2, 2);
        pstmt.setDouble(3, 0);
        pstmt.setDouble(4, monto);
        pstmt.setDouble(5, monto);
        pstmt.executeUpdate();
        
    }catch (SQLException e) {
        JOptionPane.showMessageDialog(null, ""+e.getMessage());
        valor = false;
    }

    return valor;
   }
   
   
   public boolean InsertaOperacion(operacion op){
       boolean valor = true;
        connect();
        try {
            PreparedStatement pstmt = connect.prepareStatement("INSERT INTO transactions (id_affiliatedes,total,time_limit,interest,at_date) VALUES (?,?,?,?,?)");
            pstmt.setInt(1, op.getId_asociado());
            pstmt.setDouble(2, op.getTotal());
            pstmt.setDouble(3, op.getPlazo());
            pstmt.setDouble(4, op.getInteres());
            pstmt.setString(5, op.getFecha());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
                valor = false;
                JOptionPane.showMessageDialog(null, e.getMessage());
            }      
        finally{  
            try{    
                 consulta.close();  
                 connect.close();  
             }catch (Exception e){                 
                 e.printStackTrace();  
             }  
        }
        return valor;
   
   }
}
    