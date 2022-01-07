package ch.volleymanager.service;
import ch.volleymanager.domain.ContactPerson;
import ch.volleymanager.domain.TeamMember;
import ch.volleymanager.exception.ContactPersonNotDeletable;
import ch.volleymanager.exception.UserNotFoundException;
import ch.volleymanager.repo.ContactPersonRepo;
import ch.volleymanager.repo.TeamMemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ContactPersonService {
    private final ContactPersonRepo contactPersonRepo;
    private final TeamMemberRepo teamMemberRepo;

@Autowired
public ContactPersonService(ContactPersonRepo contactPersonRepo, TeamMemberRepo teamMemberRepo) {
    this.contactPersonRepo = contactPersonRepo;
    this.teamMemberRepo=teamMemberRepo;
}

    //Todo: ContactPerson can only be deleted when no player is attached
    public void deleteContactPersonById(Long id) throws ContactPersonNotDeletable {
        ContactPerson contactPerson = contactPersonRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Kontaktperson wurde nicht gefunden"));

        if (contactPerson.getTeamMembers().isEmpty()){
            contactPersonRepo.delete(contactPerson);
        } else {
            throw new ContactPersonNotDeletable("Kontaktperson ist noch mit Teammitglied verbunden und kann deswegen nicht gelöscht werden");
        }

        //Find Player by Id
        TeamMember teamMember = teamMemberRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Die Person mit der ID " + id + " wurde nicht gefunden."));

    }

    public ContactPerson addContactPersonToMember(Long memberId, boolean shouldUseTheSameAddress) {
        TeamMember teamMember = teamMemberRepo.findById(memberId).orElseThrow(() -> new UserNotFoundException("contactPerson Not Found"));

        ContactPerson contactPerson = new ContactPerson();
        contactPerson.getTeamMembers().add(teamMember);
        if (shouldUseTheSameAddress) {
            contactPerson.setPostalCode(teamMember.getPostalCode());
            contactPerson.setLocation(teamMember.getLocation());
            contactPerson.setStreet(teamMember.getStreet());
            contactPerson.setStreetNb(teamMember.getStreetNb());
        }

        return contactPersonRepo.save(contactPerson);
    }

}
