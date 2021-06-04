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
public class CountriesDAO {
    
    public List<Countries> readCountries (String file) {
        File f = new File(file);
        List<Countries> countries = new ArrayList<>();
        
        try {
            List<String> lines = Files.readAllLines(f.toPath());
            for( int i = 1; i < lines.size(); i++) {
                countries.add(createCountry(lines.get(i)));
            }
            
            return countries;
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private Countries createCountry(String line) {
            String[] fields = line.split(",");
            return new Countries(Integer.parseInt(fields[0]), fields[1]);
        }
    
}
