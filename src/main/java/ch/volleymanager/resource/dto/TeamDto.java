package ch.volleymanager.resource.dto;

import ch.volleymanager.domain.Event;
import java.util.HashSet;
import java.util.Set;

public class TeamDto {

    private Long teamId;
    private String teamName;
    private int maxAge;
    private Set<Event> events = new HashSet<>();
    private Set <TeamMemberDto> teamMembers = new HashSet<>();


    //Contructor
    public TeamDto(Long teamId, int maxAge, String teamName, Set<Event> events, Set<TeamMemberDto> teamMembers) {
        this.teamId = teamId;
        this.maxAge = maxAge;
        this.teamName = teamName;
        this.events = events;
        this.teamMembers = teamMembers;
    }
    //empty constructor for the DB
    public TeamDto(){
    }

    //Getter and Setter methods
    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Set<TeamMemberDto> getTeammembers() {
        return teamMembers;
    }

    public void setTeammembers(Set<TeamMemberDto> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void addTeamMember(TeamMemberDto teamMember) {
        if (teamMembers == null) teamMembers = new HashSet<>();
        teamMembers.add(teamMember);
    }

    public void addEvent(Event event) {
        if (events == null) events = new HashSet<>();
        events.add(event);
    }
}
