package estructuras;

import datos.Db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Nodo {

    private Nodo next;
    private Persona dato;

    public Nodo() {
    }

    public Nodo(Persona dato) {
        this.dato = dato;
    }

    public Nodo getLast(Nodo node) {
        Nodo lastNode = node;
        if (lastNode.getNext() != null) {
            return getLast(lastNode.getNext());
        } else {
            return lastNode;
        }
    }

    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + '}';
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public Persona getDato() {
        return dato;
    }

    public void setDato(Persona dato) {
        this.dato = dato;
    }

}
