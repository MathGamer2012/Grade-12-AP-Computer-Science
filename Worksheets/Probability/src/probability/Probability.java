/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package probability;

//Name: Ishaan Mittal 
//Date: 23 Feb 2024 
//Assignment: Random Worksheet 
//Purpose: To make a program that outputs letters based on specific probabilities 

public class Probability {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String letter = "A";  //declaring variables 
        String letter2 = "B";
        String letter3 = "C";
        
        boolean check = false;
        boolean check2 = false; 
        boolean check3 = false; 

        int max = 3; //declaring varibales (max and min) 
        int min = 1; 
        int calc = max - min + 1; //finding range 
                
        while (true) { //making a while loop for the probablity process 
            int num = (int) (Math.random() * calc) + min; //making muntiple random numbers between 1 and 3 until while loop ends 
            if (num == 1 && check == false) { //printing out A once, I change check to true so it doesn't print A again as it is possible the random number can be 1 again 
                System.out.println(letter);
                check = true;
            }
            
            else if (num == 2 && check2 == false) { //printing out B twice, I change check2 to true so it doesn't print B again as it is possible the random number can be 2 again
                for (int i = 0; i < 2; i++) {
                    System.out.println(letter2);
                    check2 = true;
                }
            }
            
            else if (num == 3 && check3 == false) { //printing out C sevent times, I change check3 to true so it doesn't print C again as it is possible the random number can be 3 again
                for (int j = 0; j < 7; j++) {
                    System.out.println(letter3);
                    check3 = true;
                }
            }
            
            if (check == true && check2 == true && check3 == true) { //ends the loop once all the outputs are finished (7 Cs, 2 Bs, 1 As) (70%, 20%, 10%) 
                break; 
            }
        }
        
    }
    
}
