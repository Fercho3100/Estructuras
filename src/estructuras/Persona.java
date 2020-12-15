
package estructuras;


public class Persona {

   

    int user_code;
    String name, last_name, rol, password, DateWork, Date_to_asso;
    boolean admin;
    double gross_amount;

    public Persona() {
    }

    public Persona(String name, String last_name, String rol ) {
        this.name = name;
        this.last_name = last_name;
        this.rol = rol;
        
    }

public Persona(int id, String name, String last_name) {
        this.user_code = id;
        this.name = name;
        this.last_name = last_name;
    }

    public Persona(int user_code, String name, String last_name, String rol, double gross_amount, String DateWork, String Date_to_asso, boolean admin, String password) {
        this.user_code = user_code;
        this.name = name;
        this.last_name = last_name;
        this.rol = rol;
        this.gross_amount = gross_amount;
        this.DateWork = DateWork;
        this.Date_to_asso = Date_to_asso;
        this.admin = admin;
        this.password = password;
    }

      public Persona(String name, String last_name, String rol,  String password, boolean admin, double gross_amount, String DateWork, String Date_to_asso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    @Override
    public String toString() {
        return "Persona{" + "id=" + user_code + ", name=" + name + ", last_name=" + last_name + ", rol=" + rol + ", password=" + password + ", DateWork=" + DateWork + ", Date_to_asso=" + Date_to_asso + ", admin=" + admin + ", gross_amount=" + gross_amount + '}';
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

    public int getUser_code() {
        
        return user_code;
    }

    public void setUser_code(int user_code) {
        this.user_code = user_code;
    }

    public boolean getAdmin() {
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
