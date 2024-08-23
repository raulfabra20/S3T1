package n2;

import n2.factories.ContactFactory;
import n2.implementations.*;
import n2.interfaces.AbstractFactory;
import n2.interfaces.Address;
import n2.interfaces.PhoneNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Agenda {
    //NO PEDIR SI ES DIRECCION O NUMERO, YA QUE ESTAMOS AÑADIENDO LOS 2 A LA VEZ. HAY QUE CAMBIAR LA CLASE CONCRETE FACTORY)

    public static void testAgenda() {
        Map<PhoneNumber, Address> contacts = new HashMap<>();
        AbstractFactory factory;
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



    public static String askCountry(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write the country which the entry id from: (spain, colombia, germany)");
        String country = sc.nextLine();
        return country;
    }

    public static String getStreet(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entry the street: ");
        String street = sc.nextLine();
        return street;
    }

    public static String getCity(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entry the city: ");
        String city = sc.nextLine();
        return city;
    }
    public static String getNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entry the door number: ");
        String number = sc.nextLine();
        return number;
    }
    public static String getPostCode(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entry the post code: ");
        String postCode = sc.nextLine();
        return postCode;
    }
    public static String getPhone(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entry the phone number: ");
        String phoneNumber = sc.nextLine();
        return phoneNumber;
    }

    public static void printAgenda(Map<PhoneNumber, Address> contacts){
        contacts.forEach((phoneNumber, address) -> System.out.println("Phone: "+phoneNumber.getPhoneNumber()+" Address: "+address.getAddress()));
    }
}
