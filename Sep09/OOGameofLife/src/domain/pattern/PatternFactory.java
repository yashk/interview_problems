/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package domain.pattern;

import io.IO;

/**
 *
 * @author 186946
 */
public class PatternFactory {
    private static final IO io = new IO();

    public static Pattern square(){
        Pattern square = io.getPattern("X X\nX X\n");
        return square;
    }
    
    
    public  static Pattern squareResult(){
          Pattern squareResult = io.getPattern("X X\nX X\n");
           return squareResult;
    }


    public  static Pattern blinker(){
        Pattern blinker = io.getPattern("- X -\n- X -\n- X -\n");
        return blinker;
    }


    public  static Pattern blinkerResult(){
          Pattern blinkerResult = io.getPattern("- - -\nX X X\n- - -");
           return blinkerResult;
    }


    public  static Pattern boat(){
        Pattern boat = io.getPattern("X X -\nX - X\n- X -");
        return boat;
    }


    public  static Pattern boatResult(){
          Pattern boatResult = io.getPattern("X X -\nX - X\n- X -");
           return boatResult;
    }
  

}
