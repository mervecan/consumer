package application;

import consumer.AccountConsumer;
import consumer.BankAccountConsumer;
import consumer.CreditCardConsumer;
import consumer.OrderConsumer;
import models.BRAND;
import org.json.JSONObject;

import java.io.IOException;

public class Application {
    public static void main(String args[]) throws IOException {
        AccountConsumer accountConsumer = new AccountConsumer();
        BankAccountConsumer bankAccountConsumer = new BankAccountConsumer();
        CreditCardConsumer creditCardConsumer = new CreditCardConsumer();
        OrderConsumer orderConsumer = new OrderConsumer();


//        JSONObject account = new JSONObject();
//        account.put("createdTime", "em");
//        accountConsumer.createAccount(account);
        String id = "1";
        JSONObject balance = new JSONObject();
        balance.put("currency", "TL");
        balance.put("amount", "200");

        //  Bank Account Operation
//        JSONObject bankAccount = new JSONObject();
//        bankAccount.put("bankName", "ziraat");
//        bankAccount.put("iban", "213");
//        bankAccount.put("balance" , balance);
//        bankAccount.put("bankAccountId", "100");
//        String bankA = "{\n" +
//                "    \"bankAccountId\": \"101\",\n" +
//                "    \"bankName\": \"ziraat\",\n" +
//                "    \"iban\": \"1232132\",\n" +
//                "    \"balance\": {\n" +
//                "        \"currency\": \"TL\",\n" +
//                "        \"amount\": \"100\"\n" +
//                "    }\n" +
//                "}";
//        bankAccountConsumer.createBankAccount(id, bankA);
        //bankAccountConsumer.retrieveBankAccount(id);

        //Credit Card Operation
        JSONObject creditCard = new JSONObject();
        creditCard.put("creditCardId", "123");
        creditCard.put("brand", BRAND.MASTERCARD);
        creditCard.put("cardNumber", "22234");
        creditCard.put("expMonth", "12");
        creditCard.put("expYear", "19");
        creditCard.put("balance", balance);

        creditCardConsumer.createCreditCard(id, creditCard);

        //Order Operation
//        JSONObject product1 = new JSONObject();
//        product1.put("productId", "201");
//        product1.put("name", "book");
//        product1.put("definition", "textbook");
//        product1.put("price", "100");
//
//        JSONObject product2 = new JSONObject();
//        product2.put("productId", "202");
//        product2.put("name", "book");
//        product2.put("definition", "dk");
//        product2.put("price", "200");
//
//        JSONArray products = new JSONArray();
//        products.put(product1);
//        products.put(product2);
//
//        JSONObject order = new JSONObject();
//        order.put("orderId", "102");
//        order.put("amount", "300");
//        order.put("products", products);
//        order.put("status", STATUS.PAID);
//
//        orderConsumer.createOrder(id, order);
        //       orderConsumer.retrieveOrder(id);

        // accountConsumer.retrieveAccount("1");
        //      bankAccountConsumer.retrieveBankAccount("1");

    }

}