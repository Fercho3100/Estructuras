package estructuras;

import javax.swing.JOptionPane;

import datos.Db;

public class Lista {

    Db asoDb = new Db();
    private Nodo cabeza;

    public Lista() {
        //construct list - call db and adds nodes       
        int[] code = asoDb.getUserCodes();

        if (code.length == 0) {

            cabeza = new Nodo(null);
        } else {
            Persona e = new Persona();
            e = asoDb.readAffRecord(code[0]);
            cabeza = new Nodo(e);
            for (int i = 1; i < code.length; i++) {
                Persona c = new Persona();
                c = asoDb.readAffRecord(code[i]);
                agregarNodo(c);
            }
        }
    }

    private void agregarNodo(Persona db_e) {

        if (cabeza == null) {

            cabeza = new Nodo(db_e);
        }
        Nodo temp = new Nodo(db_e);

        Nodo current = cabeza;

        while (current.getNext() != null) {

            current = current.getNext();
        }

        current.setNext(temp);
    }

    public void insertar(Persona e) {

        if (cabeza == null) {

            cabeza = new Nodo(e);
        } else {

            Nodo auxi = cabeza;

            boolean exist = false;

            while (auxi != null && exist == false) {
                if (exist == false) {

                    if (e.getUser_code() < cabeza.getDato().getUser_code()) {

                        Nodo aux = new Nodo(e);

                        aux.setNext(cabeza);

                        cabeza = aux;

                    } else if (cabeza.getNext() == null) {

                        cabeza.setNext(new Nodo(e));

                    } else {

                        Nodo aux = cabeza;

                        while (aux.getNext() != null && e.getUser_code() > aux.getNext().getDato().getUser_code()) {

                            aux = aux.getNext();
                        }
                        Nodo temp = new Nodo(e);

                        temp.setNext((aux.getNext()));

                        aux.setNext(temp);
                        exist = true;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        Nodo aux = cabeza;
        String s = "Lista: \n";
        while (aux != null) {
            s += aux + "\n";
            aux = aux.getNext();
        }
        return s;
    }

    public Persona datosPersona(int code) {

        Nodo auxi = cabeza;
        Persona datos = new Persona();

        if (asoDb.cabezaEmpty() || !validarCodigo(code)) {

            JOptionPane.showMessageDialog(null, "No tenemos record de su usuario.", "Error", JOptionPane.ERROR_MESSAGE);

        } else {
            while (auxi != null) {
                if (auxi.getDato().getUser_code() == code) {
                    datos = auxi.getDato();
                    break;
                } else {

                    auxi = auxi.getNext();//avanza de nodo
                }
            }
        }
        return datos;
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

    public Boolean validarCodigo(int cod) {

        Nodo auxi = cabeza;
        boolean existe = false;

        if (asoDb.cabezaEmpty()) {

            JOptionPane.showMessageDialog(null, "No tenemos record de su usario.", "Error", JOptionPane.ERROR_MESSAGE);

            existe = false;

        } else {
            while (auxi != null && existe == false) {
                if (auxi.getDato().getUser_code() == cod) {
                    existe = true;
                } else {

                    auxi = auxi.getNext();//avanza de nodo
                }
            }
        }
        return existe;
    }

    public Boolean validarContrasena(int cod, String password) {
        Nodo auxi = cabeza;
        boolean existe = false;

        if (!validarCodigo(cod)) {
            JOptionPane.showMessageDialog(null, "Se ha presentado un error de autenticacion con su codigo o contraseña" + "\n"
                    + "Por favor contacte al administrador del sistema.", "Error", JOptionPane.ERROR_MESSAGE);

        } else {
            while (auxi != null && existe == false) {
                if (auxi.getDato().getUser_code() == cod) {
                    String pw = auxi.getDato().getPassword();

                    if (pw == null) {
                        JOptionPane.showMessageDialog(null, "Su contraseña no ha sido seteada." + "\n"
                                + "Si desea setearla, dirijase al link de Cambiar Contraseña", "Error", JOptionPane.ERROR_MESSAGE);
                        break;

                    } else if (password.equals(pw)) {
                        existe = true;

                    } else {
                        JOptionPane.showMessageDialog(null, "Se ha presentado un error de autenticacion con su codigo o contraseña" + "\n"
                                + "Por favor contacte al administrador del sistema.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                } else {
                    auxi = auxi.getNext();
                }
            }
        }

        return existe;
    }

    public Boolean esAdmin(int cod) {
        int parar = 0;
        Nodo auxi = cabeza;
        boolean admin = false;

        while (auxi != null && parar != 1) {
            if (auxi.getDato().getUser_code() == cod) {

                admin = auxi.getDato().getAdmin();
                parar = 1;
            } else {
                auxi = auxi.getNext();
            }
        }
        return admin;
    }

    public void actualizarPersona(int code, String password) {
        Nodo auxi = cabeza;
        boolean actualizado = false;

        while (auxi != null && actualizado == false) {
            if (auxi.getDato().getUser_code() == code) {
                auxi.getDato().setPassword(password);
                actualizado = true;

            } else {
                auxi = auxi.getNext();
            }
        }
    }

 
}
