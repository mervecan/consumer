package models;

public class Address {
    private String country;
    private String city;
    private String line;
    private String postalCode;

    public Address() {

    }

    public Address(String country, String city, String line, String postalCode) {
        this.country = country;
        this.city = city;
        this.line = line;
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", line='" + line + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
