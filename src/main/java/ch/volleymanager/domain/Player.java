package ch.volleymanager.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Player extends AbstractPerson {

    @Column(nullable = false)
    private String dateOfBirth;
    @ManyToOne
    @JoinColumn(name="contact_person_id")
    private ContactPerson contactPerson;
    @ManyToMany
    private Set<Coach> coaches;

    public Player(){
    }

    public Player(Long id, String firstName, String lastName, String street, int streetNb, int postalCode, String location, String dateOfBirth, ContactPerson contactPerson, Set<Coach> coaches) {
        super(id, firstName, lastName, street, streetNb, postalCode, location);
        this.dateOfBirth = dateOfBirth;
        this.contactPerson = contactPerson;
        this.coaches = coaches;
    }

    public Player(String dateOfBirth, ContactPerson contactPerson, Set<Coach> coaches) {
        this.dateOfBirth = dateOfBirth;
        this.contactPerson = contactPerson;
        this.coaches = coaches;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Set<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(Set<Coach> coaches) {
        this.coaches = coaches;
    }
}
