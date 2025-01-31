/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mathmethod;

//Name: Ishaan Mittal 
//Date: 26 Feb 2024 
//Assingment: Math Methods
//Purpose: To create a program that does basic math functions such as power, absoulte value, and toolrance 
public class myMath { //myMath class 

    private double abNum; //declaring instance variables 
    private double tolNum;
    private double tolNum2;
    private double powNum;
    private double powNum2;


    public myMath() {

    }

    public myMath(double ab, double tol1, double tol2, double pow, double pow2) { //takes in user input of the object and saves it into variables 
        abNum = ab; //used for absolute value 
        tolNum = tol1; //used for determining tolerance 
        tolNum2 = tol2;
        powNum = pow; //used for power/exponent calcultions 
        powNum2 = pow2;
    }
 
    public double getAb() { //finds the absolute value of the number 
        return Math.abs(abNum); //returns absolute value
    }

    public boolean getTol() { //finding if the numbers are close enough 
        double tolerance = 0.00001; //universal tolerance 
        boolean check; //boolean to return true or false based on if the numbers are close enough or far 

        check = Math.abs(tolNum - tolNum2) <= tolerance; //calculation to determine tolerance 
        return check; //returns true or false as stated above     
    }

    public double getPow() { //finds powNum2 raised to the power of powNum 
        return Math.pow(powNum2, powNum); // does the power calcualtions and returns the answer      
    }

}
