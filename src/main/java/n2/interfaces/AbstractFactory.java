package n2.interfaces;

public interface AbstractFactory {
    Address createAddress(String country);
    PhoneNumber createPhoneNumber(String country);
}
