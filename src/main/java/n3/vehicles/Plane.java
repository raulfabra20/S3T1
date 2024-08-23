package n3.vehicles;

public class Plane extends Vehicle {
    private String name;

    public Plane(String name) {
        this.name = name;
    }

    public void start(){
        System.out.println("Start plane");
    }

    public void accelerate(){
        System.out.println("Accelerate plane");
    }

    public void stop(){
        System.out.println("Stop plane");
    }

    public String getName() {
        return name;
    }
}
