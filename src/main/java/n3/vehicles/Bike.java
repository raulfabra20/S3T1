package n3.vehicles;

public class Bike extends Vehicle{
    private String name;

    public Bike(String name) {
        this.name = name;
    }

    public void start(){
        System.out.println("Start bike");
    }

    public void accelerate(){
        System.out.println("Accelerate bike");
    }

    public void stop(){
        System.out.println("Stop bike");
    }

    public String getName() {
        return name;
    }
}
