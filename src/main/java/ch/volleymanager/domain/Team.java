package ch.volleymanager.domain;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;

@Entity
public class Team {
    @ElementCollection
    @OneToMany
    private ArrayList<String> league =  new ArrayList<String>();
    private int maxAge;
    private ArrayList<String> sex =  new ArrayList<String>();
}
