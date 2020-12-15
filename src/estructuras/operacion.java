/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

/**
 *
 * @author Fernando
 */
public class operacion {
    int id_asociado,plazo;
    double total,interes;
    String fecha;
    
    public int getId_asociado() {
        return id_asociado;
    }

    public void setId_asociado(int id_asociado) {
        this.id_asociado = id_asociado;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public operacion(int id_asociado, int plazo, double total, double interes) {
        this.id_asociado = id_asociado;
        this.plazo = plazo;
        this.total = total;
        this.interes = interes;
    }
    
}
