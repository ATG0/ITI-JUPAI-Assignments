
import java.io.IOException;
import joinery.DataFrame;
import java.util.*;
import static joinery.DataFrame.JoinType.INNER;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdal
 */
public class Joinery {
    
    public static void main(String[] args) {
        try{
        DataFrame<Object> dfJoinery = DataFrame.readCsv("D:\\Stuff\\AI Program\\5- Java & UML_Amr Elshafey\\day4\\titanic.csv");
        System.out.println(dfJoinery.describe());
        
       
        
        // Dataframe 1
        DataFrame<Object> df1 = dfJoinery.retain("pclass","age", "fare");
        System.out.println(df1.describe());   
        
        // Dataframe 2
        DataFrame<Object> df2 = dfJoinery.retain("survived", "sibsp", "parch", "body");
        System.out.println(df2.describe()); 
        
        // Joining both dataframes to create the original dataframe
        DataFrame<Object> originalJoinDF = df1.join(df2, INNER);
        System.out.println(originalJoinDF.describe());
        
         // Creating a new array that will be added as a column to the DF
        List<Integer> index = new ArrayList<>(); 
        for(int i = 0; i < dfJoinery.length(); i++) {
            index.add(i + 1);
        }
        
        // Adding a new column to the DF
        DataFrame<Object> modifiedDF = dfJoinery.add("index", index);
        System.out.println(modifiedDF.describe());
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

   

        
}
