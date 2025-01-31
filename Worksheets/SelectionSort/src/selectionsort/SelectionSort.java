//Name: Ishaan Mittal 
//Date: 25 Apr 2024
//Assignment: Sorting Algorithms
//Purpose: To create a selection sort algriothim

//Sources: 
//https://www.youtube.com/watch?v=EwjnF7rFLns
//https://www.geeksforgeeks.org/bubble-sort/
//https://www.geeksforgeeks.org/shellsort/
//https://www.geeksforgeeks.org/insertion-sort/
//https://www.geeksforgeeks.org/quick-sort/
//https://www.geeksforgeeks.org/gnome-sort-a-stupid-one/

package selectionsort;

public class SelectionSort {

    public static void main(String[] args) {
        int max = 1000; //declaring varibales (max and min) 
        int min = 1; 
        int calc = max - min + 1; //finding range 
        int num;
        
        int[] list = new int[100];  //initalzing list for the random numbers to be sorted 

        for (int i = 0; i < list.length; i++) { //saving random values into the list 
            num = (int) (Math.random() * calc) + min;  //finding a random number between 1 and 1000 
            list[i] = num; //saving number into the specific elemnt the for loop is iterating on 
            
        }
        
        Sort array = new Sort(list); //creating object 
        array.getArr(array.SelectionSort()); 
        System.out.println("");  //added for formatting 
        
        
        System.out.println("");  //added for formatting 

    }
    
}
