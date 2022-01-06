package ch.volleymanager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Coach extends AbstractPerson {
    @Column (nullable = false)
    private String degree;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Player> players;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Event> events;

    //default contstructor
    public Coach (String degree){
        degree = this.degree;
    }

    //empty constructor
    public Coach (){
    }

    //Getter and Setter methods
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
