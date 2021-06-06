/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUPAI4;

/**
 *
 * @author Abdal
 */
public class Countries {
    
    int countryCode;
    String name;
    
    public Countries(int countryCode, String name) {
        this.countryCode = countryCode;
        this.name = name;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public String getName() {
        return name;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override 
    public String toString() {
        return "Country Name is" + name + "and Code is " + countryCode + ".";
    }
}
