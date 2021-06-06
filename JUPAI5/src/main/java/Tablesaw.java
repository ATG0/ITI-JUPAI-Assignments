
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdal
 */
public class Tablesaw {
    public static void main(String[] args) {
        try {
            Table df = Table.read().csv("D:\\Stuff\\AI Program\\5- Java & UML_Amr Elshafey\\day4\\titanic.csv");
            
            System.out.println(df.structure());
            System.out.println(df.summary());
           
            
            
            // Creating a new column to add to the df
            Integer[] index = new Integer[df.rowCount()]; 
            for(int i = 0; i < df.rowCount(); i++) {
                index[i] = i;
            }
            IntColumn col = IntColumn.create("Index", index); 
            
            // Adding the column to the df
            Table modifiedDF = df.addColumns(col);
            
            System.out.println(modifiedDF.structure());
            System.out.println(modifiedDF.summary());
            
            // Creating 2 new dataframes
            Table df1 = modifiedDF.select("ticket", "fare", "cabin", "index");
            Table df2 = modifiedDF.select("embarked", "boat", "body", "index");
            System.out.println(df1.structure());
            System.out.println(df2.structure());
            
            // Joining the 2 dataframes
            
        
        } catch (IOException ex) {
            Logger.getLogger(Tablesaw.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
