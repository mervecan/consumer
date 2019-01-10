package consumerTest;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import consumer.AccountConsumer;
import org.json.JSONObject;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AccountCreateTest {
    @Rule
    public PactProviderRuleMk2 provider = new PactProviderRuleMk2("Provider", this);

    String st = ("{\n" +
            "    \"customer\": {\n" +
            "        \"businessName\": \"merve\",\n" +
            "        \"businessUrl\": \"iyte.edu.tr\",\n" +
            "        \"country\": \"TR\",\n" +
            "        \"email\": \"mervecan@std.iyte.edu.tr\",\n" +
            "        \"address\": {\n" +
            "            \"country\": \"TR\",\n" +
            "            \"city\": \"Izmir\",\n" +
            "            \"line\": \"Gulbahce\",\n" +
            "            \"postalCode\": \"35430\"\n" +
            "        }\n" +
            "    },\n" +
            "    \"bankAccounts\": [\n" +
            "        {\n" +
            "            \"bankAccuntId\": \"122\",\n" +
            "            \"account\": null,\n" +
            "            \"bankName\": \"Is bankasi\",\n" +
            "            \"iban\": \"1111111111111\",\n" +
            "            \"balance\": {\n" +
            "                \"currency\": \"TL\",\n" +
            "                \"amount\": \"500\"\n" +
            "            }\n" +
            "        }\n" +
            "    ],\n" +
            "    \"creditCards\": [\n" +
            "        {\n" +
            "            \"creditCardId\": \"200\",\n" +
            "            \"account\": null,\n" +
            "            \"brand\": \"VISA\",\n" +
            "            \"cardNumber\": \"222321314\",\n" +
            "            \"expMonth\": \"12\",\n" +
            "            \"expYear\": \"23\",\n" +
            "            \"balance\": {\n" +
            "                \"currency\": \"TL\",\n" +
            "                \"amount\": \"-200\"\n" +
            "            }\n" +
            "        }\n" +
            "    ],\n" +
            "    \"createdTime\": \"12.10.2018\",\n" +
            "    \"orders\": [\n" +
            "        {\n" +
            "            \"orderId\": \"300\",\n" +
            "            \"amount\": \"400\",\n" +
            "            \"products\": [\n" +
            "                {\n" +
            "                    \"productId\": \"500\",\n" +
            "                    \"name\": \"pencil\",\n" +
            "                    \"definition\": \"versatil\",\n" +
            "                    \"price\": \"130\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"productId\": \"501\",\n" +
            "                    \"name\": \"book\",\n" +
            "                    \"definition\": \"textbook\",\n" +
            "                    \"price\": \"270\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"productId\": \"502\",\n" +
            "                    \"name\": \"notebook\",\n" +
            "                    \"definition\": \"notebook\",\n" +
            "                    \"price\": \"100\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"status\": \"PAID\"\n" +
            "        }\n" +
            "    ]\n" +
            "}");

    @Pact(consumer = "createAccount")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json");


        return builder
                .given("createAccount")
                .uponReceiving("post request")
                .path("/account")
                .method("POST")
                .headers(headers)
                .body(st)
                .willRespondWith()
                .status(201)
                .headers(headers)
                .body("{\n" +
                        "    \"customer\": {\n" +
                        "        \"businessName\": \"merve\",\n" +
                        "        \"businessUrl\": \"iyte.edu.tr\",\n" +
                        "        \"country\": \"TR\",\n" +
                        "        \"email\": \"mervecan@std.iyte.edu.tr\",\n" +
                        "        \"address\": {\n" +
                        "            \"country\": \"TR\",\n" +
                        "            \"city\": \"Izmir\",\n" +
                        "            \"line\": \"Gulbahce\",\n" +
                        "            \"postalCode\": \"35430\"\n" +
                        "        },\n" +
                        "        \"id\": null\n" +
                        "    },\n" +
                        "    \"bankAccounts\": [\n" +
                        "        {\n" +
                        "            \"bankAccountId\": null,\n" +
                        "            \"account\": null,\n" +
                        "            \"bankName\": \"Is bankasi\",\n" +
                        "            \"iban\": \"1111111111111\",\n" +
                        "            \"balance\": {\n" +
                        "                \"currency\": \"TL\",\n" +
                        "                \"amount\": \"500\"\n" +
                        "            }\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"creditCards\": [\n" +
                        "        {\n" +
                        "            \"creditCardId\": \"200\",\n" +
                        "            \"account\": null,\n" +
                        "            \"brand\": \"VISA\",\n" +
                        "            \"cardNumber\": \"222321314\",\n" +
                        "            \"expMonth\": \"12\",\n" +
                        "            \"expYear\": \"23\",\n" +
                        "            \"balance\": {\n" +
                        "                \"currency\": \"TL\",\n" +
                        "                \"amount\": \"-200\"\n" +
                        "            }\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"createdTime\": \"12.10.2018\",\n" +
                        "    \"orders\": [\n" +
                        "        {\n" +
                        "            \"orderId\": \"300\",\n" +
                        "            \"amount\": \"400\",\n" +
                        "            \"products\": [\n" +
                        "                {\n" +
                        "                    \"productId\": \"500\",\n" +
                        "                    \"name\": \"pencil\",\n" +
                        "                    \"definition\": \"versatil\",\n" +
                        "                    \"price\": \"130\"\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"productId\": \"501\",\n" +
                        "                    \"name\": \"book\",\n" +
                        "                    \"definition\": \"textbook\",\n" +
                        "                    \"price\": \"270\"\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"productId\": \"502\",\n" +
                        "                    \"name\": \"notebook\",\n" +
                        "                    \"definition\": \"notebook\",\n" +
                        "                    \"price\": \"100\"\n" +
                        "                }\n" +
                        "            ],\n" +
                        "            \"status\": \"PAID\"\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}")
                .toPact();

    }

    @Test
    @PactVerification()
    public void doTest() {

        JSONObject jsonObj = new JSONObject(st);
        System.setProperty("pact.rootDir", "../pacts");  // Change output dir for generated pact-files
        String eta = new AccountConsumer(provider.getPort()).createAccount(jsonObj);

    }

}
