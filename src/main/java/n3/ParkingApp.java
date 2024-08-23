package n3;

import n3.commands.Accelerate;
import n3.commands.Start;
import n3.commands.Stop;
import n3.vehicles.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class ParkingApp {
    private static Map<Integer, Vehicle> vehicles = new HashMap<>();

    public ParkingApp() {

    }

    public static void testParking() {
        addVehicles();
        boolean exit = false;
        do {
            switch (menu()) {
                case 1:
                    showVehicles();
                    break;
                case 2:
                    Vehicle vehicle = findVehicle();
                    switch (vehicle) {
                        case Bike bike:
                            showCommands(bike);
                            break;
                        case Car car:
                            showCommands(car);
                            break;
                        case Plane plane:
                            showCommands(plane);
                            break;
                        case Ship ship:
                            showCommands(ship);
                            break;
                        default:
                            System.out.println("Vehicle not found");

                    }
            }
        } while (!exit);

    }

    public static byte menu() {
        Scanner sc = new Scanner(System.in);
        byte option;
        final byte MINIMUM = 0;
        final byte MAXIMUM = 2;

        do {
            System.out.println("\nMAIN MENU");
            System.out.println("1. Show vehicles. ");
            System.out.println("2. Command vehicle");
            System.out.println("0. Exit");
            option = sc.nextByte();
            if (option < MINIMUM || option > MAXIMUM) {
                System.out.println("Choose a valid option.");
            }
        } while (option < MINIMUM || option > MAXIMUM);
        return option;

    }


    public static void addVehicles() {
        Bike bike = new Bike("bike");
        Car car = new Car("car");
        Plane plane = new Plane("plane");
        Ship ship = new Ship("ship");

        vehicles.put(1, bike);
        vehicles.put(2, car);
        vehicles.put(3, plane);
        vehicles.put(4, ship);
    }

    public static void showVehicles() {
        vehicles.forEach((value, vehicle) -> System.out.println(value + vehicle.getName()));
    }

    public static Vehicle findVehicle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce the vehicle you want to command: ");
        String vehicle = sc.nextLine();

        Optional<Vehicle> vehicleOpt = vehicles.values().stream()
                .filter(v -> v.getName().equalsIgnoreCase(vehicle))
                .findFirst();
        if (vehicleOpt.isPresent()) {
            return vehicleOpt.get();
        } else {
            throw new IllegalArgumentException("Vehicle type not valid");
        }
    }

    public static void showCommands(Vehicle vehicle) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Commands for: " + vehicle.getName() + ": \n" +
                "1. Start\n" +
                "2. Accelerate\n" +
                "3. Stop\n");
        byte option = sc.nextByte();
        sc.nextLine();
        switch (option){
            case 1:
                Start start = new Start(vehicle);
                vehicle.start();
                break;
            case 2:
                Accelerate accelerate = new Accelerate(vehicle);
                vehicle.accelerate();
                break;
            case 3:
                Stop stop = new Stop(vehicle);
                vehicle.stop();
                break;
            default:
                throw new IllegalArgumentException("Command not valid.");

        }

    }
}