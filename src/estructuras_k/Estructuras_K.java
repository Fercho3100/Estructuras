package estructuras_k;

import Bienvenida.login;
import Registration.adminRegistration;
import datos.Db;
import estructuras.Lista;
import estructuras.Nodo;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Estructuras_K {

    public static void main(String[] args) {

        // adminRegistration adminReg = new adminRegistration();
        // TODO code application logic here
        login login = new login();
//        
        //adminReg.setVisible(true);
        while (!login.getIsValid()) {
            login.setVisible(true);

        }

    }
}
