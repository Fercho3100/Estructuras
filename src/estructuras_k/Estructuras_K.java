package estructuras_k;

import Bienvenida.login;
import Registration.adminRegistration;
import estructuras.Lista;
import estructuras.Persona;

public class Estructuras_K {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista lista = new Lista();
        
        adminRegistration adminReg = new adminRegistration();
        


        // TODO code application logic here
        login login = new login();
//        lista.insertar(new Persona(1, "admin", "admin", "Administrador",  "admin", true, 0.00, "11-11-2019", "01-10-2020"));
//        lista.insertar(new Persona(2, "Juaquina", "Estrada", "Asistente General", "admin123", false, 0.00, "11-12-2019", "01-10-2020"));

        adminReg.setVisible(true);
//        while (!login.getIsValid()) {
//            login.setVisible(true);
//        }

       
    }

}
