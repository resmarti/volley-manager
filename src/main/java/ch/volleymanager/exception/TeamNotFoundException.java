package ch.volleymanager.exception;

public class TeamNotFoundException extends RuntimeException {
    public TeamNotFoundException(String message) {
            super(message);
    }
}
