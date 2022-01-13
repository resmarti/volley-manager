package ch.volleymanager.resource.dto;

import ch.volleymanager.domain.AbstractPerson;
import java.util.HashSet;
import java.util.Set;

public class ContactPersonDto extends AbstractPerson {

    public ContactPersonDto(Long id, String firstName, String lastName, String street, int streetNb, int postalCode, String location) {
        super (id, firstName, lastName, street, streetNb, postalCode, location);
    }

    public ContactPersonDto(){
    }

    private Set<TeamMemberDto> teamMembers = new HashSet<>();

    public Set<TeamMemberDto> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(Set<TeamMemberDto> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public void addTeamMember(TeamMemberDto teamMember) {
        teamMembers.add(teamMember);
    }
}
