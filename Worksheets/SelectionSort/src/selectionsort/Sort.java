//Name: Ishaan Mittal 
//Date: 25 Apr 2024
//Assignment: Sorting Algorithms
//Purpose: To create a selection sort algriothim
package selectionsort;

public class Sort { //main class

    private int[] numList = new int[100];  //saving instance varibles which in this case is the list of numbers 
    int low = 0;
    int high = numList.length - 1;

    public Sort() { //main class

    }

    public Sort(int[] value) {
        numList = value; //saving list from main to the one in this class 
    }

    public int[] SelectionSort() { //method is responible for sorting the numbers from largest to smallest 

        for (int i = 0; i < numList.length - 1; i++) { //iterates to every elemnt except the last one as there are two numbers being comapred thus the nested for loop
            int min = i; //saving the first value in the list as the minmum value (the smallest value), will change after though
            for (int j = i + 1; j < numList.length; j++) { //going through every element in the list ignoring the first element as that was done by previous for loop 
                if (numList[min] > numList[j]) { //checks if the next number is less than the previous 
                    min = j; //if it is it changes it to the min number 
                }
            }

            int temp = numList[i]; //saves the first number into the temporary varibale 
            numList[i] = numList[min];  //changes the first number to the min number
            numList[min] = temp; //changes the min number to the temporary number saved 

            //essentially, it keeps on saving the largest number at the front then sorts to the rest keeping the number that came before in the temporary varibale for it to be compared later 
        }
        return numList; //returns sorted list
    }

    public void getArr(int[] value) { //method used to just print the numListay
        for (int i = 0; i < value.length; i++) { //goes thourgh every element in the list and prints it 
            System.out.print(value[i] + " "); //printing element 
        }
    }

}
