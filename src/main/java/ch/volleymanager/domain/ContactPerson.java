package ch.volleymanager.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ContactPerson extends AbstractPerson {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contactPerson")
    private Set<TeamMember> teamMembers;

    public Set<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(Set<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }
}
