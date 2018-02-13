package com.pillar;

import com.pillar.coins.Coin;
import com.pillar.product.Product;
import com.pillar.vendingmachine.VendingMachine;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Main class will serve as the simulator for the vending machine.  Through the main method, the use will be able to
 * add coins, make a purchase, or return their coins.
 */
public class Main {
    public static void main(String[] args) {
        boolean keepUsing = true;
        ArrayList<Coin> insertedCoins = new ArrayList<Coin>();
        VendingMachine vendingMachine = new VendingMachine();
        Scanner scanner = new Scanner(System.in);

        do{
            boolean makingSelection = true;
            int userSelection = 0;
            do{
                System.out.println("----------------Select an option-----------");
                System.out.println("MACHINE OUTPUT:  " + vendingMachine.displayOutput(insertedCoins));
                System.out.println("Add Coin:  1 for quarter, 2 for dime, 3 for nickel, 4 for penny");
                System.out.println("Purchase A Product:  5 for Cola, 6 for Chips, 7 for Candy");
                System.out.println("Return coins:  press 8");

                do {
                    while (!scanner.hasNextInt()) {
                        System.out.println("That's not a number!");
                        scanner.next();
                    }
                    userSelection = scanner.nextInt();
                } while (userSelection <= 0);
                switch(userSelection){
                    case 1: insertedCoins.add(Coin.getQuarter());
                        break;
                    case 2: insertedCoins.add(Coin.getDime());
                        break;
                    case 3: insertedCoins.add(Coin.getNickel());
                        break;
                    case 4: insertedCoins.add(Coin.getPenny());
                        break;
                    case 5:System.out.println("MACHINE OUTPUT: " +vendingMachine.makePurchase(insertedCoins, Product.COLA_SELECTED));
                        break;
                    case 6: System.out.println("MACHINE OUTPUT: " +vendingMachine.makePurchase(insertedCoins, Product.CHIPS_SELECTED));
                        break;
                    case 7: System.out.println("MACHINE OUTPUT: " +vendingMachine.makePurchase(insertedCoins, Product.CANDY_SELECTED));
                        break;
                    case 8: insertedCoins = vendingMachine.returnInsertedCoins(insertedCoins);
                        break;
                    default: System.out.println("Invalid Selection");
                }
                if(userSelection == 5 || userSelection == 6 || userSelection == 7 || userSelection == 8){
                    makingSelection = false;
                }

            }while(makingSelection);

            System.out.println("Continue?  Y/N");
            scanner.nextLine();
            String selection = scanner.nextLine();
            if(!selection.equalsIgnoreCase("y")){
              keepUsing = false;
            }
        }while (keepUsing);
        System.out.println("Exiting Vending Machine");
    }
}
