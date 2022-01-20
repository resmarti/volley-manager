package ch.volleymanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
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
    private String gender;
    private boolean isCoach;
    private boolean isPlayer;
    @ManyToOne
    private ContactPerson contactPerson;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @LazyCollection (LazyCollectionOption.FALSE)
    private Set<Team> teams = new HashSet<>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Event> events = new HashSet<>();

    public TeamMember(){
    }

    public TeamMember(Long id,
                      String firstName,
                      String lastName,
                      String street,
                      String streetNb,
                      int postalCode,
                      String location,
                      String email,
                      String mobile,
                      LocalDate dateOfBirth,
                      String gender,
                      ContactPerson contactPerson,
                      Set<Team> teams,
                      boolean isCoach,
                      boolean isPlayer
    ) {
        super(id, firstName, lastName, street, streetNb, postalCode, location, email, mobile);
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactPerson = contactPerson;
        this.teams = teams;
        this.isCoach = isCoach;
        this.isPlayer = isPlayer;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public void removeContactPerson() {
        this.contactPerson = null;
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

    public boolean isIsPlayer() {
        return isPlayer;
    }

    public void setIsPlayer(boolean player) {
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
