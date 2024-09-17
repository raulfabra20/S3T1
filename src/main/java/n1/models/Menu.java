package n1.models;

import java.util.Scanner;

public class Menu {

    public static void printMenu(){
        Undo u = Undo.getInstance();
        boolean exit = false;

        do{
            switch(menu()){
                case 1:
                    u.addOrder();
                    break;
                case 2:
                    u.removeOrder();
                    break;
                case 3:
                    u.showOrders();
                    break;
                case 0:
                    System.out.println("Thank you for using the app.");
                    exit = true;
                    break;
            }
        } while(!exit);
    }

    public static byte menu() {
        Scanner sc = new Scanner(System.in);
        byte option;
        final byte MINIMUM = 0;
        final byte MAXIMUM = 3;

        do {
            System.out.println("\nMAIN MENU");
            System.out.println("1. Add order.");
            System.out.println("2. Remove order.");
            System.out.println("3. Show orders");
            System.out.println("0. Exit \n");
            option = sc.nextByte();
            if (option < MINIMUM || option > MAXIMUM) {
                System.out.println("Choose a valid option.");
            }
        } while (option < MINIMUM || option > MAXIMUM);
        return option;
    }


    }

