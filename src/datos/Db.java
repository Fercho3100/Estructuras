/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import estructuras.Persona;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Db {

    private final String dbDriver = "org.sqlite.JDBC";
    private final String dbPath = "C:/Users/krudin/Desktop/proyectoEstuDatos/Estructuras/src/datos/";
    private final String dbName = "aso.db";
    private final String dbUrl = "jdbc:sqlite:" + dbPath + dbName;

    String affiliates = "affiliatedes";

    public void createAffRecord(Persona persona) {

        Connection conn = dbConnect();

        PreparedStatement p = null;

        String tableName1 = "affiliatedes";

        String insertSql = "INSERT INTO " + tableName1 + " ("
                + "user_code, "
                + "name, last_name, rol, "
                + "gross_amount, date_work, date_to_asso, "
                + "admin, password) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            System.out.println(persona.getName());

            p = conn.prepareStatement(insertSql);

            p.setInt(1, persona.getUser_code());
            p.setString(2, persona.getName());
            p.setString(3, persona.getLast_name());
            p.setString(4, persona.getRol());
            p.setDouble(5, persona.getGross_amount());
            p.setString(6, persona.getDateWork());
            p.setString(7, persona.getDate_to_asso());
            p.setBoolean(8, persona.getAdmin());
            p.setString(9, persona.getPassword());

            p.executeUpdate();

            p.close();
            conn.close();

        } catch (SQLException s) {
            System.out.println("Exception read 1: " + s);
        }
    }
    
        public Persona readAffRecord(int code) {      
        //create a persona by reading record and return a row
        
        estructuras.Persona e = null;
        
        Connection conn = dbConnect();
      
        PreparedStatement p = null;
        
        ResultSet r = null;
        
        String tableName = "affiliatedes";
        
        String selectSql = "SELECT * " +
                            "FROM " + tableName + " "+
                            "WHERE user_code = ? ;";
      
        try {
              p = conn.prepareStatement(selectSql);
              p.setInt(1, code);

              r = p.executeQuery();
              
              if(r.next()) {
                        e = new estructuras.Persona(
                        r.getInt("user_code"),
                        r.getString("name"),
                        r.getString("last_name"),
                        r.getString("rol"),
                        r.getDouble("gross_amount"),
                        r.getString("date_work"),
                        r.getString("date_to_asso"),
                        r.getBoolean("admin"),
                        r.getString("password") 
                        );
//                for(int i=1; i<numCol; i++) {
//                    System.out.println(r.getString(i)+" ,");
//                }
//                System.out.println();
              } 
              
              r.close();
              p.close();
              conn.close();

        } catch(SQLException s) {
            System.out.println("Exception read affiliate record 1: " + s);
        }
        return e;
    }

    public Boolean cabezaEmpty() {
        boolean limpio = false;

        Connection conn = dbConnect();

        ResultSet resultado = null;

        PreparedStatement pst = null;

        try {

            String sql = "SELECT * FROM affiliatedes ";

            pst = conn.prepareStatement(sql);

            resultado = pst.executeQuery();

            if (!resultado.next()) {

                limpio = true;

            }

            pst.close();
            conn.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e.getMessage());

        }

        return limpio;
    }

    public boolean uniquenessCheck(int code) {

        boolean isUnique = false;
        Connection conn = dbConnect();
        ResultSet resultado = null;
        PreparedStatement pst = null;

        try {
            String sql = "SELECT * FROM affiliatedes where user_code = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, code);
            resultado = pst.executeQuery();

            if (!resultado.next()) {
                isUnique = true;
            }

            pst.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "" + e.getMessage());

        }

        return isUnique;

    }

    public void updateAffPassword(Persona e) {
        
        Connection conn = dbConnect();
        
        String pw = e.getPassword();
        int user_code = e.getUser_code();
      
        PreparedStatement p = null;

        String tableName = "affiliatedes";
        
        String updateSql = "UPDATE " + tableName + " " +
                            "SET " + "password = ? " +
                            "WHERE " + "user_code = ? ;";
      
        try {
            
            //temporary until have logic for reading stored pw
            
            String db_password = null;
            
            if (db_password.equals(pw)) {
                
                JOptionPane.showMessageDialog(null, "Elija una contraseña diferente.");
                
            } else {
                
                p = conn.prepareStatement(updateSql);
                
                p.setString(1, pw);
                p.setInt(2, user_code);

                p.executeUpdate();

                p.close();
                conn.close();
            }
            
        } catch(SQLException s) {
            
            System.out.println("Exception update 1: " + s);
        } 
    }
    
    public int[] getUserCodes() {
        Connection conn = dbConnect();
        
        ResultSet resultado = null;
        
        PreparedStatement pst = null;
        
        String tableName = "affiliatedes";
        
        int length = getRowCount(tableName);
        
        try {
                  
            String sql = "SELECT user_code FROM affiliatedes";
            
            pst = conn.prepareStatement(sql);
            
            resultado = pst.executeQuery();          
            
            int[] r = new int[length];
            
            int i = 0;
            
            if(length >0) {
                while(resultado.next() &&  i < length){
                    r[i] = resultado.getInt("user_code");
                    i++;
                }
            } else {
                r = new int[]{};
            }

            resultado.close();
            pst.close();
            conn.close();
            
            return r;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "user codes " + e.getMessage());
            return new int[]{};
        }
    }
    
    public int getRowCount(String tableName) {
        
        Connection conn = dbConnect();
        
        ResultSet resultado = null;
        
        PreparedStatement pst = null;
        
        int count = 0;
        
        try {
            String sql = "SELECT COUNT(*) FROM " + tableName + " ;";

            pst = conn.prepareStatement(sql);
            
            resultado = pst.executeQuery();
            
            count = resultado.getInt("COUNT(*)");
            
            resultado.close();
            pst.close();
            conn.close();

        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "" + e.getMessage());
        }
        return count;
    }
    
   
       
    public void updateRecord() {
        
    }
    
    public void deleteRecord() {
        
    }
    
    private Connection dbConnect() {
        
        try {
            Class.forName(dbDriver);
        } catch(Exception e) {
            System.out.println("Exception connect 1: " + e);
        }
        
        Connection c = null;
        
        try {
            c = DriverManager.getConnection(dbUrl);
        } catch(SQLException f) {
            System.out.println("Exception connect 2: " + f);
        } 
        
        return c;   
    }   
    
}