package n3.commands;

import n3.vehicles.Vehicle;

public class Start implements Command {
    private Vehicle vehicle;

    public Start(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void execute(){
        vehicle.start();
    }
}
