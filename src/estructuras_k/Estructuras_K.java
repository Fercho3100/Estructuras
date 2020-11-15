/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras_k;

import Bienvenida.dashboard;
import Bienvenida.login;


/**
 *
 * @author Fernando
 */
public class Estructuras_K {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       login login = new login();
        
        while(!login.getIsValid()){
            login.setVisible(true);
        }
        
        
        
    }
    
}
