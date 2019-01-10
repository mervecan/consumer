package consumer;

import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class CreditCardConsumer {
    int port = 9000;

    public CreditCardConsumer() {

    }

    public CreditCardConsumer(int port) {
        this.port = port;
    }

    public ResponseEntity<String> createCreditCard(String id, JSONObject creditCard) {

        RestTemplate restTemplate = new RestTemplate();

        String urlString = "http://localhost:" + port + "/account/" + id + "/creditCard";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(creditCard.toString(), headers);

        ResponseEntity<String> answer = restTemplate.exchange(
                urlString,
                HttpMethod.POST,
                entity,
                String.class);
        System.out.println(answer);
        return answer;
    }

    public ResponseEntity<String> retrieveCreditCard(String id) {
        RestTemplate restTemplate = new RestTemplate();

        String urlString = "http://localhost:" + port + "/account/" + id + "/creditCard";

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
