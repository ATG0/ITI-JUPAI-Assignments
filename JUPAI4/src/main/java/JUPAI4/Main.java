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

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CountriesDAO countryDAO = new CountriesDAO();
        CitiesDAO cityDAO = new CitiesDAO();
        
        List<Countries> countries = new ArrayList<>();
        List<Cities> cities = new ArrayList<>();
        
        countries = countryDAO.readCountries("D:\\Stuff\\AI Program\\5- Java and UML Design\\Countries.csv");
        cities = cityDAO.readCities("D:\\Stuff\\AI Program\\5- Java and UML Design\\Cities.csv");
        
        
        Map<Integer, List<Cities>> citiesInside = new HashMap<>();
        
        for(Cities city : cities) {
            if(!citiesInside.containsKey(city.countryCode)) {
                List<Cities> citiesList = new ArrayList<>();
                citiesList.add(city);
                citiesInside.put(city.countryCode, citiesList);
            }
            else {
                citiesInside.get(city.countryCode).add(city);
            }
        }
        
        System.out.println(citiesInside);
        
        
        
        
        
        // the betterString implementation
        Better compare = new Better();
        
        String result = compare.betterString("Test 1", "Tests 3", (str1, str2) -> str1.length() > str2.length());
        System.out.println(result);
        
        Boolean check = compare.alphaOnly("Tests", (str) -> {
            for(int i = 0; i < str.length(); i++) {
                if(!Character.isLetter(str.charAt(i))){
                    return false;
                }
            }
            return true;
        });
        
        System.out.println(check);
        
        
        // Sorting the cities by population within a country code 
        citiesInside.forEach((code, city) -> city.stream().map(Cities::getPopulation).sorted().collect(Collectors.toList()));
        

        // Highest Population Exercises
        // Highest Population in a city per country
        Map<Integer, List<Cities>> hPopCityCountry = cities.stream().collect(Collectors.groupingBy(Cities::getCountryCode));
        hPopCityCountry.forEach((code ,city) ->
                System.out.println( city.stream().map(Cities::getPopulation).max(Double::compare)));
        
        // Highest Population in a city per continent
        Map<String, List<Cities>> hPopCityContinent = cities.stream().collect(Collectors.groupingBy(Cities::getContinent));
        hPopCityCountry.forEach((continent ,city) ->
                System.out.println(city.stream().map(Cities::getPopulation).max(Double::compare)));
        
        
        
        // Exercise 4:
        double median, lowQuart, uppQuart, avg;

        List<Double> sortedCities = cities.stream().map(Cities::getPopulation).sorted().collect(Collectors.toList());
        System.out.println(sortedCities);
        
        if (sortedCities.size() % 2 != 0) {
            median = (double) sortedCities.get(sortedCities.size()/2);
            lowQuart = (double) sortedCities.get(sortedCities.size()/4);
            uppQuart = (double) sortedCities.get((sortedCities.size()* (3/4)));
        }
            else {
            median = (double)sortedCities.get((sortedCities.size()/2)) + (double)sortedCities.get((sortedCities.size())/2 + 1)/2;
            lowQuart = (double)sortedCities.get(sortedCities.size()/4) + (double)sortedCities.get((sortedCities.size()/4)+ 1)/2;
            uppQuart = (double)sortedCities.get((sortedCities.size()* (3/4))) + (double)sortedCities.get((sortedCities.size()*(3/4) + 1))/2;
        }

        Double popSum = sortedCities.stream()
                .reduce(0.0, (x, y) -> x + y);
        System.out.println(popSum);
        avg = popSum / sortedCities.size();
                
       
        
        
        
    }
    
}
