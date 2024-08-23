package n3.commands;

import n3.vehicles.Vehicle;

public class Stop implements Command {
    private Vehicle vehicle;

    public Stop(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void execute(){
        vehicle.stop();
    }
}
