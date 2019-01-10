package consumerTest;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import consumer.BankAccountConsumer;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class BankAccountRetrieveTest {
    String id = "1";
    @Rule
    public PactProviderRuleMk2 provider = new PactProviderRuleMk2("Provider", this);

    @Pact(consumer = "retrieveBankAccount")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json");

        return builder
                .given("retrieveBankAccount")
                .uponReceiving("a request")
                .path("/account/" + id + "/bankAccount")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body("[\n" +
                        "    {\n" +
                        "        \"bankAccountId\": null,\n" +
                        "        \"account\": null,\n" +
                        "        \"bankName\": \"Is bankasi\",\n" +
                        "        \"iban\": \"1111111111111\",\n" +
                        "        \"balance\": {\n" +
                        "            \"currency\": \"TL\",\n" +
                        "            \"amount\": \"500\"\n" +
                        "        }\n" +
                        "    }\n" +
                        "]")
                .toPact();

    }

    @Test
    @PactVerification()
    public void doTest() {
        System.setProperty("pact.rootDir", "../pacts");  // Change output dir for generated pact-files
        ResponseEntity<String> eta = new BankAccountConsumer(provider.getPort()).retrieveBankAccount(id);

    }

}
