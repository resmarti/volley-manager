package ch.volleymanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ContactPerson extends AbstractPerson {

    public ContactPerson(Long id, String firstName, String lastName, String street, int streetNb, int postalCode, String location, String email, String mobile) {
        super (id, firstName, lastName, street, streetNb, postalCode, location, email, mobile);
    }

    public ContactPerson(){
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contactPerson", orphanRemoval = true, cascade = CascadeType.ALL )
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private Set<TeamMember> teamMembers = new HashSet<>();

    public Set<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(Set<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public void addTeamMember(TeamMember teamMember) {
        teamMembers.add(teamMember);
    }
}
