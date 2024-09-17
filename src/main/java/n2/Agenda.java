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

    public static void testAgenda() {
        Map<PhoneNumber, Address> contacts = new HashMap<>();
        Menu.printMenu(contacts);
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
