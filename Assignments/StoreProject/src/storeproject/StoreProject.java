//Name: Ishaan Mittal 
//Date: 26/03/2024 
//Assignment: Store Project
//Purpose: To create a store simulation 

//Works Cited: 
// String.Format: https://www.hackingwithswift.com/example-code/strings/how-to-specify-floating-point-precision-in-a-string
//Nextint/Nextdouble: https://www.javatpoint.com/post/java-scanner-nextint-method
//Time: https://beginnersbook.com/2017/10/java-display-time-in-12-hour-format-with-ampm/#:~:text=Display%20current%20date%20and%20time,hour%20format%20with%20AM%2FPM.&text=aa%20%E2%80%93%20AM%2FPM%20marker.

//Upgrades & Debugging 
//Menu system was added 
//Multiple classes were added, one more calculations, the other for output 
//Lottery system was added inorder to get a discount
//Bug: Fixed glitch where user could infintly get discounts 
//Bug: Fixed logic error with the scope of certain variables 
//Added multiple options to choose for (submenus) for items
//Added external shipping costs
//Bug: Fixed rounding, instead of outputting a crazy decimal number the number is rounded to the nearest hundreth or penny
//Added Time and Date
//Added comments for explnation


package storeproject;

import java.util.Scanner; //for user input

public class StoreProject {

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE - 1);
        int choice;  //declaring varibales 
        int quantityBook = 0; 
        int quantityMovie = 0; 
        double quantityPeanut = 0.00;
        double priceBook = 0.00;
        double priceMovie = 0.00;
        double pricePeanut = 0.00;
                
        
        double bookSubTotal = 0.00;         
        double movieSubTotal = 0.00; 
        double peanutSubTotal = 0.00; 
        
        double subTotal = 0.00;
        double tax = 0.00; 
        double taxTotal = 0.00;
        
        double discount = 0.00; 
        
        boolean correct; 
        double ship = 0.00;
        double sale = 0.00;
        int guess; 
        
        int counter = 0; 
              
     
        System.out.println("Welcome to BooleanByte! \nPlease enter a value from 1-5: "); //prompts the user about the store Name and what to do 

        while (true) { //repeats until the user picks option 5 (which has a break; in it) 
            System.out.println("1) Purchase Books \n2) Purchase Movies \n3) Purchase Peanuts \n4) Apply for Discount \n5) Checkout"); //menu system
            Scanner myScanner = new Scanner(System.in);
            System.out.print("Your choice: "); //takes user input on what they want to do
            choice = myScanner.nextInt();
            
            if (choice == 1) { //checking what option was selected 
                
                System.out.println("\nWhich type of book would you like to purchase?"); //submenu for books 
                System.out.println("\n1) Hardcover ($3.65) \n2) Softcover ($2.35) \n3) Ebook ($1.24)\n"); //outputting different types of books 
                System.out.print("Your choice: ");
                choice = myScanner.nextInt(); //takes user input on what they want 
                
                if (choice == 1) { //checking option selected 
                    System.out.print("Enter the number of books you want to purchase: "); //asking for quantity
                    quantityBook += myScanner.nextDouble(); 
                    priceBook += 3.65; //price for this type of book
                    Store book = new Store("Book", quantityBook, priceBook);  //saving user input into object
                    bookSubTotal += book.getPrice(); //getting subtotal (price x quanitiy) 
                    System.out.println("Added to your Checkout!\n"); //telling user that the data has been updated
                    choice = 0;  //sets choice to 0 so mixup does not occur within the menu system 
                }
                
                else if (choice == 2) { //same comments as above 
                    System.out.print("Enter the number of books you want to purchase: "); 
                    quantityBook += myScanner.nextDouble(); 
                    priceBook += 2.35;
                    Store book = new Store("Book", quantityBook, priceBook); 
                    bookSubTotal += book.getPrice(); 
                    System.out.println("Added to your Checkout!\n");
                    choice = 0; 
                }
                
                else { //same comments as before 
                    System.out.print("Enter the number of books you want to purchase: "); 
                    quantityBook += myScanner.nextDouble(); 
                    priceBook += 1.24;
                    Store book = new Store("Book", quantityBook, priceBook);
                    bookSubTotal += book.getPrice(); 
                    System.out.println("Added to your Checkout!\n");
                    choice = 0; 
                }
            }
            
            
            if (choice == 2) {
                //similar comments as before just for movie instead of book (creating a new object for movie) 
                System.out.println("\nWhich type of movie would you like to purchase?");
                System.out.println("\n1) Romance ($5.65) \n2) Comedy ($3.35) \n3) Horror ($8.34)\n");
                System.out.print("Your choice: ");
                choice = myScanner.nextInt(); 
                
                if (choice == 1) {
                    System.out.print("Enter the number of movies you want to purchase: "); 
                    quantityMovie += myScanner.nextDouble(); 
                    priceMovie += 5.65;
                    Store movie = new Store("Movie", quantityMovie, priceMovie); 
                    movieSubTotal += movie.getPrice(); 
                    System.out.println("Added to your Checkout!\n");
                    choice = 0; 
                }
                
                else if (choice == 2) {
                    System.out.print("Enter the number of movies you want to purchase: "); 
                    quantityMovie += myScanner.nextDouble(); 
                    priceMovie += 3.35;
                    Store movie = new Store("Movie", quantityMovie, priceMovie); 
                    movieSubTotal += movie.getPrice(); 
                    System.out.println("Added to your Checkout!\n");
                    choice = 0; 
                }
                
                else {
                    System.out.print("Enter the number of movies you want to purchase: "); 
                    quantityMovie += myScanner.nextDouble(); 
                    priceMovie += 8.34;
                    Store movie = new Store("Movie", quantityMovie, priceMovie);
                    movieSubTotal += movie.getPrice(); 
                    System.out.println("Added to your Checkout!\n");
                    choice = 0; 
                }
            }
            
            if (choice == 3) { //checking user input
                System.out.print("\nEnter how many pounds of peanuts you want to purchase ($2.34/pound): ");  //asking for quantity
                quantityPeanut += myScanner.nextDouble(); //updating input into varibale 
                pricePeanut += 2.34; //updating price of the item 
                Store peanut = new Store("Peanut", quantityPeanut, pricePeanut); //saving into object
                peanutSubTotal += peanut.getPrice(); //gettting subtotal
                System.out.println("Added to your Checkout!\n"); //prompting user about update being made
            }
            
            //Note: when outputted qunatity for movie and book are ints and peanutes are double, as you cannot have fraction of a movie or book but in the case of peanutes you can as it is in pounds
            
            if (choice == 4) { //checking what userinputted 
                
                if (counter >= 1) { //checks if the counter is greater than or equal to 1 becuase then it intidicates that the user already applied for the discount and therfore cannot do it again, as that would mean everything will be for free
                    System.out.println("\nYOU HAVE ALREADY APPLIED FOR THE DISCOUNT, YOU CANNOT DO IT AGAIN!\n"); //informing user that discounts are one-time only
                }
                
                else {
                    
                    System.out.println("\nTo recive a 25% DISCOUNT, guess the lottery number"); //prompting user on how much the discount is for
                    System.out.println("HINT: It is an integer between 1-10 (inclusive)"); //giving hint for lottery system

                    int max = 10; //declaring varibales (max and min) 
                    int min = 1;
                    int calc = max - min + 1; //finding range 
                    int num = (int) (Math.random() * calc) + min; //random number between 1-10 inclusive

                    System.out.print("\nYour guess: "); //asking for userinput
                    guess = myScanner.nextInt();

                    if (guess == num) { //checking if they guessed correclty 
                        System.out.println("CONGRATS YOU GOT A 25% DISCOUNT!!\n"); //informing user they were correct
                        correct = true; //makes boolean true to completly process below (more on this later) 
                    } 
                    
                    else {
                        System.out.println("Unfortunatley you did not guess correctly :("); //informing user they were incorrect
                        System.out.println("Correct number: " + num + "\n"); //telling user the correct number so they don't think we scammed 
                        correct = false; //makes boolean false indicating they don't recive the discount
                    }

                    if (correct == true) { //for the user that guessed correclty
                        discount += 0.25; //updates the discount to being 25%
                    } 
                    else {
                        discount += 0; //updates discount to being 0% as the user did not recive it
                    }            
                
                }
                
                counter++; //counter is here so it can prevent expliotation of the discount system, as without it the user can go again and again to get multiple discounts
                   
            }
            
            if (choice == 5) { //checks user input
                Store calc = new Store(); //creats new object which will be used for all the items not subjectivly one as done before
                subTotal += calc.getItemSub(bookSubTotal, movieSubTotal, peanutSubTotal); //adding the sum of the prices of all the item subtotals
                sale += calc.getDiscount(discount); //calcultaing the discount if any
                tax += calc.getItemTax(); //takes the tax after discount has been applied 
                ship += calc.getShippingCost(); //takes the shipping cost after discount has been applied 
                taxTotal += calc.getItemTotTax(); //takes the total cost of the purchases include tax and shipping (minus discount if applicade)
                
                Format value = new Format(quantityBook, quantityMovie, quantityPeanut, bookSubTotal, movieSubTotal, peanutSubTotal, subTotal, sale, tax, ship, taxTotal); //takes in many values to output the final recipt
                value.getCashNum(); //generates random cashier number 
                value.getDate(); //generats the current date and time
                value.getFormat(); //geenrates the recipt 
                break;//ends the while loop as this option means the user wants to checkout
            }
        
        }
    }
    
}
