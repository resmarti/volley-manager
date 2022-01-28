package ch.volleymanager.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User konnte nicht gefunden werden");
    }

}

