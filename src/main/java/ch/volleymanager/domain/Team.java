package ch.volleymanager.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long teamId;
    private String teamName;
    @Column(nullable = false, updatable = true)
    private int maxAge;
    @Column (nullable = false, updatable = true)
    @ManyToMany
    private Set <Event> events;
    @ManyToMany
    private Set <TeamMember> teamMembers;


    //Contructor
    public Team(long teamId, int maxAge, String teamName, Set<Event> events, Set<TeamMember> teamMember) {
        this.teamId = teamId;
        this.maxAge = maxAge;
        this.teamName = teamName;
        this.events = events;
        this.teamMembers = teamMember;
   }
    //empty constructor for the DB
    public Team(){
         }

    //Getter and Setter methods
    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
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
}
