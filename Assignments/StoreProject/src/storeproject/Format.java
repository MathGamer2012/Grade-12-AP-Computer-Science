//Name: Ishaan Mittal 
//Date: 26/03/2024 
//Assignment: Store Project
//Purpose: To create a class to make the receipt  

package storeproject;

import java.text.DateFormat; //imporing libraries for code
import java.text.SimpleDateFormat;
import java.util.Date;

public class Format{    
    private String dateString;  //declaring instance varibales 
    private String dateString2; 
    private int num;
    private int quantityBook; 
    private int quantityMovie; 
    private double quantityPeanut;
    private double bookSubTotal;
    private double movieSubTotal;
    private double peanutSubTotal;
    private double subTotal;
    private double sale;
    private double tax;
    private double ship;
    private double taxTotal;
    
    public Format(int val, int val2, double val3, double val4, double val5, double val6, double val7, double val8, double val9, double val10, double val11)  { ////takes in user input of the object and saves it into variables
        quantityBook = val;  //updating instace varibales   
        quantityMovie = val2;
        quantityPeanut = val3;
        bookSubTotal = val4;
        movieSubTotal = val5;
        peanutSubTotal = val6;
        subTotal = val7;
        sale = val8;
        tax = val9;
        ship = val10;
        taxTotal = val11;
    }
    
    public void getCashNum() { //mutator method, generates a random number between 1-15 for cahser number
        int max = 15; //declaring varibales (max and min) 
        int min = 1;
        int calc = max - min + 1; //finding range 
        num = (int) (Math.random() * calc) + min; 
    }
    
    public void getDate() {  //mutator method, genreats the current date and time             
        DateFormat dateFormat = new SimpleDateFormat("hh:mm aa");
    	dateString = dateFormat.format(new Date()); //for current time 
        
        DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
    	dateString2 = dateFormat2.format(new Date()); //for current date
        
        //Note: previous code is from the website I mentioned within the works cited
    }
    
    public void getFormat(){ //prints the receipt
        System.out.println("**********************************************************************************************************************************************************************************************************");
        System.out.println("\n \t \t \t \t \t \t \t \t \t \t \t [BooleanByte]");
        System.out.println("\t \t \t \t \t \t \t \t \t \t       123 Soldering Rd.");
        System.out.println("\t \t \t \t \t \t \t \t \t \t     Milton, Ontario L9T8G4");
        System.out.println("\t \t \t \t \t \t \t \t \t \t \t 647-123-4567 \n");
        System.out.println("==========================================================================================================================================================================================================");
        System.out.println("Time: "+ dateString + "\t \t  \t \t \t \t \t  \t \t \t \t \t  \t \t \t \t \t  \t \t         Register# " + num); 
        System.out.println("Date: "+ dateString2 + "\t \t  \t \t \t \t \t  \t \t \t \t \t  \t \t \t \t \t  \t \t         Cashier: Ishaan Mittal");
        System.out.println("==========================================================================================================================================================================================================");
        System.out.println("Quantity: " + "\t \t Product Name: " + "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t      Price:"); 
        System.out.println(" " + quantityBook +" " + "\t \t \t   Books " + "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t      $" + String.format("%.2f", bookSubTotal));
        System.out.println(" " + quantityMovie +" " + "\t \t \t   Movies " + "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t      $" + String.format("%.2f", movieSubTotal));
        System.out.println(" " + String.format("%.2f", quantityPeanut) +" " + "\t \t \t   Peanutes (lbs.) " + "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t      $" + String.format("%.2f", peanutSubTotal));
        System.out.println("==========================================================================================================================================================================================================");
        System.out.println("\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t   SUBTOTAL:  $" + String.format("%.2f", subTotal));
        System.out.println("\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t   DISCOUNT:  $" + String.format("%.2f", sale));
        System.out.println("\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t        TAX:  $" + String.format("%.2f", tax));
        System.out.println("\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t   SHIPPING:  $" + String.format("%.2f", ship));
        System.out.println("==========================================================================================================================================================================================================");
        System.out.println("\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t     TOTAL:   $" + String.format("%.2f", taxTotal));
        System.out.println("==========================================================================================================================================================================================================");
        System.out.println("\n \t \t \t \t \t \t \t \t \t     Thank you for shopping with [BooleanByte]!");
        System.out.println("\t \t \t \t \t \t \t \t \t \t        HAVE A GREAT DAY! \n");
        System.out.println("**********************************************************************************************************************************************************************************************************");
    } 
    
    

}
