package n3.vehicles;

public class Car extends Vehicle {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public void start(){
        System.out.println("Start car");
    }

    public void accelerate(){
        System.out.println("Accelerate car");
    }

    public void stop(){
        System.out.println("Stop car");
    }

    public String getName() {
        return name;
    }
}
