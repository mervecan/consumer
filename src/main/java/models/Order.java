package models;

import java.util.List;

public class Order {
    private String orderId;
    // private Account account;
    private String amount;
    private List<Product> products;
    private STATUS status;

    public Order() {

    }

    public Order(String orderId, String amount, List<Product> products, STATUS status) {
        this.orderId = orderId;
        //  this.account = account;
        this.amount = amount;
        this.products = products;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
//                ", account=" + account +
                ", amount='" + amount + '\'' +
                ", products=" + products +
                ", status=" + status +
                '}';
    }
}
