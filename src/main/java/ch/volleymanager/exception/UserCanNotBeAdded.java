package ch.volleymanager.exception;

public class UserCanNotBeAdded extends RuntimeException {
    public UserCanNotBeAdded() {
        super("User can not be added");
    }
}
