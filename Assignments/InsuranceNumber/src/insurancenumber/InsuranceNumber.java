//Name: Ishaan Mittal 
//Date: 13 Feb 2024 
//Assignment: Canadian Social Insurance Number 
//Purpose: To create a program that is able to verify if the given Insurance number is legit or not

//Overall process of the code: 
//Essentially with this program what I do is take userinput as a string then split that string into a char array 
//After making it a char erray I save the values into a string array by taking the "String.Valueof(datatype)" so I can convert the char into a string 
//The reason I do this is becuase within this program I have to look at every single number within the soical insurance number as I have to do multiplication and addition at times 
//After making the string array I parse the array into an int and save it to an integer array as I need to use this data type to perform any calculation 
//In addition instead of making the number 121212121 into a list of integer with indivudal numbers in each I did the same prcoess as the user input becuase I did not want to write all that just to make a list 
//Carrying on, after creating the intger list I looked at each elemnt in the list and checked if the number was ever greater than 10 which would mean it is a double digit and requires extra calculations as state in the website 
//As a result, I followed the same prcoess as before as the calculated number was a double digit I would have to look at each indivudal number and add it, which is why I again converted it into a char array, then string, then integer and then added the 2 values 
//After this addition I saved it into the valid array which would contain all the numbers after the calucations 
//I also set an else statment which would just multiply the numbers and declare that value into the specific element for the valid array 
//In the end I go trhough every elemnt within the valid array and add the sum to the varaible FinalNum which I check if it is divisible by 10
//If it is, the program returns the valid statment and if not it returns the invalid statment 
//In addition the first if statment is to check if the user typed the correct number of values for their number and if not returns invalid 
 
package insurancenumber;

import java.util.Scanner; //Importing the Scanner class to get user input

public class InsuranceNumber {

    public static void main(String[] args) {
        String insuranceNum; // declaring varibales 
        int calculated;
        String convert;
        String multiplier = "121212121";
        int calculated2;
        int finalNum = 0;
        char[] multiplierArr = multiplier.toCharArray(); //converting multipler string into char array 
        char[] insuranceNumArr; //declaring/initzaling arrays 
        String[] arr1 = new String[9];
        String[] arr2 = new String[9];
        int[] arr3 = new int[9];
        int[] arr4 = new int[9];
        char[] convertArr;
        String[] arr5 = new String[2];
        int[] arr6 = new int[2];
        int[] valid = new int[9];

        Scanner input = new Scanner(System.in); // Creats a scanner for userinput 
        System.out.print("Enter your Canadian Social Insurance Number: "); //asking for userinput 
        insuranceNum = input.nextLine();
        insuranceNumArr = insuranceNum.toCharArray();//saving userinput into char array 

        if (insuranceNum.length() == 9) { //checking if user inputs invalid number 
            for (int i = 0; i < multiplier.length(); i++) { //going thorugh each elemnt in userinput as a string is a list of chars 
                arr1[i] = String.valueOf(insuranceNumArr[i]); //saving the user's insurance number as a string array 
                arr2[i] = String.valueOf(multiplierArr[i]); //saving the multiplying value as a string array 
            }

            for (int i = 0; i < multiplier.length(); i++) { //going trhoguh each element in array 
                arr3[i] = Integer.parseInt(arr1[i]); //saving the string array for insurance number into integer array for calculations
                arr4[i] = Integer.parseInt(arr2[i]); //saving the string array for multplying value into integer array for calculations 

                calculated = arr3[i] * arr4[i];//multiplying the values from the insurance number and the multipler as stated in the document given

                if (calculated >= 10) { //checks if the product is a double digit 
                    convert = String.valueOf(calculated); //converts cacluated into a string to look at each digit 
                    convertArr = convert.toCharArray();//converts the string into a char array again to look at each digit 

                    for (int j = 0; j < 2; j++) {
                        arr5[j] = String.valueOf(convertArr[j]); //saves char array into string array 
                        arr6[j] = Integer.parseInt(arr5[j]); //saves string array into integer array so now that the digits are seperated for example if the product was 18, it would be seperated as 1 and 8 
                    }

                    calculated2 = arr6[0] + arr6[1]; //adding the indivudal digits, for example if the number was 18 it would add 1 + 8 
                    valid[i] = calculated2; //saving the calulcated value into the array for the final number after the calcutions 

                } else {
                    valid[i] = calculated; //if the product is not a double digit it just saves the product into the final number array without doing the extra calcualtions as stated in the document 
                }

            }

            for (int i = 0; i < valid.length; i++) { //goes thorugh every elemnt in the final number array 
                finalNum += valid[i]; //takes the sum of all the numbers in the valid array 
            }

            if (finalNum % 10 == 0) { //checks if it is divisble by 10 
                System.out.println("This is a valid Social Insurance Number"); //returns valid statment 
            } else { //if the number is not divisblie by 10 
                System.out.println("This is not a valid Social Insurance Number");//returns invalid statment 

            }
        }
        
        else {
            System.out.println("Invalid number"); // to check if the number was invalid to begin with 
        }
    }

}

//External soruces used(apart from notes): 
//Calculation: chrome-extension://efaidnbmnnnibpcajpcglclefindmkaj/https://www.straightlineinternational.com/docs/vaildating_canadian_sin.pdf
//.Valueof Method: https://www.w3schools.com/jsref/jsref_valueof_string.asp
//.toCharArray Method: https://www.geeksforgeeks.org/java-string-tochararray-example/
//Arrays: https://www.w3schools.com/java/java_arrays.asp
//.parseInt() Method: https://www.tutorialspoint.com/java/number_parseint.htm