package n3.vehicles;

public class Ship extends Vehicle {
    private String name;

    public Ship(String name) {
        this.name = name;
    }

    public void start(){
        System.out.println("Start ship");
    }

    public void accelerate(){
        System.out.println("Accelerate ship");
    }

    public void stop(){
        System.out.println("Stop ship");
    }

    public String getName() {
        return name;
    }
}
