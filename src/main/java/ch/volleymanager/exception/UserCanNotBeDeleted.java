package ch.volleymanager.exception;

public class UserCanNotBeDeleted extends RuntimeException {
    public UserCanNotBeDeleted () {
        super("User kann nicht gelöscht werden");

    }
}