package n2;

import n2.implementations.*;
import n2.interfaces.Address;
import n2.interfaces.PhoneNumber;

import java.util.Map;
import java.util.Scanner;

import static n2.Agenda.*;

public class Menu {
    public static void printMenu(Map<PhoneNumber, Address> contacts){
        boolean exit = false;
        do {
            switch (menu()) {
                case 1:
                    String country = askCountry();
                    Address address;
                    PhoneNumber phoneNumber;
                    if (country.equalsIgnoreCase("spain")) {
                        address = new SpainAddress();
                        phoneNumber = new SpainPhone();
                    } else if (country.equalsIgnoreCase("colombia")) {
                        address = new ColombiaAddress();
                        phoneNumber = new ColombiaPhone();
                    } else if (country.equalsIgnoreCase("germany")) {
                        address = new GermanyAddress();
                        phoneNumber = new GermanyPhone();
                    } else {
                        throw new IllegalArgumentException("This Country is not valid.");
                    }
                    String street = getStreet();
                    String number = getNumber();
                    String city = getCity();
                    String postCode = getPostCode();
                    address.setAddress(street, city, number, postCode);

                    String phone = getPhone();
                    phoneNumber.setPhoneNumber(phone);

                    contacts.put(phoneNumber, address);
                    System.out.println("Contact added to the agenda.");
                    break;
                case 2:
                    printAgenda(contacts);
                    break;
                case 0:
                    System.out.println("Exiting from the agenda.");
                    exit = true;
                    break;
                default:
                    throw new IllegalArgumentException("This option is not valid");
            }
        }while(!exit);
    }

    public static byte menu(){
        Scanner sc = new Scanner(System.in);
        byte option;
        final byte MINIMUM = 0;
        final byte MAXIMUM = 2;

        do {
            System.out.println("\nMAIN MENU");
            System.out.println("1. Add address and phone number ");
            System.out.println("2. View contacts.");
            System.out.println("0. Exit");
            option = sc.nextByte();
            if (option < MINIMUM || option > MAXIMUM) {
                System.out.println("Choose a valid option.");
            }
        } while (option < MINIMUM || option > MAXIMUM);
        return option;

    }
}

