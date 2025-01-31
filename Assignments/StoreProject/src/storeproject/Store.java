//Name: Ishaan Mittal 
//Date: 26/03/2024 
//Assignment: Store Project
//Purpose: To create a class for calculations 

package storeproject;

public class Store {
    
    public String item;  //declaring instance varibales 
    private double quantity; 
    private double price; 
    private double subTot; 
    private double ship; 
    
    public Store() { //main class 
        
    }
    public Store(String name, double quan, double expense) { //takes in user input of the object and saves it into variables
        item = name; //updating instance variables
        quantity = quan; 
        price = expense; 
    }
    
    public double getPrice() { //gets the subtotal of the specific item
        double total; //declaring varibale 
        total = quantity * price; //finds the product between the quanitity and price recived by the method
        
        return total; //returns subtotal of object
    }
    
    
    public double getItemSub(double price, double price2, double price3) { //gets the subtotoal of all the items 
        subTot = price + price2 + price3; //adds all the subtotals of each item
        return subTot; //returns the subtotal of all the items
    }
    
     public double getDiscount(double dis) { //gets the discount 
        double discount = subTot * dis; //multiples the subtotal of all the items by the discount factor (0.25), can also be 0 if the user did not recive any discount
        subTot = subTot - discount; //updates subtotal by subtracting the discounted value, it is done before applying tax in this case 
        return discount; //returns how much money they saved from the discount (can output 0 if the user did not get the discount) 
    }
    
    public double getShippingCost() { //gets the shipping cost of the subtotal
        ship = subTot * 0.08; //I made the shiiping cost 8% of the subtotal of all the items, so it finds 8% of the subtotal 
        return ship; //returns how much money was spent towards shipping costs 
    }
    public double getItemTax() { //gets the tax cost of the subtotal
        return subTot * 0.13;  //returns how much money was spent towards tax
    }
    
    public double getItemTotTax() { //gets the final price of the purchases
        return subTot * 1.13 + ship; //applies the tax and the shipping cost 
    }
    
}
