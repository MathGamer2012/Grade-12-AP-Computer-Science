/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

//Name: Ishaan Mittal 
//Date: 23 Feb 2024 
//Assignment: Random Worksheet 
//Purpose: To make a two sided dice

package twodice;

public class TwoDice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int max = 6; //declaring varibales (max and min) 
        int min = 1; 
        int calc = max - min + 1; //finding range 
        int num = (int) (Math.random() * calc) + min; //doing calculation to generate random number
        int num2 = (int) (Math.random() * calc) + min; //doing calculation to generate random number 

        
        System.out.println("Your random number between 1-6 is: " + num); //print out random number 
        System.out.println("Your random number between 1-6 is: " + num2); //print out random number 

    }
    
}
