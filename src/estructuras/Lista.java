/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import javax.swing.JOptionPane;

/**
 *
 * @author Naomi Villalobos
 */
public class Lista {
    private Nodo cabeza;
    
    public void inserta (Persona e){
        System.out.println("inserta");
        if (cabeza == null){//op1
            cabeza = new Nodo (e);
        }else{
            
            Nodo auxi=cabeza;
            boolean exist = false;
            
        while (auxi != null && exist == false){//valida que la pila no este vacia y se mantiene falsa hasta encontrar una coincidencia

            if (auxi.getDato().getId() == e.getId()){//compara el parametro con el nombre
                System.out.println("Persona " + e.getId() + " ya existe");
                exist = true;
            }else{
               auxi = auxi.getNext();//avanza de nodo
            }
            }
        
        if (exist == false){
                if (e.getId() < cabeza.getDato().getId()){
            Nodo aux = new Nodo(e);
            aux.setNext(cabeza);
            cabeza = aux;
            }else if (cabeza.getNext() == null){//3
                cabeza.setNext(new Nodo (e));
            }else{
                Nodo aux = cabeza;
                
                while (aux.getNext() != null && e.getId() > aux.getNext().getDato().getId()){
                    aux = aux.getNext();
                }
                Nodo temp = new Nodo(e);
                temp.setNext((aux.getNext()));
                aux.setNext(temp);
                }
                }
        }
    }
        
    public String toString (){
        String msj="";
        Nodo aux = cabeza;
        while (aux !=null) {
            msj+=aux+"\n";
            aux=aux.getNext();
        }
      return msj;  
    }

        
    public void elimina(int b) {
        System.out.println("elimina"); 
        Nodo auxi = cabeza;
         
         if (auxi.getDato().getId() == b){
             cabeza = auxi.getNext();
         }else{
         while (auxi != null ){//valida que la pila no este vacia y se mantiene falsa hasta encontrar una coincidencia

            if (auxi.getNext() != null && auxi.getNext().getDato().getId() == b){//compara el parametro con el nombre
                auxi.setNext(auxi.getNext().getNext());
                
            }else{
               auxi = auxi.getNext();//avanza de nodo
            }
            }

                     
         }
     }

   
}
