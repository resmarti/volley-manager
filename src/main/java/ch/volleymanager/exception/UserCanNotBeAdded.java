package ch.volleymanager.exception;

public class UserCanNotBeAdded extends RuntimeException {
    public UserCanNotBeAdded(String message) {
        super(message);
    }
}
