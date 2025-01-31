//Name: Ishaan Mittal 
//Date: 3 May 2024
//Assignment: Sorting Algorithms
//Purpose: To create 6 sorting algriothim
//Sources: 
//https://www.youtube.com/watch?v=EwjnF7rFLns
//https://www.geeksforgeeks.org/bubble-sort/
//https://www.geeksforgeeks.org/shellsort/
//https://www.geeksforgeeks.org/insertion-sort/
//https://www.geeksforgeeks.org/quick-sort/
//https://www.geeksforgeeks.org/gnome-sort-a-stupid-one/
package sixsorting;

import java.util.Scanner;

public class SixSorting {

    public static void main(String[] args) {
       
        
        int max = 1000; //declaring varibales (max and min) 
        int min = 1;
        int calc = max - min + 1; //finding range 
        int num;
        int list[];

        int choice;

        System.out.println("1) Get a list of 10 randoms doubles \n2) Get a list of 100 random doubles \n3) Get a list of 1000 random doubles"); //menu system
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Your choice: "); //takes user input on what they want to do
        choice = myScanner.nextInt();
        System.out.println("");

        if (choice == 1) {
            list = new int[10];  //initalzing list for the random numbers to be sorted 

            for (int i = 0; i < list.length; i++) { //saving random values into the list 
                num = (int) (Math.random() * calc) + min;  //finding a random number between 1 and 1000 
                list[i] = num; //saving number into the specific elemnt the for loop is iterating on 

            }
            choice = 0;

            System.out.println("Enter the algrothim you want to use: ");
            System.out.println("1) Selection Sort \n2) Quick Sort  \n3) Shell Sort \n4) Gnome Sort \n5) Bubble Sort \n6) Insertion Sort"); //menu system
            System.out.print("Your choice: "); //takes user input on what they want to do
            choice = myScanner.nextInt();

            if (choice == 1) {

                Sort array = new Sort(list); //creating object 
                System.out.print("Unsorted list: ");
                array.getArr(list);
                System.out.println("");
                System.out.print("Sorted list by Selection Sort: ");
                array.getArr(array.SelectionSort());
                System.out.println("");  //added for formatting 

                System.out.println("");  //added for formatting 
            } else if (choice == 2) {
                Sort array = new Sort(list); //creating object 
                System.out.print("Unsorted list: ");
                array.getArr(list);
                System.out.println("");
                System.out.print("Sorted list by Quick Sort: ");
                array.getArr(array.QuickSort());
                System.out.println("");  //added for formatting 

                System.out.println("");  //added for formatting 
            } else if (choice == 3) {
                Sort array = new Sort(list); //creating object 
                System.out.print("Unsorted list: ");
                array.getArr(list);
                System.out.println("");
                System.out.print("Sorted list by Shell Sort: ");
                array.getArr(array.ShellSort());
                System.out.println("");  //added for formatting 

                System.out.println("");  //added for formatting 
            } else if (choice == 4) {
                Sort array = new Sort(list); //creating object 
                System.out.print("Unsorted list: ");
                array.getArr(list);
                System.out.println("");
                System.out.print("Sorted list by Gnome Sort: ");
                array.getArr(array.GnomeSort());
                System.out.println("");  //added for formatting 

                System.out.println("");  //added for formatting 
            } else if (choice == 5) {
                Sort array = new Sort(list); //creating object 
                System.out.print("Unsorted list: ");
                array.getArr(list);
                System.out.println("");
                System.out.print("Sorted list by Bubble Sort: ");
                array.getArr(array.BubbleSort());
                System.out.println("");  //added for formatting 

                System.out.println("");  //added for formatting 
            } else if (choice == 6) {
                Sort array = new Sort(list); //creating object 
                System.out.print("Unsorted list: ");
                array.getArr(list);
                System.out.println("");
                System.out.print("Sorted list by Insertion Sort: ");
                array.getArr(array.InsertionSort());
                System.out.println("");  //added for formatting 

                System.out.println("");  //added for formatting 
            }

        } else if (choice == 2) {
            list = new int[100];  //initalzing list for the random numbers to be sorted 

            for (int i = 0; i < list.length; i++) { //saving random values into the list 
                num = (int) (Math.random() * calc) + min;  //finding a random number between 1 and 1000 
                list[i] = num; //saving number into the specific elemnt the for loop is iterating on 

            }
            choice = 0;

            System.out.println("Enter the algrothim you want to use: ");
            System.out.println("1) Selection Sort \n2) Quick Sort  \n3) Shell Sort \n4) Gnome Sort \n5) Bubble Sort \n6) Insertion Sort"); //menu system
            System.out.print("Your choice: "); //takes user input on what they want to do
            choice = myScanner.nextInt();

            if (choice == 1) {
                Sort array = new Sort(list); //creating object 
                System.out.print("Unsorted list: ");
                array.getArr(list);
                System.out.println("");
                System.out.print("Sorted list by Selection Sort: ");
                array.getArr(array.SelectionSort());
                System.out.println("");  //added for formatting 

                System.out.println("");  //added for formatting 
            } else if (choice == 2) {
                Sort array = new Sort(list); //creating object 
                System.out.print("Unsorted list: ");
                array.getArr(list);
                System.out.println("");
                System.out.print("Sorted list by Quick Sort: ");
                array.getArr(array.QuickSort());
                System.out.println("");  //added for formatting 

                System.out.println("");  //added for formatting 
            } else if (choice == 3) {
                Sort array = new Sort(list); //creating object 
                System.out.print("Unsorted list: ");
                array.getArr(list);
                System.out.println("");
                System.out.print("Sorted list by Shell Sort: ");
                array.getArr(array.ShellSort());
                System.out.println("");  //added for formatting 

                System.out.println("");  //added for formatting 
            } else if (choice == 4) {
                Sort array = new Sort(list); //creating object 
                System.out.print("Unsorted list: ");
                array.getArr(list);
                System.out.println("");
                System.out.print("Sorted list by Gnome Sort: ");
                array.getArr(array.GnomeSort());
                System.out.println("");  //added for formatting 

                System.out.println("");  //added for formatting 
            } else if (choice == 5) {
                Sort array = new Sort(list); //creating object 
                System.out.print("Unsorted list: ");
                array.getArr(list);
                System.out.println("");
                System.out.print("Sorted list by Bubble Sort: ");
                array.getArr(array.BubbleSort());
                System.out.println("");  //added for formatting 

                System.out.println("");  //added for formatting 
            } else if (choice == 6) {
                Sort array = new Sort(list); //creating object 
                System.out.print("Unsorted list: ");
                array.getArr(list);
                System.out.println("");
                System.out.print("Sorted list by Insertion Sort: ");
                array.getArr(array.InsertionSort());
                System.out.println("");  //added for formatting 

                System.out.println("");  //added for formatting 
            }

        } else {
            list = new int[1000];  //initalzing list for the random numbers to be sorted 

            for (int i = 0; i < list.length; i++) { //saving random values into the list 
                num = (int) (Math.random() * calc) + min;  //finding a random number between 1 and 1000 
                list[i] = num; //saving number into the specific elemnt the for loop is iterating on 

            }
            choice = 0;

            System.out.println("Enter the algrothim you want to use: ");
            System.out.println("1) Selection Sort \n2) Quick Sort  \n3) Shell Sort \n4) Gnome Sort \n5) Bubble Sort \n6) Insertion Sort"); //menu system
            System.out.print("Your choice: "); //takes user input on what they want to do
            choice = myScanner.nextInt();

            if (choice == 1) {
                Sort array = new Sort(list); //creating object 
                System.out.print("Unsorted list: ");
                array.getArr(list);
                System.out.println("");
                System.out.print("Sorted list by Selection Sort: ");
                array.getArr(array.SelectionSort());
                System.out.println("");  //added for formatting 

                System.out.println("");  //added for formatting 
            } else if (choice == 2) {
                Sort array = new Sort(list); //creating object 
                System.out.print("Unsorted list: ");
                array.getArr(list);
                System.out.println("");
                System.out.print("Sorted list by Quick Sort: ");
                array.getArr(array.QuickSort());
                System.out.println("");  //added for formatting 

                System.out.println("");  //added for formatting 
            } else if (choice == 3) {
                Sort array = new Sort(list); //creating object 
                System.out.print("Unsorted list: ");
                array.getArr(list);
                System.out.println("");
                System.out.print("Sorted list by Shell Sort: ");
                array.getArr(array.ShellSort());
                System.out.println("");  //added for formatting 

                System.out.println("");  //added for formatting 
            } else if (choice == 4) {
                Sort array = new Sort(list); //creating object 
                System.out.print("Unsorted list: ");
                array.getArr(list);
                System.out.println("");
                System.out.print("Sorted list by Gnome Sort: ");
                array.getArr(array.GnomeSort());
                System.out.println("");  //added for formatting 

                System.out.println("");  //added for formatting 
            } else if (choice == 5) {
                Sort array = new Sort(list); //creating object 
                System.out.print("Unsorted list: ");
                array.getArr(list);
                System.out.println("");
                System.out.print("Sorted list by Bubble Sort: ");
                array.getArr(array.BubbleSort());
                System.out.println("");  //added for formatting 

                System.out.println("");  //added for formatting 
            } else if (choice == 6) {
                Sort array = new Sort(list); //creating object 
                System.out.print("Unsorted list: ");
                array.getArr(list);
                System.out.println("");
                System.out.print("Sorted list by Insertion Sort: ");
                array.getArr(array.InsertionSort());
                System.out.println("");  //added for formatting 

                System.out.println("");  //added for formatting 
            }

        }

    }

}
