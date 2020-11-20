/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.File;
import estructuras.Persona;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Fernando
 */
public class orm {

    String path_json = "src/datos/users.json";
    
    private String data_json="";
    String name,last_name,rol,DateWork,Date_to_asso,passwd;

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    int id,admin,date,is_active;
    double amount_gross;

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

    public JSONArray getEmployeeList_bk() {
        return employeeList_bk;
    }

    public void setEmployeeList_bk(JSONArray employeeList_bk) {
        this.employeeList_bk = employeeList_bk;
    }
    
    JSONArray employeeList_bk = new JSONArray();
    
    public String getData_json() {
        return data_json;
    }

    public void setData_json(String data_json) {
        this.data_json = getData_json()+data_json;
    }

    public orm() {
        File archivo = new File("src/datos/users.json");
        if (!archivo.exists()) {
            System.out.println("OJO: ¡¡No existe el archivo de configuración!!");
        }
    }

    public boolean add(Persona data) {

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(path_json)) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);
            
            //First Employee
            JSONObject employeeDetails = new JSONObject();
            
            employeeDetails.put("nombre_completo", data.getName() + " " + data.getLast_name());
            employeeDetails.put("passwd", "");
            employeeDetails.put("monto_bruto", data.getAmount_gross());
            employeeDetails.put("fecha_ingreso_aso", data.getDateWork());
            employeeDetails.put("fecha_ingreso", data.getDate_to_asso());
            employeeDetails.put("admin", data.getAdmin());

            JSONObject employeeObject = new JSONObject();
            employeeObject.put(data.getId(), employeeDetails);

            employeeList.add(employeeObject);
            
            
            //Write JSON file
            try (FileWriter file = new FileWriter(path_json)) {

                file.write(employeeList.toJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void applyUpdate(JSONObject obj, int identification,Persona data) {
        //Get employee object within listJSONArray employeeList = new JSONArray();
        
        //System.out.println(Integer.toString(identification));
        try{
            
            JSONObject employeeObjectDetails = (JSONObject) obj.get(Integer.toString(identification));
            //System.out.println(employeeObject);
            employeeObjectDetails.put("nombre_completo", data.getName() + " " + data.getLast_name());
            employeeObjectDetails.put("passwd", "");
            employeeObjectDetails.put("monto_bruto", data.getAmount_gross());
            employeeObjectDetails.put("fecha_ingreso_aso", data.getDateWork());
            employeeObjectDetails.put("fecha_ingreso", data.getDate_to_asso());
            
            JSONObject employeeObject = new JSONObject();
            employeeObject.put(data.getId(), employeeObjectDetails);

            employeeList_bk.add(employeeObject);

            
            
            //setData_json(employeeList_bk.toString()+",");
        }catch(NullPointerException e){
            System.out.println("no aplica, no exite registro");
            employeeList_bk.add(obj);
            //setData_json(employeeList_bk.toString()+",");
        }
        
        //System.out.println(employeeObject);
    }

    public boolean update(Persona data) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(path_json)) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            
            JSONArray employeeList = (JSONArray) obj;
            
            employeeList.forEach(emp -> applyUpdate((JSONObject) emp,data.getId(),data));
            
            
            //Write JSON file
            try (FileWriter file = new FileWriter(path_json)) {

                file.write(employeeList_bk.toString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(orm.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    public void parseobject(JSONObject obj,int id){

        JSONParser jsonParser = new JSONParser();
        
        JSONObject employeeObject = (JSONObject) obj.get(Integer.toString(id));

        try{
           
            setId(3);
            String nombre = (String) employeeObject.get("nombre_completo");
            setName(nombre);
            String passwds = (String) employeeObject.get("passwd");
            setPasswd(passwds);
            double monto_bruto = (double) employeeObject.get("monto_bruto");
            setAmount_gross(monto_bruto);
            String fecha_ingreso_aso = (String) employeeObject.get("fecha_ingreso_aso");
            setDate_to_asso(fecha_ingreso_aso);
            String fecha_ingreso = (String) employeeObject.get("fecha_ingreso");
            setDateWork(fecha_ingreso);
            long adminss = (long) employeeObject.get("admin");

            setAdmin((int) (adminss));
        }catch(NullPointerException e){
            System.out.println("Id no encontrado");
            setId(0);
            setName("sin resultados");
            setPasswd("sin resultados");
            setAmount_gross(-1);
            setDate_to_asso("Sin resultados");
            setDateWork("Sin resultados");
            setAdmin(-1);
        }
       
    
    }
    public Persona select_id(int id){
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(path_json)) {

            Object obj = jsonParser.parse(reader);
            
            JSONArray employeeList = (JSONArray) obj;
            
            employeeList.forEach(emp -> parseobject((JSONObject) emp,id));
            
            
            
            return new Persona (getId(),getName(),getLast_name(),getAdmin(),"empleado",getAmount_gross(),getDateWork(),getDate_to_asso(),1);
            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(orm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }

}
