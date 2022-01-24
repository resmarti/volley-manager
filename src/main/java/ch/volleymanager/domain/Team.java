package ch.volleymanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long teamId;
    @Column(nullable = false, updatable = true)
    private String teamName;
    @Column(nullable = false, updatable = true)
    private int maxAge;
    @Column (nullable = false, updatable = true)
    @ManyToMany (fetch = FetchType.EAGER)
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set <Event> events = new HashSet<>();
    @ManyToMany(mappedBy = "teams", fetch = FetchType.EAGER)
    @JsonIgnore
    @LazyCollection (LazyCollectionOption.FALSE)
    private Set <TeamMember> teamMembers = new HashSet<>();


    //Contructor
    public Team(Long teamId,
                int maxAge,
                String teamName,
                Set<Event> events,
                Set<TeamMember> teamMembers) {
        this.teamId = teamId;
        this.maxAge = maxAge;
        this.teamName = teamName;
        this.events = events;
        this.teamMembers = teamMembers;
   }
    //empty constructor for the DB
    public Team(){
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

    public Set<TeamMember> getTeammembers() {
        return teamMembers;
    }

    public void setTeammembers(Set<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void addTeamMember(TeamMember teamMember) {
        if (teamMembers == null) teamMembers = new HashSet<>();
        teamMembers.add(teamMember);
    }

    public void addEvent(Event event) {
        if (events == null) events = new HashSet<>();
        events.add(event);
    }
}
