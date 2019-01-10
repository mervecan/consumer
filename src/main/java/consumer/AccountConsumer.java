package consumer;

import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class AccountConsumer {
    JSONObject jsonObject;
    int port = 9000;

    public AccountConsumer() {

    }

    public AccountConsumer(int port) {
        this.port = port;
    }

    public String createAccount(JSONObject account) {
        RestTemplate restTemplate = new RestTemplate();

        String urlString = "http://localhost:" + port + "/account";


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(account.toString(), headers);

        ResponseEntity<String> answer = restTemplate.exchange(
                urlString,
                HttpMethod.POST,
                entity,
                String.class);
        System.out.println("Mock Port from Pact: " + port);
        System.out.println(answer);
        return String.valueOf(answer.getBody());
    }

    public String updateAccount(String id, JSONObject account) {
        RestTemplate restTemplate = new RestTemplate();

        String urlString = "http://localhost:" + port + "/account";


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(account.toString(), headers);

        ResponseEntity<String> answer = restTemplate.exchange(
                urlString,
                HttpMethod.POST,
                entity,
                String.class);
        System.out.println("Mock Port from Pact: " + port);
        System.out.println(answer);
        return String.valueOf(answer.getBody());
    }

    public void deleteAccount() {

    }

    public String retrieveAccount(String id) {
        RestTemplate restTemplate = new RestTemplate();

        String urlString = "http://localhost:" + port + "/account/" + id;


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
