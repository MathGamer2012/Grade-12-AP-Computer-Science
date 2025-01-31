//Name: Ishaan Mittal
//Date: 26th May 2024
//Assignment: Matrix - 2D Arrays
//Purpose: To create a program that is able to perform matrix multiplication

//Extra sources used: https://www.youtube.com/watch?v=kuixY2bCc_0 (used for logic of the code itself) 

package matrix;

import java.util.Scanner; //importing libraries for specific function in the program 
import java.util.ArrayList;


public class Multiplier {

    private int row1; //declaring instance varibales for the rows and columns in the matrices 
    private int row2;
    private int col1;
    private int col2;

    private int[][] mat1; //declaring the matrices 
    private int[][] mat2;
    private int[][] mat3;

    private ArrayList<Integer> numbers = new ArrayList<Integer>();  //used to store all the values extracted 
    private ArrayList<Integer> sum = new ArrayList<Integer>(); //used to store the sum of the values extracted as show in video 

    public Multiplier() { //default contructor 

    }

    public void getDimensions() { //method used to get dimension (accessor method) 
        Scanner myScanner = new Scanner(System.in); //creating scanner to get user input
        System.out.print("Enter the number of rows the in first matrix: "); //gets user input on the values needed to make the 2 matrices 
        row1 = myScanner.nextInt(); //saving user input into the resptive instance varibale 

        System.out.print("Enter the number of columns in the first matrix: "); //same logic as before 
        col1 = myScanner.nextInt();

        System.out.print("Enter the number of row in the second matrix: "); //same logic as before 
        row2 = myScanner.nextInt();

        System.out.print("Enter the number of columns in the second matrix: "); //same logic as before 
        col2 = myScanner.nextInt();

        if (col1 != row2) { //used to check an error in user input, as stated by the video the columns of the first matrix cannot equal the rows of the second matrix as otherwise the multiplcation does not work as intended 
            System.out.println("\n" + "Invalid values entered! Try again! Note: columns of the first matrix cannot be the same as rows of the second matrix" + "\n"); //informs user of mistake 
            getDimensions(); //using recursive apporach to call the accessor again to get new values that are valid 
        }

    }
    public void setMatrix() { //method used to create the 2 matrices based on user input of rows and columns (mutator method) 
        mat1 = new int[row1][col1]; //initlazing the matrices based on user input 
        mat2 = new int[row2][col2];
        mat3 = new int[row1][col2]; //this matrix is for the final input and according to video has the same rows as the first matrix and the same columns as the seoncd 

        System.out.println("Matrix #1: "); 
        for (int i = 0; i < mat1.length; i++) { //traversing thourgh 2d array as was taugh in the AP classroom lesson 
            for (int j = 0; j < mat1[0].length; j++) {
                int num = (int) (Math.random() * 10) + 1; //generating a random value between (1-10) inclsuive for each number in the matrix 
                mat1[i][j] = num; //setting the random number into the matrix 
                System.out.print(mat1[i][j] + "\t"); //printing 2D array values  
            }
            System.out.println(""); //used for format so it actually looks lke a matrix 
        }

        System.out.println("Matrix #2: "); 
        for (int i = 0; i < mat2.length; i++) { //same logic as before 
            for (int j = 0; j < mat2[0].length; j++) {
                int num = (int) (Math.random() * 10) + 1;
                mat2[i][j] = num;
                System.out.print(mat2[i][j] + "\t");
            }
            System.out.println("");
        } 
    }

    public void setFinalMat() { //method used to generate the final matrix that will be outputted to the user (mutator method) 
        int value = 0; //used to find the sum between the numbers 
        int counter = 0; //couter is used for the addition as the numbers are added every nth value of the second row 
        int counter2 = 0; //counter is used for the index of the arraylist containing the sum of the numbers in the numbers arraylist 

        for (int i = 0; i < mat1.length; i++) { //row #1
            for (int j = 0; j < mat2[0].length; j++) { //col #2 
                for (int l = 0; l < mat1[0].length; l++) { //col #1
                    for (int k = 0; k < mat2.length; k++) {//row #2 
                        if (k == l) { //checks if the index of row in second matrix is equal to the column of the first matrix as that is how the multiplcation occurs as stated in video
                            numbers.add(mat1[i][l] * mat2[k][j]); //adds the product of the numbers to the number arraylist 
                            //Note: the reason arrayList is used is bc it can resize compared to an array which remains the same size no matter what 
                            //Note: the way the nested for loop works is based on the order of operations according to matrix multiplcation, this is becuase the most active values that are changing are row #2 and col#1 which is why they are in the inner loop, then the second most active value changing is col#2 which is why it comes after row #2 and col#1. Finally, row #1 is the least chaning/'moving' value which is why it is at the most outward position in the nested for loops 
                        }
                    }

                }
            }
        }
        for (int i = 0; i < numbers.size(); i++) { //goes through every element in the number arraylist 
            value += numbers.get(i); //adds onto value (aka taking the sum) 
            counter++; //counter increments and is used to check a condition 

            if (counter == row2) { //once the counter is equal to the number of row2 then the following conditions occur, this is becuase as stated in the video the total sum is taken once the nth term reachs the value of row#2
                sum.add(value); //adds the sum to the sum arraylist 
                value = 0; //sets value to 0, to find the sum of the next nth sum of row#2
                counter = 0;//sets counter to 0, for same reasom insribed above 
            }
        }

        for (int j = 0; j < mat3.length; j++) { //traversing thorugh 2D array
            for (int k = 0; k < mat3[0].length; k++) {
                mat3[j][k] = sum.get(counter2); //saves all the values from sum into the new matrix which is to be displayed 
                counter2++;//counter used to prevent index out of bonds error 
            }
        }
    }

    public void printMatrix() { //method used to print the final matrix 
        System.out.println("Final Matrix: "); 
        for (int i = 0; i < mat3.length; i++) { //traversing thourgh matrix 
            for (int j = 0; j < mat3[0].length; j++) {
                System.out.print(mat3[i][j] + "\t"); //printing each element 
            }
            System.out.println(""); //mainting format so the output looks like a matrix rather than single line 
        }

    }
}