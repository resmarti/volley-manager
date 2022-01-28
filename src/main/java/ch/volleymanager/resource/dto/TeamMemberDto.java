package ch.volleymanager.resource.dto;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

public class TeamMemberDto extends AbstractPersonDto {

    private LocalDate dateOfBirth;
    private String gender;
    private boolean isCoach;
    private ContactPersonSimpleDto contactPerson;
    private Set<TeamSimpleDto> teams = new HashSet<>();
    private Set<EventSimpleDto> events = new HashSet<>();

    public TeamMemberDto(){
    }

    public TeamMemberDto(Long id, String firstName, String lastName, String street, String streetNb, int postalCode, String location,
                      LocalDate dateOfBirth, String gender, ContactPersonSimpleDto contactPerson, Set<TeamSimpleDto> teams, boolean isCoach) {
        super(id, firstName, lastName, street, streetNb, postalCode, location);
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactPerson = contactPerson;
        this.teams = teams;
        this.isCoach = isCoach;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() { return gender; }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ContactPersonSimpleDto getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPersonSimpleDto contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Set<TeamSimpleDto> getTeams() {
        return teams;
    }

    public void setTeams(Set<TeamSimpleDto> teams) {
        this.teams = teams;
    }

    public boolean isIsCoach() {
        return isCoach;
    }

    public void setIsCoach(boolean coach) {
        isCoach = coach;
    }

    public Set<EventSimpleDto> getEvents() {
        return events;
    }

    public void setEvents(Set<EventSimpleDto> events) {
        this.events = events;
    }

    public int calculateAge () {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public void addTeam(TeamSimpleDto team) {
        if (teams == null) teams = new HashSet<>();
        teams.add(team);
    }

    public void addEventDto(EventSimpleDto event) {
        if (events == null) events = new HashSet<>();
        events.add(event);
    }
}
