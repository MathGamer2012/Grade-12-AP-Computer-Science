/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package numrolls;

//Name: Ishaan Mittal 
//Date: 23 Feb 2024 
//Assignment: Random Worksheet 
//Purpose: To see how many rolls it takes to get 3 

public class NumRolls {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("The number of rolls it took you to get to the number 3 is: " + numRoll());
    }
    
    public static int numRoll() {
        int max = 6; //declaring varibales (max and min) 
        int min = 1; 
        int calc = max - min + 1; //finding range 
        int check  = 0; 
        
        while (true) {
            int num = (int) (Math.random() * calc) + min; //doing calculation to generate random number
            check++; //adding until 3 is rolled 
            
            if (num == 3) {
                return check; 
            }
                                  
        }
                   
    }
    
}
