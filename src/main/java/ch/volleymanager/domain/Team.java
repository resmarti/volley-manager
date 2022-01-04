package ch.volleymanager.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long teamId;
    @ElementCollection
    @ManyToMany
    private List<String> league =  new ArrayList<String>();
    private int maxAge;
    @ElementCollection
    @ManyToMany
    private List <String> sex =  new ArrayList<String>();
}
