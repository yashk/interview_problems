/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/**
 *
 * @author 186946
 */
public class ValidationUtilities {
    
    public static boolean isNullOrEmpty(String string){
        if(string == null || string.length() == 0){
            return true;
        }
        return  false;
    }
    
    public static void assertNotNull(Object obj) throws NullPointerException{
        if(obj == null){
            throw new NullPointerException();
        }
    }
    
    public  static boolean isNegative(Integer location) {
        if(location.intValue()!=Math.abs(location.intValue())){
            return true;
        }
        return false;
    }
    

    public static boolean isNonNegativeInteger(String integerString){
        Integer integer;
        try{
              integer=Integer.parseInt(integerString);
        }catch(NumberFormatException nfe){
            return false;
        }
        
        if(isNegative(integer)){
            return false;
        }
        return true;
    }
}
