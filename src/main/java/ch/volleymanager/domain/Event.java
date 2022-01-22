package ch.volleymanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Event_Table")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long eventId;
    @Column(name = "Event_name", nullable = false, updatable = true)
    private String eventName;
    @Column(name = "Event_date", nullable = false, updatable = true)
    private LocalDate eventDate;
    @Column(name = "Ort", nullable = false, updatable = true)
    private String eventLocation;
    @Column(name = "Number_of_helper", nullable = false, updatable = true)
    private int numberOfHelpersNeeded;
    @Column(name = "Enough_helpers", nullable = false, updatable = true)
    private boolean numberOfHelpersOK;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(), inverseJoinColumns = @JoinColumn)
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<TeamMember> teamMembers;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(), inverseJoinColumns =@JoinColumn)
    @JsonIgnore
    @LazyCollection (LazyCollectionOption.FALSE)
    private Set<Team> teams;

    public Event(Long eventId, String eventName, LocalDate eventDate, String eventLocation, int numberOfHelpersNeeded,
                 boolean numberOfHelpersOK, Set<TeamMember> teamMembers, Set<Team> teams) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.numberOfHelpersNeeded = numberOfHelpersNeeded;
        this.numberOfHelpersOK = numberOfHelpersOK;
        this.teamMembers = teamMembers;
        this.teams = teams;
    }

    public Event() {
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

    public Set<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(Set<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
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

    public void addTeam(Team team) {
        if (teams == null) teams = new HashSet<>();
        teams.add(team);
    }

    public void addTeamMember(TeamMember teamMember) {
        if (teamMembers == null) teamMembers = new HashSet<>();
        teamMembers.add(teamMember);
    }
}
