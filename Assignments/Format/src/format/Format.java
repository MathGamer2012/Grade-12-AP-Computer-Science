/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package format;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Format {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice;
        double quantity; 
        double price; 
                
        while (true) {
            System.out.println("Welcome to BooleanByte! \nPlease enter a value from 1-6: ");
            System.out.println("1) Purchase Books \n2) Purchase Movies \n3) Purchase Peanuts \n4) Apply for Promo Code \n5) Apply for Discount \n6) Checkout");
            Scanner myScanner = new Scanner(System.in);
            System.out.print("Your choice: ");
            choice = myScanner.nextInt();
            
            if (choice == 1) {
                
                System.out.println("Which type of book would you like to purchase?");
                System.out.println("1) Hardcover ($3.65) \n2) Softcover ($2.35) \n3 Ebook ($1.24)");
                System.out.print("Your choice: ");
                choice = myScanner.nextInt(); 
                
                if (choice == 1) {
                    System.out.print("Enter the number of books you want to purchase: "); 
                    quantity = myScanner.nextDouble(); 
                    price = 3.65;
                    Store book = new Store("Book", quantity, price); 
                }
                
                else if (choice == 2) {
                    System.out.print("Enter the number of books you want to purchase: "); 
                    quantity = myScanner.nextDouble(); 
                    price = 2.35;
                    Store book = new Store("Book", quantity, price); 
                }
                
                else {
                    System.out.print("Enter the number of books you want to purchase: "); 
                    quantity = myScanner.nextDouble(); 
                    price = 1.24;
                    Store book = new Store("Book", quantity, price); 
                }
            }
            
            
            if (choice == 6) {
                break;
            }
        
        }
        
        
        //Make sure to make this in a class as format and then take the parameter values for the quantties and stuff 
        
        System.out.println("**********************************************************************************************************************************************************************************************************");
        System.out.println("\n \t \t \t \t \t \t \t \t \t \t \t [BooleanByte]");
        System.out.println("\t \t \t \t \t \t \t \t \t \t       123 Soldering Rd.");
        System.out.println("\t \t \t \t \t \t \t \t \t \t     Milton, Ontario L9T8G4");
        System.out.println("\t \t \t \t \t \t \t \t \t \t \t 647-123-4567 \n");
        System.out.println("==========================================================================================================================================================================================================");
        System.out.println("Time: 5:01 pm \t \t  \t \t \t \t \t  \t \t \t \t \t  \t \t \t \t \t  \t \t \t        Register# 12"); 
        System.out.println("Date: 14/03/24 \t \t  \t \t \t \t \t  \t \t \t \t \t  \t \t \t \t \t  \t \t \t        Cashier: Ishaan Mittal");
        System.out.println("==========================================================================================================================================================================================================");
        System.out.println("Quantity: " + "\t \t Product Name: " + "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t      Price:"); 
        System.out.println(" 3.00 " + "\t \t \t   Books " + "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t      $3.00");
        System.out.println(" 8.00 " + "\t \t \t   Movies " + "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t      $4.00");
        System.out.println(" 4.23 " + "\t \t \t   Peanutes (lbs.) " + "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t      $5.00");
        System.out.println("==========================================================================================================================================================================================================");
        System.out.println("\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t   SUBTOTAL:  $6.00");
        System.out.println("\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t      TAX:    $0.70");
        System.out.println("==========================================================================================================================================================================================================");
        System.out.println("\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t     TOTAL:   $6.70");
        System.out.println("==========================================================================================================================================================================================================");
        System.out.println("\n \t \t \t \t \t \t \t \t \t     Thank you for shopping with [BooleanByte]!");
        System.out.println("\t \t \t \t \t \t \t \t \t \t        HAVE A GREAT DAY! \n");
        System.out.println("**********************************************************************************************************************************************************************************************************");


        
    }
    
}
