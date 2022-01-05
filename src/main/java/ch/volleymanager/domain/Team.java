package ch.volleymanager.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long teamId;
    @Column(nullable = false, updatable = true)
    private int maxAge;
    @Column (nullable = false, updatable = true)
    @ManyToMany
    private Set <Event> events;
    @ManyToMany
    private Set <Player> players;
    @ManyToMany
    private Set <Coach> coaches;

    //Contructor
    public Team(long teamId, int maxAge) {
        this.teamId = teamId;
        this.maxAge = maxAge;
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

}
