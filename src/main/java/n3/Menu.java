package n3;

import n3.vehicles.*;

import java.util.Scanner;

import static n3.ParkingApp.*;

public class Menu {
    public static void printMenu(){
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
                    break;
                case 0:
                    System.out.println("Thank you for using the application.");
                    exit = true;
                    break;
                default:
                    throw new IllegalArgumentException("Option not valid");
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
}
