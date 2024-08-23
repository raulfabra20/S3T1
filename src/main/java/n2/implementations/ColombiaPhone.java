package n2.implementations;

import n2.interfaces.PhoneNumber;

public class ColombiaPhone implements PhoneNumber {
    private String number;
    private final String PREFIX = "+57";

    @Override
    public void setPhoneNumber(String number) {
        this.number = number;
    }

    @Override
    public String getPhoneNumber() {
        return PREFIX+number;
    }
}
