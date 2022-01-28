package ch.volleymanager.resource.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class EventDto {

    private Long eventId;
    private String eventName;
    private LocalDate eventDate;
    private String eventLocation;
    private int numberOfHelpersNeeded;
    private boolean numberOfHelpersOK;
    private Set<TeamMemberDto> teamMembers;
    private Set<TeamDto> teams;

    public EventDto(Long eventId, String eventName, LocalDate eventDate, String eventLocation, int numberOfHelpersNeeded,
                 boolean numberOfHelpersOK, Set<TeamMemberDto> teamMembers, Set<TeamDto> teams) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.numberOfHelpersNeeded = numberOfHelpersNeeded;
        this.numberOfHelpersOK = numberOfHelpersOK;
        this.teamMembers = teamMembers;
        this.teams = teams;
    }

    public EventDto() {
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public int getNumberOfHelpersNeeded() {
        return numberOfHelpersNeeded;
    }

    public void setNumberOfHelpersNeeded(int numberOfHelpersNeeded) {
        this.numberOfHelpersNeeded = numberOfHelpersNeeded;
    }

    public boolean isNumberOfHelpersOK() {
        return numberOfHelpersOK;
    }

    public void setNumberOfHelpersOK(boolean numberOfHelpersOK) {
        this.numberOfHelpersOK = numberOfHelpersOK;
    }

    //Event must be checked if it is already in the past or not
    public boolean getEventValid() {
        return this.eventDate.isBefore(LocalDate.now());
    }

    public Set<TeamMemberDto> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(Set<TeamMemberDto> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public Set<TeamDto> getTeams() {
        return teams;
    }

    public void setTeams(Set<TeamDto> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "Event{" +
                "Event ID=" + eventId +
                ", Event Name='" + eventName + '\'' +
                ", Event Datum ='" + eventDate + '\'' +
                ", Event Location='" + eventLocation + '\'' +
                '}';
    }

    public void addTeam(TeamDto team) {
        if (teams == null) teams = new HashSet<>();
        teams.add(team);
    }

    public void addTeamMember(TeamMemberDto teamMember) {
        if (teamMembers == null) teamMembers = new HashSet<>();
        teamMembers.add(teamMember);
    }
}

