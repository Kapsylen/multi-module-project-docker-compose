package sesvdev.consumerapi.service;

import org.springframework.stereotype.Component;

@Component
public class UserRegisteredListener {

    public void onMessageReceived(String message) {
        System.out.println("Received [" + message + "]");

        // TODO send an email using the data
    }
}
