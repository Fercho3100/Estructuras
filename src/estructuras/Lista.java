
package estructuras;

import datos.Json;
import javax.swing.JOptionPane;



/**
 *
 * @author Naomi Villalobos
 */
public class Lista {
    
    Json json = new Json();

    private Nodo cabeza;

    public void insertar(Persona e) {
        if (cabeza == null) {//op1
            cabeza = new Nodo(e);
            json.writeToFile(e);
            JOptionPane.showMessageDialog(null, "Persona ha sido ingresada al sistema.");
            json.readFile();
            
        } else {

            Nodo auxi = cabeza;
            boolean exist = false;

            while (auxi != null && exist == false) {//valida que la pila no este vacia y se mantiene falsa hasta encontrar una coincidencia

                if (auxi.getDato().getId() == e.getId()) {//compara el parametro con el nombre
                    JOptionPane.showMessageDialog(null, "Persona con el codigo " + e.getId() + " ya existe en el sistema.");
                    exist = true;
                    break;
                } else {
                    auxi = auxi.getNext();//avanza de nodo
                }
            }

            if (exist == false) {
                if (e.getId() < cabeza.getDato().getId()) { 
                    Nodo aux = new Nodo(e);
                    aux.setNext(cabeza);
                    cabeza = aux;
                } else if (cabeza.getNext() == null) {//3
                    cabeza.setNext(new Nodo(e));
                } else {
                    Nodo aux = cabeza;
                    while (aux.getNext() != null && e.getId() > aux.getNext().getDato().getId()) {
                        aux = aux.getNext();
                    }
                    Nodo temp = new Nodo(e);
                    temp.setNext((aux.getNext()));
                    aux.setNext(temp);
                }
                json.writeToFile(e);
                JOptionPane.showMessageDialog(null, "Persona ha sido ingresada al sistema.");
                
            }
        }
//        System.out.println("in insertar: "+e);
    }

    public String toString() {
        Nodo aux = cabeza;
        String s = "Lista: \n";
        while (aux != null) {
            s += aux + "\n";
            aux = aux.getNext();
        }
        return s;
    }

    public void elimina(int b) {
        System.out.println("elimina");
        Nodo auxi = cabeza;

        if (auxi.getDato().getId() == b) {
            cabeza = auxi.getNext();
        } else {
            while (auxi != null) {//valida que la pila no este vacia y se mantiene falsa hasta encontrar una coincidencia

                if (auxi.getNext() != null && auxi.getNext().getDato().getId() == b) {//compara el parametro con el nombre
                    auxi.setNext(auxi.getNext().getNext());

                } else {
                    auxi = auxi.getNext();//avanza de nodo
                }
            }

        }

    }

    //Metodo no esta fully tested porque necesita dejar el json sirviendo
    public Boolean validarCodigo(int cod, String pw) {
        Nodo auxi = cabeza;

        if (auxi.getDato().getId() == cod && auxi.getDato().getPassword().equals(pw)) {
            JOptionPane.showMessageDialog(null, "Bienvenido");
            return auxi.getDato().getAdmin();
        } else if (auxi.getNext() == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna cuenta con esas credenciales");
        } else {
            while (auxi != null) {

                if (auxi.getNext() != null && auxi.getNext().getDato().getId() == cod) {
                    auxi.setNext(auxi.getNext().getNext());

                } else {
                    auxi = auxi.getNext();
                }
            }
        }
        return false;
    }
    
    
    

}
