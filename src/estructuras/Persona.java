/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import java.util.Date;

/**
 *
 * @author Naomi Villalobos
 */
public class Persona {

    int id;
    String name, last_name, rol, password, DateWork, Date_to_asso;
    boolean admin;
    double gross_amount;

    //  public Persona(String name, String last_name, String rol, String username, String password, boolean admin, double gross_amount, Date DateWork, Date Date_to_asso) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
    public Persona(int id, String name, String last_name, String rol, String password, boolean admin, double gross_amount, String DateWork, String Date_to_asso) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.rol = rol;
        this.password = password;
        this.admin = admin;
        this.gross_amount = gross_amount;
        this.DateWork = DateWork;
        this.Date_to_asso = Date_to_asso;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", name=" + name + ", last_name=" + last_name + ", rol=" + rol + ", password=" + password + ", DateWork=" + DateWork + ", Date_to_asso=" + Date_to_asso + ", admin=" + admin + ", gross_amount=" + gross_amount + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDateWork() {
        return DateWork;
    }

    public void setDateWork(String DateWork) {
        this.DateWork = DateWork;
    }

    public String getDate_to_asso() {
        return Date_to_asso;
    }

    public void setDate_to_asso(String Date_to_asso) {
        this.Date_to_asso = Date_to_asso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public double getGross_amount() {
        return gross_amount;
    }

    public void setGross_amount(double gross_amount) {
        this.gross_amount = gross_amount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
