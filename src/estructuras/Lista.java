package estructuras;

import javax.swing.JOptionPane;

import datos.Db;

public class Lista {

     Db asoDb = new Db();
    private Nodo cabeza;
    
    public Lista() {       
        //construct list - call db and add nodes       
        int[] code = asoDb.getUserCodes();
       
        if(code.length == 0) {
            
            cabeza = new Nodo(null);
            
        } else {
            
            Persona e = new Persona();

            e = asoDb.readAffRecord(code[0]);

            cabeza = new Nodo(e);
        
            for(int i = 1; i < code.length; i++) {

                Persona c = new Persona();

                c = asoDb.readAffRecord(code[i]);

                agregarNodo(c);
            }
        }
        
    }

    private void agregarNodo(Persona db_e) {

        if(cabeza == null) {
            
            cabeza = new Nodo(db_e);
            
        }
        
        Nodo temp = new Nodo(db_e);
        
        Nodo current = cabeza;
        
        while(current.getNext() != null) {
            
            current = current.getNext();
            
        }
        
        current.setNext(temp);
    }
    
    public void insertar(Persona e) {
        
        if(asoDb.uniquenessCheck(e.getUser_code())) {

            if (cabeza == null) {//op1
                
                cabeza = new Nodo(e);

                Db asoDb = new Db();

                asoDb.createAffRecord(e);

                JOptionPane.showMessageDialog(null, "Persona ha sido ingresada al sistema.");

            } else {

                Nodo auxi = cabeza;

                boolean exist = false;

                while (auxi != null && exist == false) {//valida que la pila no este vacia y se mantiene falsa hasta encontrar una coincidencia

//                    System.out.println(cabeza.getDato().getUser_code());
//                    System.out.println(cabeza.getNext());

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

                            exist = true;
                        }

                        JOptionPane.showMessageDialog(null, "Persona ha sido ingresada al sistema.");
                    }
                }
            }
        } else {
            
            JOptionPane.showMessageDialog(null, "Este codigo no esta unica."); 
            
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

    public Boolean validarCredenciales(int cod, String password) {
        
         Nodo auxi = cabeza;
        boolean existe = false;

        if (asoDb.cabezaEmpty()) {
            
            JOptionPane.showMessageDialog(null, "No tenemos record de su usario.");
            
            existe = false;
      
        } else {
        while (auxi != null && existe == false) {
            if (auxi.getDato().getUser_code() == cod  && auxi.getDato().getPassword().equals(password)) {
                
                existe = true;    
            }
            else {
                    auxi = auxi.getNext();//avanza de nodo
                }
        } 
        
    }
        return existe;
    }
    
      public Boolean esAdmin(int cod) {
        int parar = 0;
         Nodo auxi = cabeza;
        boolean admin = false;

 
        while (auxi != null && parar != 1 ) {
            if (auxi.getDato().getUser_code() == cod) {
                
                admin = auxi.getDato().getAdmin();
                parar = 1;
            }
            else {
                    auxi = auxi.getNext();
                }
        }
        return admin;
    }
     
}
