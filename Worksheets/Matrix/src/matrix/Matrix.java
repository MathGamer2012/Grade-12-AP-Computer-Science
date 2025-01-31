//Name: Ishaan Mittal
//Date: 26th May 2024
//Assignment: Matrix - 2D Arrays
//Purpose: To create a program that is able to perform matrix multiplication 

//Extra sources used: https://www.youtube.com/watch?v=kuixY2bCc_0 (used for logic of the code itself) 

package matrix;

public class Matrix {

    public static void main(String[] args) {
        Multiplier matrix = new Multiplier(); //creating object of Multiplier class to get access to methods 
        matrix.getDimensions();  //calling a list of methods to generate the final matrix as the product of matrix 1 and matrix 2 
        matrix.setMatrix(); 
        matrix.setFinalMat();
        matrix.printMatrix();
    }
    
}
