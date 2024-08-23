package n2.implementations;

import n2.interfaces.Address;

public class GermanyAddress implements Address {
    private String street;
    private String city;
    private String number;
    private String postCode;
    private final String COUNTRY = "Germany";

    @Override
    public void setAddress(String street, String city, String number, String postCode) {
        this.street = street;
        this.city = city;
        this.number = number;
        this.postCode = postCode;
    }

    @Override
    public String getAddress() {
        return "St: "+this.street+" , "+this.number+" , "+this.postCode+" , "+this.city+" , "+COUNTRY;
    }
}
