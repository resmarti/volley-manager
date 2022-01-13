package ch.volleymanager.exception;

public class UserCanNotBeDeleted extends RuntimeException {
    public UserCanNotBeDeleted (String message) {
        super(message);

    }
}
