package models;

public class BankAccount {
    private String bankAccountId;
    //private Account account;
    private String bankName;
    private String iban;
    private Balance balance;

    public BankAccount() {

    }

    public BankAccount(String bankAccountId, String bankName, String iban, Balance balance) {
        this.bankAccountId = bankAccountId;
        //this.account = account;
        this.bankName = bankName;
        this.iban = iban;
        this.balance = balance;
    }

    public String getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(String bankAccountId) {
        this.bankAccountId = bankAccountId;
    }
//
//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "bankAccountId='" + bankAccountId + '\'' +
                //", account=" + account +
                ", bankName='" + bankName + '\'' +
                ", iban='" + iban + '\'' +
                ", balance=" + balance +
                '}';
    }
}
