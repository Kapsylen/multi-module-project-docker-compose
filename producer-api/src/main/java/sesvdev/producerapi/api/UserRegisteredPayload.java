package sesvdev.producerapi.api;

public record UserRegisteredPayload(String fullName, String emailAddress, int confirmationCode) {
}
