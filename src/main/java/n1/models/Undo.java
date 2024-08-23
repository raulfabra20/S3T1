package n1.models;

import java.util.ArrayList;

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

    public void addOrder(String order){
        orders.add(order);
        System.out.println("Order added successfully.");
    }

    public void removeOrder(String order){
        orders.remove(order);
        System.out.println("Order removed successfully.");
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
