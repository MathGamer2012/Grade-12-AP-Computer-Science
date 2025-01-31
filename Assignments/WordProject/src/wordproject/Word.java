package wordproject;

//Name: Ishaan Mittal 
//Date: 4th March 2024
//Assignment: WordProject 
//Purpose: To create a class that can manipulate the string 

public class Word { //Word class 
    
    private String myWord; //instance variable
    
    public Word()
    {
        myWord = "";
    }
    public Word(String word) //sets userinput of word and saves it into the instance varibale
    {
        myWord = word;
    }
    public String getWord() //returns the value of the instance varibale
    {
        return myWord;
    }
    public String getFirstLetter() //finds the first letter of the word
    {
        return myWord.substring(0, 1);
    }
    public String getLastLetter() //finds the last letter of the word 
    {
        return myWord.substring(myWord.length() - 1, myWord.length()); //I compare the 2nd last letter and last letter as the first value is not inclusive only the last letter would be returned
    }
    public void removeFirstLetter() //removes the first letter
    {
        String alter = myWord.substring(0, 1);  //finds the first letter of the word         
        myWord = myWord.replace(alter, "");  //replaces the first letter with an empty string (same as deleting it)         
    }
    public void removeLastLetter() //removes the last letter 
    {
        String alter = myWord.substring(myWord.length() - 1, myWord.length()); //finds last letter same as above (getlastletter) 
        myWord = myWord.replace(alter, ""); //replaces last letter with an empty string (same as deleting it) 
    }
    public int findLetter(String stringToFind) //finds if the user inputted letter is in the word 
    {
        return myWord.indexOf(stringToFind); // returns the index of letter if it is in the word and if not it returns -1. 
    }
    
}

//Extra Sources used: 
//https://www.digitalocean.com/community/tutorials/java-remove-character-string (This was used for the replace method I used) 