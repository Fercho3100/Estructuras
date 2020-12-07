/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import estructuras.Persona;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import datos.Affiliatedes;

//import java.sql.;

import javax.swing.JOptionPane;


/**
 *
 * @author KVR
 */
public class Db {
    
    private final String dbDriver = "org.sqlite.JDBC";
    private final String dbPath = "C:/Users/krudin/Documents/EstructurasDatos/src/datos/";
//    private final String dbPath = "src/datos";
    private final String dbName = "aso.db";
    private final String dbUrl = "jdbc:sqlite:" + dbPath + dbName;
    
    public void createAffRecord(Integer user_code, String name, String lastName, String rol,
                Double gross_amount, String date_work, String dato_to_asso, 
                Boolean admin, String pw) {
        
        Connection conn = dbConnect();
      
        PreparedStatement p = null;
        
        String tableName1 = "affiliatedes";
        
        String insertSql = "INSERT INTO " + tableName1 + " (" 
                                + "user_code, "
                                + "name, last_name, rol, "
                                + "gross_amount, date_work, date_to_asso, "
                                + "admin, password) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
      
        try {
              p = conn.prepareStatement(insertSql);
              
              p.setInt(1, user_code);
              p.setString(2, name);
              p.setString(3, lastName);
              p.setString(4, rol);
              p.setDouble(5, gross_amount);
              p.setString(6, date_work);
              p.setString(7, dato_to_asso);
              p.setBoolean(8, admin);
              p.setString(9, pw);

              
              p.executeUpdate();
              
              p.close();
              conn.close();

        } catch(SQLException s) {
            System.out.println("Exception read 1: " + s);
        }
    }
    
    public void createAffRecord(Persona persona) {
        
        Connection conn = dbConnect();
      
        PreparedStatement p = null;
        
        String tableName1 = "affiliatedes";
        
        String insertSql = "INSERT INTO " + tableName1 + " (" 
                                + "user_code, "
                                + "name, last_name, rol, "
                                + "gross_amount, date_work, date_to_asso, "
                                + "admin, password) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
      
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

        } catch(SQLException s) {
            System.out.println("Exception read 1: " + s);
        }
    }
   
    
    public void updateAffPassword(String name, String lastName, String pw) {
        
        Connection conn = dbConnect();
        
        ArrayList<datos.Affiliatedes> record = new ArrayList<>();
        
        record = getAffDetails(name, lastName);
        
        int id = record.get(0).getIdAffiliatedes();
        
        String db_password = record.get(0).getPassword();
      
        PreparedStatement p = null;

        String tableName = "affiliatedes";
        
        String updateSql = "UPDATE " + tableName + " " +
                            "SET " + "password = ? " +
                            "WHERE " + "id_" + tableName +" = ? ;";
      
        try {
            
            if (db_password.equals(pw)) {
                
                JOptionPane.showMessageDialog(null, "Elija una contraseña diferente.");
                
            } else {
                
                p = conn.prepareStatement(updateSql);
                
                p.setString(1, pw);
                p.setInt(2, id);

                p.executeUpdate();

                p.close();
                conn.close();
            }
            
        } catch(SQLException s) {
            
            System.out.println("Exception update 1: " + s);
        } 
    }
    
    public ArrayList<datos.Affiliatedes> readAllAffDetails() {
        
        Connection conn = dbConnect();
      
        PreparedStatement p = null;
        
        ResultSet r = null;
        
        String tableName = "affiliatedes";
        
        String selectAllSql = "SELECT * FROM " + tableName;
        
        ArrayList<datos.Affiliatedes> recordList = new ArrayList<>();
      
        try {
              p = conn.prepareStatement(selectAllSql);
              p.clearParameters();

              r = p.executeQuery();
              ResultSetMetaData rmd = r.getMetaData();
              int numCol = rmd.getColumnCount();
              
              while(r.next()) {
                datos.Affiliatedes record = new datos.Affiliatedes(
                        r.getInt("id_"+tableName),
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
                recordList.add(record);
//                for(int i=1; i<numCol; i++) {
//                    System.out.println(r.getString(i)+" ,");
//                }
//                System.out.println();
              }
              
              r.close();
              p.close();
              conn.close();

        } catch(SQLException s) {
            System.out.println("Exception read 1: " + s);
        }
        return recordList;
    }
        
    
  
    public String readAffPassword(String name, String lastName) {

        ArrayList<datos.Affiliatedes> record = new ArrayList<>();
        
        record = getAffDetails(name, lastName);
        
        
        String pw = record.get(0).getPassword();
      
        return pw;
    }
    
    
        public int readAffCode(int userCode) {

        ArrayList<datos.Affiliatedes> record = new ArrayList<>();
        
        record = getAffDetails(userCode);
        
        
        int code = record.get(0).getUserCode();
      
        return code;
    }
    
    
    public Integer validateCredentials(String un, String pw) {
        
        Connection conn = dbConnect();
      
        PreparedStatement p = null;
        
        ResultSet r = null;
        
        String tableName = "affiliatedes";
        
        String selectSql = "SELECT "+"id_" + tableName + " " +                         
                           "FROM " + tableName + " " +
                           "WHERE " +"userCode = ? " +
                           "AND " + "password = ? ;";
        
        int value = -1;
      
        try {
              p = conn.prepareStatement(selectSql);
              p.setString(1, un);
              p.setString(2, pw);

              r = p.executeQuery();
              ResultSetMetaData rmd = r.getMetaData();
              int numCol = rmd.getColumnCount();
              
              if(r.next()) {
                value = r.getInt("id_" + tableName);
//                for(int i=1; i<numCol; i++) {
//                    System.out.println(r.getString(i)+" ,");
//                }
//                System.out.println();
              } else {
                  JOptionPane.showMessageDialog(null, "Credenciales invalidas.");
              }
              
              r.close();
              p.close();
              conn.close();

        } catch(SQLException s) {
            System.out.println("Exception read 1: " + s);
        }
        return value;
    }
    
    public ArrayList<datos.Affiliatedes> getAffDetails() {
        
        Connection conn = dbConnect();
      
        PreparedStatement p = null;
        
        ResultSet r = null;

        String tableName = "affiliatedes";
        
        String selectSql = "SELECT * " +                           
                           "FROM " + tableName + " " +" ;";

        ArrayList<datos.Affiliatedes> recordList = new ArrayList<>();
      
        try {
              p = conn.prepareStatement(selectSql);

              r = p.executeQuery();
              
              ResultSetMetaData rmd = r.getMetaData();
//              int numCol = rmd.getColumnCount();
              
              while(r.next()) {
                datos.Affiliatedes record = new datos.Affiliatedes(
                        r.getInt("id_"+tableName),
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
                recordList.add(record);
//                for(int i=1; i<numCol; i++) {
//                    System.out.println(r.getString(i)+" ,");
//                }
//                System.out.println();
              }
              
              r.close();
              p.close();
              conn.close();

        } catch(SQLException s) {
            System.out.println("Exception read 1: " + s);
        }
        return recordList;
    }
    
    public ArrayList<datos.Affiliatedes> getAffDetails(int id) {
        
        Connection conn = dbConnect();
      
        PreparedStatement p = null;
        
        ResultSet r = null;

        String tableName = "affiliatedes";
        
        String selectSql = "SELECT * " +                           
                           "FROM " + tableName + " " +
                           "WHERE " + "id_"+ tableName + " = ? ;";

        ArrayList<datos.Affiliatedes> recordList = new ArrayList<>();
      
        try {
              p = conn.prepareStatement(selectSql);
              p.setInt(1, id);

              r = p.executeQuery();
              ResultSetMetaData rmd = r.getMetaData();
//              int numCol = rmd.getColumnCount();
              
              while(r.next()) {
                datos.Affiliatedes record = new datos.Affiliatedes(
                        r.getInt("id_"+tableName),
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
                recordList.add(record);
//                for(int i=1; i<numCol; i++) {
//                    System.out.println(r.getString(i)+" ,");
//                }
//                System.out.println();
              }
              
              r.close();
              p.close();
              conn.close();

        } catch(SQLException s) {
            System.out.println("Exception read 1: " + s);
        }
        return recordList;
    }
    
    public ArrayList<datos.Affiliatedes> getAffDetails(String name, String lastName) {
        
        Connection conn = dbConnect();
      
        PreparedStatement p = null;
        
        ResultSet r = null;

        String tableName = "affiliatedes";
        
        String selectSql = "SELECT * " +                           
                           "FROM " + tableName + " " +
                           "WHERE name = ? " +
                           "AND last_name = ?;";
        
        int value = -1;

        ArrayList<datos.Affiliatedes> recordList = new ArrayList<>();
      
        try {
              p = conn.prepareStatement(selectSql);
              p.setString(1, name);
              p.setString(2, lastName);

              r = p.executeQuery();
              ResultSetMetaData rmd = r.getMetaData();
//              int numCol = rmd.getColumnCount();
              
              while(r.next()) {
                datos.Affiliatedes record = new datos.Affiliatedes(
                        r.getInt("id_"+tableName),
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
                recordList.add(record);
//                for(int i=1; i<numCol; i++) {
//                    System.out.println(r.getString(i)+" ,");
//                }
//                System.out.println();
              }
              
              r.close();
              p.close();
              conn.close();

        } catch(SQLException s) {
            System.out.println("Exception read 1: " + s);
        }
        return recordList;
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
