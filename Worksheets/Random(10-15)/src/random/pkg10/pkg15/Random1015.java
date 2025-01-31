/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//Name: Ishaan Mittal 
//Date: 23 Feb 2024 
//Assignment: Random Worksheet 
//Purpose: To generate a random number between 10 and 15 (incluvsive) 

package random.pkg10.pkg15;

public class Random1015 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int max = 15; //declaring varibales (max and min) 
        int min = 10; 
        int calc = max - min + 1; //finding range 
        int num = (int) (Math.random() * calc) + min; //doing calculation to generate random number 
        
        System.out.println("Your random number between 10-15 is: " + num); //print out random number 
    }
    
}
