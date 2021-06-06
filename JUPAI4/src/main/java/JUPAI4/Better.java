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
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Better {
    public String betterString(String str1, String str2, BiPredicate<String, String>biPred) {
        if(biPred.test(str1, str2)) {
            return str1;
        }
        else {
            return str2;
        }
    }
    
    public boolean alphaOnly(String str, Predicate<String> pred){
        return pred.test(str);
        
    }
}

