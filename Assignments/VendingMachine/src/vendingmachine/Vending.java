package vendingmachine;

//Name: Ishaan Mittal 
//Date: 21 Feb 2024 
//Assingment: Vending Machine
//Purpose: To design a Vending Machine that takes in objects containing attritubes such as name, price, and stock

public class Vending {
    
    private String productName; //declaring instance varibale 
    private double price; 
    private double maxQuan; 
    private double currentStock; 
    
    public Vending() { //main class 
        
    }
    
    public Vending(String name, double value, double stock) { //takes in user input of the object and saves it into variables 
        productName = name; 
        price = value; 
        currentStock = stock; 
        maxQuan = 50; 
    }
    
    public String getName() { //print product name 
        return productName; 
    }
    
    public double getPrice() { //retruns the price of the item 
        return price; 
    }
    
    public double setPrice(double val) { //sets a new price to the item 
        price = val; 
        return price;
    }
    
    public double getStock() { //returns the stock of the item 
        return currentStock; 
    }
    
    public double checkTot() { //returns the total price of the item in the machine
        return price * currentStock; 
    }
    
}
