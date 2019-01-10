package models;

public class CreditCard {
    private String creditCardId;
    private Account account;
    private BRAND brand;
    private String cardNumber;
    private String expMonth;
    private String expYear;
    private Balance balance;

    public CreditCard() {
    }

    public CreditCard(String creditCardId, Account account, BRAND brand, String cardNumber, String expMonth, String expYear, Balance balance) {
        this.creditCardId = creditCardId;
        this.account = account;
        this.brand = brand;
        this.cardNumber = cardNumber;
        this.expMonth = expMonth;
        this.expYear = expYear;
        this.balance = balance;
    }

    public String getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(String creditCardId) {
        this.creditCardId = creditCardId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BRAND getBrand() {
        return brand;
    }

    public void setBrand(BRAND brand) {
        this.brand = brand;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "creditCardId='" + creditCardId + '\'' +
                ", account=" + account +
                ", brand=" + brand +
                ", cardNumber='" + cardNumber + '\'' +
                ", expMonth='" + expMonth + '\'' +
                ", expYear='" + expYear + '\'' +
                ", balance=" + balance +
                '}';
    }
}
