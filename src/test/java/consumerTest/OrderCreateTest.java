package consumerTest;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import consumer.OrderConsumer;
import org.json.JSONObject;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class OrderCreateTest {
    String id = "2";
    @Rule
    public PactProviderRuleMk2 provider = new PactProviderRuleMk2("Provider", this);

    @Pact(consumer = "retrieveCreditCard")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json");


        return builder
                .given("createOrder")
                .uponReceiving("a request")
                .path("/account/" + id + "/order")
                .method("POST")
                .headers(headers)
                .body("{\n" +
                        "    \"orderId\": \"301\",\n" +
                        "    \"amount\": \"250\",\n" +
                        "    \"products\": null,\n" +
                        "    \"status\": \"PAID\"\n" +
                        "}")
                .willRespondWith()
                .status(201)
                .headers(headers)
                .body("{\n" +
                        "    \"orderId\": \"301\",\n" +
                        "    \"amount\": \"250\",\n" +
                        "    \"products\": null,\n" +
                        "    \"status\": \"PAID\"\n" +
                        "}")
                .toPact();

    }

    @Test
    @PactVerification()
    public void doTest() {

        String st = "{\n" +
                "    \"orderId\": \"301\",\n" +
                "    \"amount\": \"250\",\n" +
                "    \"products\": null,\n" +
                "    \"status\": \"PAID\"\n" +
                "}";
        JSONObject jsonObj = new JSONObject(st);
        System.setProperty("pact.rootDir", "../pacts");  // Change output dir for generated pact-files
        ResponseEntity<String> eta = new OrderConsumer(provider.getPort()).createOrder(id, jsonObj);

    }

}
