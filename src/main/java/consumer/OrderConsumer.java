package consumer;

import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class OrderConsumer {
    int port = 9000;

    public OrderConsumer() {

    }

    public OrderConsumer(int port) {
        this.port = port;
    }


    public ResponseEntity<String> createOrder(String id, JSONObject order) {
        RestTemplate restTemplate = new RestTemplate();

        String urlString = "http://localhost:" + port + "/account/" + id + "/order";


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(order.toString(), headers);

        ResponseEntity<String> answer = restTemplate.exchange(
                urlString,
                HttpMethod.POST,
                entity,
                String.class);
        System.out.println("Mock Port from Pact: " + port);
        System.out.println(answer);
        return answer;
    }

    public String retrieveOrder(String id) {
        RestTemplate restTemplate = new RestTemplate();

        String urlString = "http://localhost:" + port + "/account/" + id + "/order";


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> answer = restTemplate.exchange(
                urlString,
                HttpMethod.GET,
                entity,
                String.class);


        System.out.println(answer.getBody());
        System.out.println("Mock Port from Pact: " + port);
        return String.valueOf(answer.getBody());
    }

}

