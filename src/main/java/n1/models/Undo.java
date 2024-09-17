package n1.models;

import java.util.ArrayList;
import java.util.Scanner;

public class Undo {

    private static Undo instance;
    private ArrayList<String> orders;


    private Undo(){
        this.orders = new ArrayList<>();
    }

    public static Undo getInstance(){
        if(instance == null){
            instance = new Undo();
        }
        return instance;
    }

    public void addOrder(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Insert the order: ");
        String order = sc.nextLine();
        orders.add(order);
        System.out.println("Order added successfully.");
    }

    public void removeOrder(){
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Insert the order wanted to be removed:");
            String order = sc.nextLine();
            String checkedOrder = findOrder(order);

            if(checkedOrder != null){
                orders.remove(checkedOrder);
                System.out.println("Order removed successfully.");
            } else {
                throw  new OrderNotFoundException("The order does not exist");
            }

        }catch (OrderNotFoundException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void showOrders() {
      try {
          if (!orders.isEmpty()) {
              orders.forEach(System.out::println);
          } else {
              throw new ListIsEmptyException("The list does not contain any order.");
          }

      } catch(ListIsEmptyException e){
          System.out.println("Error: "+e.getMessage());
      }
    }

    public String findOrder(String order) throws OrderNotFoundException {
        return orders.stream().filter(o -> o.equalsIgnoreCase(order)).findFirst().orElseThrow(() ->
                new OrderNotFoundException("The order does not exist."));

    }
}
