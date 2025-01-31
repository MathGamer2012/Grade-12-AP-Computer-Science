package wordproject;

//Name: Ishaan Mittal 
//Date: 4th March 2024
//Assignment: WordProject 
//Purpose: To create a class that can manipulate the string 

import java.util.Scanner; //imports scanner so it can be used

public class WordProject {

    public static void main(String[] args) {      
        Scanner keyboard = new Scanner(System.in); //creats scanner to read user input 
        System.out.print("Enter a word: "); //asks the user to enter a word 
        String userInput = keyboard.next(); //reads the userinput and saves it into userInput 
        Word word1 = new Word(userInput); //creates an object 
        System.out.println("You entered the word: " + word1.getWord()); //retruns what the word the user entered 
        System.out.println("The first letter of your word is: " + word1.getFirstLetter()); //returns the first letter of the word 
        System.out.println("The last letter of your word is: " + word1.getLastLetter()); //returns the last letter of the word 
        word1.removeFirstLetter(); //removes the first letter
        System.out.println("The word without the first letter is: " + word1.getWord()); //shows the updated word with the first letter removed 
        word1.removeLastLetter(); //removes the last letter 
        System.out.println("The word without the last letter is: " + word1.getWord()); //shows the updated word with the last letter removed 
        System.out.print("Enter a letter to find: "); //Asks user which letter they want to find in the word 
        String letter = keyboard.next(); //Reads and saves userinput into letter 
        System.out.println("The index of the letter " + letter + " is " + word1.findLetter(letter)); //prints the index of the letter in the word if it is found, however if it is not it returns -1. 
    }
}

//Extra Sources used: 
//https://www.digitalocean.com/community/tutorials/java-remove-character-string (This was used for the replace method I used) 