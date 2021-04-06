package ph.apper.account;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(ph.apper.account.App.class);

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @RestController
    @RequestMapping("account")
    public static class AccountController {

        private final RestTemplate restTemplate;

        public AccountController(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }


        @PostMapping
        public ResponseEntity create(@RequestBody CreateAccountRequest request){
            LOGGER.info(String.valueOf(request));

            Activity activity = new Activity();
            activity.setAction("REGISTRATION");
            activity.setIdentifier("email=" + request.getEmail());

            ResponseEntity<Object> response
                = restTemplate.postForEntity("http://localhost:8087/activity", activity, Object.class);

            if (response.getStatusCode().is2xxSuccessful()){
                LOGGER.info("Success!");
            } else {
                LOGGER.error("Erro! " + response.getStatusCode());
            }

            return ResponseEntity.ok().build();

        }

        @Data
        public static class Activity {
            private String action;
            private String identifier;
        }

        @Data
        public static class CreateAccountRequest {
            private String firstName;
            private String lastName;
            private String email;
            private String password;
        }
    }


}
