package n1;

import n1.models.OrderNotFoundException;
import n1.models.Undo;

import java.util.Scanner;

public class Main {

    public static void main(String [] args){
        Undo u = Undo.getInstance();

        boolean exit = false;

        do{
            switch(menu()){
                case 1:
                    insertOrder(u);
                    break;
                case 2:
                    deleteOrder(u);
                    break;
                case 3:
                    u.showOrders();
                    break;
                case 0:
                    System.out.println("Thank you for using the app.");
                    break;
            }
        } while(!exit);
    }

    public static byte menu() {
        Scanner sc = new Scanner(System.in);
        byte option;
        final byte MINIMUM = 0;
        final byte MAXIMUM = 9;

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

    public static void insertOrder(Undo u){
        Scanner sc = new Scanner(System.in);

        System.out.println("Insert the order: ");
        String order = sc.nextLine();
        u.addOrder(order);
    }

    public static void deleteOrder(Undo u){
        Scanner sc = new Scanner(System.in);

        try{
        System.out.println("Insert the order wanted to be removed:");
        String order = sc.nextLine();
        String checkedOrder = u.findOrder(order);

           if(checkedOrder != null){
               u.removeOrder(checkedOrder);
           } else {
               throw  new OrderNotFoundException("The order does not exist");
           }

        }catch (OrderNotFoundException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
