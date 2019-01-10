package consumer;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class BankAccountConsumer {
    int port = 9000;

    public BankAccountConsumer() {

    }

    public BankAccountConsumer(int port) {
        this.port = port;
    }

    public ResponseEntity<String> createBankAccount(String id, String bankAccount) {
        RestTemplate restTemplate = new RestTemplate();

        String urlString = "http://localhost:" + port + "/account/" + id + "/bankAccount";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(bankAccount, headers);

        ResponseEntity<String> answer = restTemplate.exchange(
                urlString,
                HttpMethod.POST,
                entity,
                String.class);
        System.out.println("Mock Port from Pact: " + port);
        System.out.println(answer);
        return answer;
    }

    public ResponseEntity<String> retrieveBankAccount(String id) {
        RestTemplate restTemplate = new RestTemplate();

        String urlString = "http://localhost:" + port + "/account/" + id + "/bankAccount";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> answer = restTemplate.exchange(
                urlString,
                HttpMethod.GET,
                entity,
                String.class);
        System.out.println(answer);
        return answer;
    }
}
