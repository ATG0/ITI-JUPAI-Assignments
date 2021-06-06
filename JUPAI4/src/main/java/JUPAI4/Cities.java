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
public class Cities {
    
    int countryCode;
    String name;
    String continent;
    double surfaceArea;
    double population;
    
    public Cities (int countryCode, String name, String continent, double surfaceArea, double population)
    {
        this.countryCode = countryCode;
        this.name = name;
        this.continent = continent;
        this.surfaceArea = surfaceArea;
        this.population = population;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public String getName() {
        return name;
    }
    
    public String getContinent() {
        return continent;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public double getPopulation() {
        return population;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public void setPopulation(double population) {
        this.population = population;
    }
 
    
    
    @Override
    public String toString() {
        return "City details are Code = " + countryCode + ", name : " + name + ", continent : " + continent + ", surface area : " + surfaceArea + ", population : " + population;
    }
}
