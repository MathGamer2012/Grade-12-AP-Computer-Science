/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vendingmachine;

//Name: Ishaan Mittal 
//Date: 21 Feb 2024 
//Assingment: Vending Machine
//Purpose: To design a Vending Machine that takes in objects containing attritubes such as name, price, and stock

public class VendingMachine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vending beyblade = new Vending("Beyblade", 15, 5);  //creating objects with name, price, and stock attrutbutes 
        Vending takis = new Vending("Takis", 3, 30); 
        Vending nintendo = new Vending("Nintendo", 399, 2); 
        Vending vbucks = new Vending("Vbucks", 25, 5); 
        Vending robot = new Vending("Robot", 10, 6); 
        
        System.out.println("The total price of the item " + beyblade.getName() + " is: $" + beyblade.checkTot()); //printing out the total price of each object 
        System.out.println("The total price of the item " + takis.getName() + " is: $" + takis.checkTot()); 
        System.out.println("The total price of the item " + nintendo.getName() + " is: $" + nintendo.checkTot()); 
        System.out.println("The total price of the item " + vbucks.getName() + " is: $" + vbucks.checkTot()); 
        System.out.println("The total price of the item " + robot.getName() + " is: $" + robot.checkTot()); 
        
    }
    
}
