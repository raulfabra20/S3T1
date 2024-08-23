package n2.implementations;

import n2.interfaces.PhoneNumber;

public class GermanyPhone implements PhoneNumber {
    private String number;
    private final String PREFIX = "+49";

    @Override
    public void setPhoneNumber(String number) {
        this.number = number;
    }

    @Override
    public String getPhoneNumber() {
        return PREFIX+number;
    }
}
