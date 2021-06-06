/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUPAI4;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

/**
 *
 * @author Abdal
 */
public class CitiesDAO {
    
    public List<Cities> readCities(String file) {
        File f = new File(file);
        List<Cities> cities = new ArrayList<>();
        
        try {
            List<String> lines = Files.readAllLines(f.toPath());
            for( int i = 1; i < lines.size(); i++) {
                cities.add(createCity(lines.get(i)));
            }
            
            return cities;
        }
        catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    private Cities createCity(String line) {
        String[] fields = line.split(",");
        return new Cities(Integer.parseInt(fields[0]), fields[1], fields[2], Double.parseDouble(fields[3]), Double.parseDouble(fields[4]));
            
    }
    
    
    
    
}
