package consumerTest;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import consumer.AccountConsumer;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AccountRetrieveTest {
    String id = "1";
    @Rule
    public PactProviderRuleMk2 provider = new PactProviderRuleMk2("Provider", this);

    @Pact(consumer = "retrieveAccount")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json");


        return builder
                .given("retrieveAccount")
                .uponReceiving("a request")
                .path("/account/" + id)
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body("{\"id\":\"1\",\"customer\":{\"businessName\":\"merve\",\"businessUrl\":\"iyte.edu.tr\",\"country\":\"TR\",\"email\":\"mervecan@std.iyte.edu.tr\",\"address\":{\"country\":\"TR\",\"city\":\"Izmir\",\"line\":\"Gulbahce\",\"postalCode\":\"35430\"},\"id\":null},\"bankAccounts\":[{\"bankAccountId\":null,\"account\":null,\"bankName\":\"Is bankasi\",\"iban\":\"1111111111111\",\"balance\":{\"currency\":\"TL\",\"amount\":\"500\"}}],\"creditCards\":[{\"creditCardId\":\"200\",\"account\":null,\"brand\":\"VISA\",\"cardNumber\":\"222321314\",\"expMonth\":\"12\",\"expYear\":\"23\",\"balance\":{\"currency\":\"TL\",\"amount\":\"-200\"}}],\"createdTime\":\"12.10.2018\",\"orders\":[{\"orderId\":\"300\",\"amount\":\"400\",\"products\":[{\"productId\":\"500\",\"name\":\"pencil\",\"definition\":\"versatil\",\"price\":\"130\"},{\"productId\":\"501\",\"name\":\"book\",\"definition\":\"textbook\",\"price\":\"270\"},{\"productId\":\"502\",\"name\":\"notebook\",\"definition\":\"notebook\",\"price\":\"100\"}],\"status\":\"PAID\"}]}\n")
                .toPact();

    }

    @Test
    @PactVerification()
    public void doTest() {
        System.setProperty("pact.rootDir", "../pacts");  // Change output dir for generated pact-files
        String eta = new AccountConsumer(provider.getPort()).retrieveAccount(id);

    }

}
