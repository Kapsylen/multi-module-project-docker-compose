package sesvdev.producerapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import sesvdev.producerapi.api.RegisterUserDto;
import sesvdev.producerapi.api.UserRegisteredPayload;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@Slf4j
public class ProduceMessageService {

    static String QUEUE_NAME = "user-registration";
    private final RabbitTemplate rabbitTemplate;

    public ProduceMessageService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public Map<String, String> registerUser(RegisterUserDto registerUserDto) throws JsonProcessingException {
        Random random = new Random();
        int confirmationCode = random.nextInt(900000) + 100000;

        UserRegisteredPayload queuePayload = new UserRegisteredPayload(
                registerUserDto.name(),
                registerUserDto.email(),
                confirmationCode
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String queuePayloadString = objectMapper.writeValueAsString(queuePayload);

        rabbitTemplate.convertAndSend(QUEUE_NAME, queuePayloadString);

        Map<String, String> response = new HashMap<>();
        response.put("message", "User registered successfully!");
        return response;
    }
}