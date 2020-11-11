/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

/**
 *
 * @author Naomi Villalobos
 */
public class Persona {
    
    String name,last_name,rol,DateWork,Date_to_asso;
    int id,admin,date,is_active;
    double amount_gross;

    public Persona(int id, String name,String last_name,int admin,String rol, double amount_gross, String DateWork ,String Date_to_asso,int is_active) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.admin = admin;
        this.rol = rol;
        this.amount_gross = amount_gross;
        this.DateWork =DateWork;
        this.Date_to_asso =Date_to_asso;
        this.is_active = is_active;
    }

    @Override
    public String toString() {
        return "Persona{" + "name=" + name + ", last_name=" + last_name + ", rol=" + rol + ", DateWork=" + DateWork + ", Date_to_asso=" + Date_to_asso + ", id=" + id + ", admin=" + admin + ", date=" + date + ", is_active=" + is_active + ", amount_gross=" + amount_gross + '}';
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

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

    public double getAmount_gross() {
        return amount_gross;
    }

    public void setAmount_gross(double amount_gross) {
        this.amount_gross = amount_gross;
    }


    

    
}
