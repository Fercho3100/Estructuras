/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import java.util.Set;
import java.util.Date;
import javax.swing.JOptionPane;

import datos.Db;

/**
 *
 * @author Naomi Villalobos
 */
public class Lista {
     Db asoDb = new Db();

    private Nodo cabeza;

    public void insertar(Persona e) {
        if (cabeza == null) {
            cabeza = new Nodo(e);
       asoDb.createAffRecord(e);
            JOptionPane.showMessageDialog(null, "Persona ha sido ingresada al sistema.");

        } else {

            Nodo auxi = cabeza;
            boolean exist = false;

            while (auxi != null && exist == false) {//valida que la pila no este vacia y se mantiene falsa hasta encontrar una coincidencia

                if (auxi.getDato().getUser_code() == e.getUser_code()) {//compara el parametro con el nombre
                    JOptionPane.showMessageDialog(null, "Persona con el codigo " + e.getUser_code() + " ya existe en el sistema.");
                    exist = true;
                    break;
                } else {
                    auxi = auxi.getNext();//avanza de nodo
                }
            }

            if (exist == false) {
                if (e.getUser_code() < cabeza.getDato().getUser_code()) {
                    Nodo aux = new Nodo(e);
                    aux.setNext(cabeza);
                    cabeza = aux;
                } else if (cabeza.getNext() == null) {//3
                    cabeza.setNext(new Nodo(e));
                } else {
                    Nodo aux = cabeza;
                    while (aux.getNext() != null && e.getUser_code() > aux.getNext().getDato().getUser_code()) {
                        aux = aux.getNext();
                    }
                    Nodo temp = new Nodo(e);
                    temp.setNext((aux.getNext()));
                    aux.setNext(temp);
                    asoDb.createAffRecord(e);
                }

                JOptionPane.showMessageDialog(null, "Persona ha sido ingresada al sistema.");

            }
        }

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

        if (auxi.getDato().getUser_code() == b) {
            cabeza = auxi.getNext();
        } else {
            while (auxi != null) {//valida que la pila no este vacia y se mantiene falsa hasta encontrar una coincidencia

                if (auxi.getNext() != null && auxi.getNext().getDato().getUser_code() == b) {//compara el parametro con el nombre
                    auxi.setNext(auxi.getNext().getNext());

                } else {
                    auxi = auxi.getNext();//avanza de nodo
                }
            }

        }

    }

    public Boolean validarCodigo(int cod, String pw) {
        Nodo auxi = cabeza;

        if (auxi.getDato().getUser_code() == cod && auxi.getDato().getPassword().equals(pw)) {
            JOptionPane.showMessageDialog(null, "Bienvenido");
            return auxi.getDato().getAdmin();
        } else if (auxi.getNext() == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna cuenta con esas credenciales");
        } else {
            while (auxi != null) {//valida que la pila no este vacia y se mantiene falsa hasta encontrar una coincidencia

                if (auxi.getNext() != null && auxi.getNext().getDato().getUser_code() == cod) {//compara el parametro con el nombre
                    auxi.setNext(auxi.getNext().getNext());

                } else {
                    auxi = auxi.getNext();//avanza de nodo
                }
            }
        }
        return false;
    }

}
