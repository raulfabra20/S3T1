package n2.implementations;

import n2.interfaces.PhoneNumber;

public class SpainPhone implements PhoneNumber {
    private String number;
    private final String PREFIX = "+34";

    @Override
    public void setPhoneNumber(String number) {
        this.number = number;
    }

    @Override
    public String getPhoneNumber() {
        return PREFIX+number;
    }
}
