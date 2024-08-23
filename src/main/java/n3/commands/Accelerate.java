package n3.commands;

import n3.vehicles.Vehicle;

public class Accelerate implements Command {
    private Vehicle vehicle;

    public Accelerate(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void execute(){
        vehicle.accelerate();
    }
}
