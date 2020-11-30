
package datos;

import estructuras.Persona;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Json {
    
    JSONArray memberList = new JSONArray(); 
    String folderPath = "src/datos/users.json";
    
    public void writeToFile(Persona p){
        
            JSONParser jsonParser = new JSONParser();

            try (FileReader reader = new FileReader(folderPath)) {
                //reads entire file
                Object obj = jsonParser.parse(reader);
                //parse into array
                JSONArray existingList = (JSONArray) obj;
                
                JSONObject detailObj = new JSONObject();
                
                detailObj.put("id", p.getId());
                detailObj.put("name", p.getName());
                detailObj.put("last_name", p.getLast_name());
                detailObj.put("rol", p.getRol());
                detailObj.put("password", p.getPassword());
                detailObj.put("admin", p.getAdmin());
                detailObj.put("gross_amount", p.getGross_amount());
                detailObj.put("DateWork", p.getDateWork());
                detailObj.put("Date_to_asso", p.getDate_to_asso());
                
                JSONObject memberObj = new JSONObject();
                
                memberObj.put(p.getId(), detailObj);
                memberList.add(memberObj);
                
                existingList.add(memberObj);
                
                try (FileWriter file = new FileWriter(folderPath, false)) {
                    file.write(existingList.toJSONString());
                    file.flush();
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
                    
            } catch (FileNotFoundException e) {
                try (FileWriter file = new FileWriter(folderPath, false)) {
                    file.write(memberList.toJSONString());
                    file.flush();

                } catch (IOException ee) {
                    ee.printStackTrace();
                }
    //                e.printStackTrace();                 
            } catch (IOException e) {
                e.printStackTrace();
                
            } catch (ParseException e) {
                e.printStackTrace();
                
            }       

    }
    
    public void readFile() {

        JSONParser jsonParser = new JSONParser();
        
        try (FileReader reader = new FileReader(folderPath)) {
                //reads entire file
                Object obj = jsonParser.parse(reader);
                //parse into array
                JSONArray memberList = (JSONArray) obj;
                //Iterate over employee array
                memberList.forEach(member -> parseMyObject((JSONObject) member));
                
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            
        } catch (IOException e) {
            e.printStackTrace();
            
        } catch (ParseException e) {
            e.printStackTrace();
            
        }
    }
    
    public void parseMyObject(JSONObject in) {
        
        JSONObject inObj = new JSONObject();

        Long id = (Long) inObj.get("id");
        String name = (String) inObj.get("name");
        String last_name = (String) inObj.get("last_name");
        String rol = (String) inObj.get("rol");
        Boolean admin = (Boolean) inObj.get("admin");
        Double gross_amount = (Double) inObj.get("gross_amount");
        String DateWork = (String) inObj.get("DateWork");
        String Date_to_asso = (String) inObj.get("Date_to_asso");
    }
          
}
