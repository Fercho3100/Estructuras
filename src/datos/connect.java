/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando
 */
public class connect {
    String url = "src/datos/aso.db";
    public Connection connect;
    public Statement consulta;
    public void connect() {
        
      try {
	            Class.forName("org.sqlite.JDBC");
	        }
	        catch (ClassNotFoundException e) {
	            JOptionPane.showMessageDialog(null, e.getMessage());
	        }	 
			try {
                            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
                            consulta = connect.createStatement();
			} catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
    }

    public void close() {
        try {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
