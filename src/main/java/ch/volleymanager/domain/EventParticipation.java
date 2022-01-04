package ch.volleymanager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class EventParticipation {
    @Column(nullable = false, updatable = true)
    private boolean hasParticipated;
    @ManyToMany
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
