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

public class BankAccountCreateTest {
    String id = "2";
    @Rule
    public PactProviderRuleMk2 provider = new PactProviderRuleMk2("Provider", this);

    @Pact(consumer = "createBankAccount")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json");

        return builder
                .given("createBankAccount")
                .uponReceiving("a request")
                .path("/account/" + id + "/bankAccount")
                .method("POST")
                .headers(headers)
                .body("{\n" +
                        "    \"bankAccountId\": \"101\",\n" +
                        "    \"bankName\": \"ziraat\",\n" +
                        "    \"iban\": \"1232132\",\n" +
                        "    \"balance\": {\n" +
                        "        \"currency\": \"TL\",\n" +
                        "        \"amount\": \"100\"\n" +
                        "    }\n" +
                        "}")
                .willRespondWith()
                .status(201)
                .headers(headers)
                .body("{\n" +
                        "    \"bankAccountId\": \"101\",\n" +
                        "    \"bankName\": \"ziraat\",\n" +
                        "    \"iban\": \"1232132\",\n" +
                        "    \"balance\": {\n" +
                        "        \"currency\": \"TL\",\n" +
                        "        \"amount\": \"100\"\n" +
                        "    }\n" +
                        "}")
                .toPact();

    }

    @Test
    @PactVerification()
    public void doTest() {

        String st = "{\n" +
                "    \"bankAccountId\": \"101\",\n" +
                "    \"bankName\": \"ziraat\",\n" +
                "    \"iban\": \"1232132\",\n" +
                "    \"balance\": {\n" +
                "        \"currency\": \"TL\",\n" +
                "        \"amount\": \"100\"\n" +
                "    }\n" +
                "}";
        // JSONObject jsonObj = new JSONObject(st);
        System.setProperty("pact.rootDir", "../pacts");  // Change output dir for generated pact-files
        ResponseEntity<String> eta = new BankAccountConsumer(provider.getPort()).createBankAccount("2", st);

    }

}
