package ch.volleymanager.domain;

public class EventParticipation {
    private boolean hasParticipated;
    private Person person;

    public EventParticipation(boolean hasParticipated, Person person) {
        this.hasParticipated = hasParticipated;
        this.person = person;
    }

    public boolean isHasParticipated() {
        return hasParticipated;
    }

    public void setHasParticipated(boolean hasParticipated) {
        this.hasParticipated = hasParticipated;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
