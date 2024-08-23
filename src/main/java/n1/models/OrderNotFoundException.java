package n1.models;

public class OrderNotFoundException extends Exception {

    public OrderNotFoundException(String message){
        super(message);
    }
}
