/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gproject.calculator;

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
                   
            default: 
                return 0;
                  
        }
        return result;
    }
    
}
