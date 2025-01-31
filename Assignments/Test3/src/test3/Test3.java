/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test3;

/**
 *
 * @author Dell
 */
public class Test3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public int getPlayer2Move(int round) {
        int result;
        if (round % 3 == 0) {
            result = 3;
            return result;
        } else if (round % 2 == 0) {
            result = 2;
            return result;
        } else {
            result = 1;
            return result;
        }
    }

}
