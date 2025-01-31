/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package probability2;

//Name: Ishaan Mittal 
//Date: 23 Feb 2024 
//Assignment: Random Worksheet 
//Purpose: To make a program that output true or false

public class Probability2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(flipCoin());
    }
    
    static boolean flipCoin() {
        int max = 2; //declaring varibales (max and min) 
        int min = 1; 
        int calc = max - min + 1; //finding range 
        int num = (int) (Math.random() * calc) + min; //doing calculation to generate random number
        
        if (num == 1) {
            return true;   
        }
        
        else {
            return false;
        } 
        
    }
    
}
