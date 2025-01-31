/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

//Name: Ishaan Mittal 
//Date: 23 Feb 2024 
//Assignment: Random Worksheet 
//Purpose: To generate a random number between -3 and 3 (incluvsive) 

package random.pkg3.pkg3;


public class Random33 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int max = 3; //declaring varibales (max and min) 
        int min = -3; 
        int calc = max - min + 1; //finding range 
        int num = (int) (Math.random() * calc) + min; //doing calculation to generate random number 
        
        System.out.println("Your random number between -3 and 3 is: " + num); //print out random number 
    }
    
}
