/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gproject.calculator;
import java.lang.Math;

/**
 *
 * @author Gaurav Yadav
 */
public class Model {
    float result=0;
    public float compute(float numOne, float numTwo,String Operator)
    {
        
        switch(Operator)
        {
            case "+": 
                    result= numOne+numTwo;
                    break;
            case "-":        
                    result=numOne-numTwo;
                    break;
            case "*": 
                    result= numOne*numTwo;
                    break;
            case "/":
                    result= numOne/numTwo;
                    break;
            case "%":
                    result= (float)(numOne*(0.01));
                    break;        
            case "cos":
                    result=(float)Math.cos(numOne);
                    break;
            case "sin":
                    result=(float)Math.sin(numOne);
                    break;        
            case "tan":
                    result=(float)Math.tan(numOne);
                    break;
            case "squareRoot":
                    result=(float)Math.sqrt(numOne);
                    break;       
            case "xInverse":
                    result=(float)Math.pow(numOne,-1);
                    break; 
            case "xSquare":
                    result=(float)Math.pow(numOne,2);
                    break; 
                    
            default: 
                return 0;
                  
        }
        return result;
    }
    
}
