package sesvdev.producerapi.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sesvdev.producerapi.service.ProduceMessageService;

import java.util.Map;

@RestController
@AllArgsConstructor
public class ProduceMessageController {

    ProduceMessageService produceMessageService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody RegisterUserDto registerUserDto) throws JsonProcessingException {
        // TODO save user in the database

        var response = produceMessageService.registerUser(registerUserDto);

        return ResponseEntity.ok(response);
    }
}