//Name: Ishaan Mittal 
//Date: 3 May 2024
//Assignment: Sorting Algorithms
//Purpose: To create 6 sorting algriothim

package sixsorting;

public class Sort {

    private int[] numList;  //saving instance varibles which in this case is the list of numbers 
    

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

    public int[] BubbleSort() {
        int i;
        int j;
        int temp;
        boolean swapped;

        for (i = 0; i < numList.length - 1; i++) {
            swapped = false;
            for (j = 0; j < numList.length - i - 1; j++) {
                if (numList[j] > numList[j + 1]) {

                    temp = numList[j];
                    numList[j] = numList[j + 1];
                    numList[j + 1] = temp;
                    swapped = true;
                }
            }
        }

        return numList;
    }

    public int[] ShellSort() {
        int n = numList.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
         
            for (int i = gap; i < n; i += 1) {
                
                int temp = numList[i];

                int j;
                for (j = i; j >= gap && numList[j - gap] > temp; j -= gap) {
                    numList[j] = numList[j - gap];
                }

    
                numList[j] = temp;
            }
        }

        return numList;
    }

    public int[] InsertionSort() {
        int n = numList.length;
        for (int i = 1; i < n; ++i) {
            int key = numList[i];
            int j = i - 1;

            while (j >= 0 && numList[j] > key) {
                numList[j + 1] = numList[j];
                j = j - 1;
            }
            numList[j + 1] = key;
        }

        return numList;
    }

    static void swapQuick(int[] numList, int i, int j) {
        int temp = numList[i];
        numList[i] = numList[j];
        numList[j] = temp;
    }

    static int partitionQuick(int[] numList, int low, int high) {
        int pivot = numList[high];

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (numList[j] < pivot) {

                i++;
                swapQuick(numList, i, j);
            }
        }
        swapQuick(numList, i + 1, high);
        return (i + 1);
    }

    static void changeQuick(int[] numList, int low, int high) {
        if (low < high) {

           
            int pi = partitionQuick(numList, low, high);

            
            changeQuick(numList, low, pi - 1);
            changeQuick(numList, pi + 1, high);
        }
    }

    public int[] QuickSort() {
        changeQuick(numList, 0, numList.length - 1);
        return numList;
    }

    public int[] GnomeSort() {
        int index = 0;

        while (index < numList.length) {
            if (index == 0) {
                index++;
            }
            if (numList[index] >= numList[index - 1]) {
                index++;
            } else {
                int temp = 0;
                temp = numList[index];
                numList[index] = numList[index - 1];
                numList[index - 1] = temp;
                index--;
            }
        }

        return numList;
    }

    public void getArr(int[] value) { //method used to just print the numListay
        for (int i = 0; i < value.length; i++) { //goes thourgh every element in the list and prints it 
            System.out.print(value[i] + " "); //printing element 
        }
    }

}
