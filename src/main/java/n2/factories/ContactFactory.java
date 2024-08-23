package n2.factories;

import n2.implementations.*;
import n2.interfaces.AbstractFactory;
import n2.interfaces.Address;
import n2.interfaces.PhoneNumber;

public class ContactFactory implements AbstractFactory {
    @Override
    public Address createAddress(String country) {
        switch(country.toLowerCase()){
            case "spain":
                return new SpainAddress();
            case "colombia":
                return new ColombiaAddress();
            case "germany":
                return new GermanyAddress();
            default:
                throw new IllegalArgumentException("This country not valid");
        }

    }

    @Override
    public PhoneNumber createPhoneNumber(String country) {
        switch(country.toLowerCase()){
            case "spain":
                return new SpainPhone();
            case "colombia":
                return new ColombiaPhone();
            case "germany":
                return new GermanyPhone();
            default:
                throw new IllegalArgumentException("This country not valid");
        }
    }
}
