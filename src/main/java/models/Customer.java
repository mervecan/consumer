package models;

public class Customer {
    private String customerId;
    private String businessName;
    private String businessUrl;
    private String country;
    private String email;
    private Address address;

    public Customer() {

    }

    public Customer(String customerId, String businessName, String businessUrl, String country, String email, Address address) {
        this.customerId = customerId;
        this.businessName = businessName;
        this.businessUrl = businessUrl;
        this.country = country;
        this.email = email;
        this.address = address;
    }

    public String getId() {
        return customerId;
    }

    public void setId(String customerId) {
        this.customerId = customerId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessUrl() {
        return businessUrl;
    }

    public void setBusinessUrl(String businessUrl) {
        this.businessUrl = businessUrl;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", businessName='" + businessName + '\'' +
                ", businessUrl='" + businessUrl + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
