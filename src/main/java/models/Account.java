package models;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String id;
    private Customer customer;
    private List<BankAccount> bankAccounts = new ArrayList<BankAccount>();
    private List<CreditCard> creditCards = new ArrayList<CreditCard>();
    private String createdTime;
    private List<Order> orders = new ArrayList<Order>();

    public Account(String id, Customer customer, List<BankAccount> bankAccounts, List<CreditCard> creditCards, String createdTime, List<Order> orders) {
        this.id = id;
        this.customer = customer;
        this.bankAccounts = bankAccounts;
        this.creditCards = creditCards;
        this.createdTime = createdTime;
        this.orders = orders;
    }

    public Account() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrders(Order order) {
        orders.add(order);
    }

    public void addCreditCard(CreditCard creditCard) {
        creditCards.add(creditCard);
    }

    public void addBankAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", customer=" + customer +
                ", bankAccounts=" + bankAccounts +
                ", creditCards=" + creditCards +
                ", createdTime='" + createdTime + '\'' +
                ", orders=" + orders +
                '}';
    }
}
