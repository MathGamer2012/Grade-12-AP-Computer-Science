/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

//Name: Ishaan Mittal 
//Date: 23 Feb 2024 
//Assignment: Random Worksheet 
//Purpose: To generate a random number between 1 and 6 (incluvsive) 

package random.pkg1.pkg6;


public class Random16 {

    public static void main(String[] args) {
        int max = 6; //declaring varibales (max and min) 
        int min = 1; 
        int calc = max - min + 1; //finding range 
        int num = (int) (Math.random() * calc) + min; //doing calculation to generate random number between 1 and 6 (inclusive. The logic is that the random number is mutliplied by the range + 1 and then the minimum value is added. This is done becuase the Math.Random will output a number between 0 and 1 but not inclusive of 1 meaning all the numbers in this case would be less than 6 origniall but then after the plus one they would be 6. a decimal valuye which is why the number is turned into an int so only the whole number value is taken and not the rounded value 
        
        System.out.println("Your random number between 1-6 is: " + num); //print out random number   
        
        
        /* else if (checker > 1) {
                            multi[counter3 + 1] = joe.substring(secondIndex + 1);
                            System.out.println("Hi8: " + multi[counter3 + 1]);
                            last3 = true; 
                            break; 
                            while (last3 != true) {
                                for (int h = secondIndex; h < joe.length(); h++) {
                                    if (input[h] == 's' && last3 != true) {
                                        multi[counter3 + 2] = joe.substring(secondIndex + 1, joe.indexOf(input[h]));
                                        System.out.println("Hi6: " + multi[counter3 + 2]);
                                        last3 = true;
                                        break;
                                    } else if (input[h] == '/' && last3 != true) {
                                        multi[counter3 + 2] = joe.substring(secondIndex + 1, joe.indexOf(input[h]));
                                        System.out.println("Hi7: " + multi[counter3 + 2]);
                                        last3 = true;
                                        break;
                                    } else if (input[h] == '^'&& last3 != true) {
                                        multi[counter3 + 2] = joe.substring(secondIndex + 1, joe.indexOf(input[h]));
                                        System.out.println("Hi82: " + multi[counter3 + 2]);
                                        last3 = true;
                                        break;
                                    } else if (input[h] == '+'&& last3 != true) {
                                        multi[counter3 + 2] = joe.substring(secondIndex + 1, joe.indexOf(input[h]));
                                        System.out.println("Hi9: " + multi[counter3 + 2]);
                                        last3 = true;
                                        break;
                                    } else if (input[h] == '-'&& last3 != true) {
                                        multi[counter3 + 2] = joe.substring(secondIndex + 1, joe.indexOf(input[h]));
                                        System.out.println("Hi10: " + multi[counter3 + 2]);
                                        last3 = true;
                                        break;
                                    }
                                    
                                    
                                    
                                    
                                    
                                    
                                } 
                            } 

                        } */  
    }
    
}
