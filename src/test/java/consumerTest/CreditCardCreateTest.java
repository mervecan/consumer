package consumerTest;


import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import consumer.CreditCardConsumer;
import org.json.JSONObject;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class CreditCardCreateTest {

    String creditCard = "{\n" +
            "            \"account\": null,\n" +
            "            \"brand\": \"VISA\",\n" +
            "            \"cardNumber\": \"222321314\",\n" +
            "            \"expMonth\": \"12\",\n" +
            "            \"expYear\": \"23\",\n" +
            "            \"balance\": {\n" +
            "                \"currency\": \"TL\",\n" +
            "                \"amount\": \"-200\"\n" +
            "            }\n" +
            "        }";

    String id = "2";
    @Rule
    public PactProviderRuleMk2 provider = new PactProviderRuleMk2("Provider", this);

    @Pact(consumer = "createCreditCard")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json");

        return builder
                .given("createCreditCard")
                .uponReceiving("a request")
                .path("/account/" + id + "/creditCard")
                .method("POST")
                .headers(headers)
                .body(creditCard)
                .willRespondWith()
                .status(201)
                .headers(headers)
                .body(creditCard)
                .toPact();

    }

    @Test
    @PactVerification()
    public void doTest() {
        JSONObject jsonObj = new JSONObject(creditCard);
        System.setProperty("pact.rootDir", "../pacts");  // Change output dir for generated pact-files
        ResponseEntity<String> creditCardResponse = new CreditCardConsumer(provider.getPort()).createCreditCard("2", jsonObj);

    }

}
