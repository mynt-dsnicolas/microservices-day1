package ph.apper.account;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(ph.apper.account.App.class);

    @RestController
    @RequestMapping("account")
    public static class AccountController {

        @PostMapping
        public ResponseEntity create(@RequestBody Request request){
            LOGGER.info(String.valueOf(request));
            return ResponseEntity.ok().build();

        }

        @Data
        public static class Request {
            private String firstName;
            private String lastName;
            private String email;
            private String password;
        }
    }


}
