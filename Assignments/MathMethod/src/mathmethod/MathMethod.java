/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mathmethod;

//Name: Ishaan Mittal 
//Date: 26 Feb 2024 
//Assingment: Math Methods
//Purpose: To create a program that does basic math functions such as power, absoulte value, and tolerance 

public class MathMethod {

    public static void main(String[] args) {
        String joe = "cocomelon"; 
        String hi = joe.substring(0, joe.length());
        System.out.println(hi); 
        myMath num1 = new myMath(-3, 5, 5.0000000, 2, 3); //object 
        
        System.out.println("The absolute value of the number is: " + num1.getAb()); //prints the absoulte value of the first parameter 
        if (num1.getTol() == true) {
            System.out.println("The numbers are accurate (in terms of tolerance)"); //finds if the numbers (2 and 3 parameters) are accurate 
        }
        
        else {
            System.out.println("The numbers are not accurate (in terms of tolerance)"); //finds if the numbers (2 and 3 parameters) are not accurate    
        }
        
        System.out.println("The resulting number after doing the power operation is: " + num1.getPow()); //prints the value the numer 1 (4th parameter) raised as an exponent to number 2 (5th parameter)
        
    }
    
}
