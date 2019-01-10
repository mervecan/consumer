package consumerTest;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import consumer.OrderConsumer;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class OrderRetrieveTest {
    String id = "1";
    @Rule
    public PactProviderRuleMk2 provider = new PactProviderRuleMk2("Provider", this);

    @Pact(consumer = "retrieveOrder")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json");


        return builder
                .given("retrieveOrder")
                .uponReceiving("a request")
                .path("/account/" + id + "/order")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body("[\n" +
                        "    {\n" +
                        "        \"orderId\": \"300\",\n" +
                        "        \"amount\": \"400\",\n" +
                        "        \"products\": [\n" +
                        "            {\n" +
                        "                \"productId\": \"500\",\n" +
                        "                \"name\": \"pencil\",\n" +
                        "                \"definition\": \"versatil\",\n" +
                        "                \"price\": \"130\"\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"productId\": \"501\",\n" +
                        "                \"name\": \"book\",\n" +
                        "                \"definition\": \"textbook\",\n" +
                        "                \"price\": \"270\"\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"productId\": \"502\",\n" +
                        "                \"name\": \"notebook\",\n" +
                        "                \"definition\": \"notebook\",\n" +
                        "                \"price\": \"100\"\n" +
                        "            }\n" +
                        "        ],\n" +
                        "        \"status\": \"PAID\"\n" +
                        "    }\n" +
                        "]")
                .toPact();

    }

    @Test
    @PactVerification()
    public void doTest() {
        System.setProperty("pact.rootDir", "../pacts");  // Change output dir for generated pact-files
        String eta = new OrderConsumer(provider.getPort()).retrieveOrder(id);
    }

}
