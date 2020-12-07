package estructuras_k;

import Bienvenida.login;
import Registration.adminRegistration;
import estructuras.Lista;
import estructuras.Persona;

import datos.Db;   //new
import datos.Affiliatedes; //new
import java.sql.*; //new
import java.util.ArrayList; //new

public class Estructuras_K {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Lista lista = new Lista();
        
        adminRegistration adminReg = new adminRegistration();
        


        // TODO code application logic here
        //login login = new login();
//        lista.insertar(new Persona(1, "admin", "admin", "Administrador",  "admin", true, 0.00, "11-11-2019", "01-10-2020"));
//        lista.insertar(new Persona(2, "Juaquina", "Estrada", "Asistente General", "admin123", false, 0.00, "11-12-2019", "01-10-2020"));

        adminReg.setVisible(true);
//        while (!login.getIsValid()) {
//            login.setVisible(true);
//        }

//        Db asoDb = new Db();
//        
//        ArrayList<datos.Affiliatedes> r = new ArrayList<>();
//        r = asoDb.readAllAffDetails();
//        int numCol = r.size();
//        
//        for(int i=0; i<numCol; i++) {
//            System.out.println(r.get(i).getIdAffiliatedes()+" - "+r.get(i).getName());
//        }
//        
//        int asoID = asoDb.validateCredentials("admin", "123");
//        System.out.println(asoID);
//        
//        ArrayList<datos.Affiliatedes> aso_rec = new ArrayList<>();
//        aso_rec = asoDb.getAffDetails(asoID);
//        numCol = aso_rec.size();
//        
//        for(int i=0; i<numCol; i++) {
//            System.out.println(aso_rec.get(i).getIdAffiliatedes()+" - "+aso_rec.get(i).getName()
//                    +", "+ aso_rec.get(i).getLastName());
//        }
        
//        asoDb.creatAffRecord("Karen", "Rudin", "01-10-2014", "31-12-2014", 1, " ", " ");
        
//        asoDb.updateAffUserCode("Karen", "Rudin", "admin1");
        
//        asoDb.updateAffPassword("Karen", "Rudin", "admin123");
        
    }

}
