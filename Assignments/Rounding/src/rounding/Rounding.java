/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

//Name: Ishaan Mittal 
//Date: 13 Feb 2024 
//Assignment: Rounding 
//Purpose: To create a program that can manually round a double value 

package rounding;

import java.util.Scanner; //Importing the Scanner class to get user input

public class Rounding {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in); // Creats a scanner for userinput 
        double number; //Variable to convert input into double 
        int rounded; //Varibale that returns the rounded value after the calculations are done 
        System.out.print("Enter number: "); // Prints prompt to user 
        number = Double.parseDouble(input.nextLine()); // parses the string into a double value as it is being stored by a double data type 
        rounded = (int)(number + 0.5); //In this part of the program what happens is that the double is casted into an integer meaning any whole number value would be taken in as input for the new int varaible e.g. if the double number was 23.8 it would turn into 23. This is why + 0.5 is introduced as through adding 0.5 it ensures any value over 0.5 in the tenths place is rounded up rather than rounding down thus ensuring proper rounding rules. 
        System.out.println("You number after being rounded is: " + rounded); // prints out rounded number 

    }
    
}
