package ch.volleymanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TeamMember extends AbstractPerson {

    @Column
    private LocalDate dateOfBirth;
    private boolean isCoach;
    private boolean isPlayer;
    @ManyToOne
    private ContactPerson contactPerson;
    @JsonIgnore
    @ManyToMany
    @LazyCollection (LazyCollectionOption.FALSE)
    private Set<Team> teams = new HashSet<>();
    @JsonIgnore
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Event> events = new HashSet<>();

    public TeamMember(){
    }

    public TeamMember(Long id,
                      String firstName,
                      String lastName,
                      String street,
                      int streetNb,
                      int postalCode,
                      String location,
                      String email,
                      String mobile,
                      LocalDate dateOfBirth,
                      ContactPerson contactPerson,
                      Set<Team> teams,
                      boolean isCoach,
                      boolean isPlayer
    ) {
        super(id, firstName, lastName, street, streetNb, postalCode, location, email, mobile);
        this.dateOfBirth = dateOfBirth;
        this.contactPerson = contactPerson;
        this.teams = teams;
        this.isCoach = isCoach;
        this.isPlayer=isPlayer;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public boolean isIsCoach() {
        return isCoach;
    }

    public void setIsCoach(boolean coach) {
        isCoach = coach;
    }

    public boolean isPlayer() {
        return isPlayer;
    }

    public void setPlayer(boolean player) {
        isPlayer = player;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public int calculateAge () {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public void addTeam(Team team) {
        if (teams == null) teams = new HashSet<>();
        teams.add(team);
    }

    public void addEvent(Event event) {
        if (events == null) events = new HashSet<>();
        events.add(event);
    }
}
