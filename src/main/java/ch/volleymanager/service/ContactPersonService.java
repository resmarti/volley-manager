package ch.volleymanager.service;
import ch.volleymanager.domain.ContactPerson;
import ch.volleymanager.domain.TeamMember;
import ch.volleymanager.exception.TeamNotFoundException;
import ch.volleymanager.exception.UserCanNotBeDeleted;
import ch.volleymanager.repo.TeamMemberRepo;
import ch.volleymanager.exception.ContactPersonNotDeletable;
import ch.volleymanager.exception.UserNotFoundException;
import ch.volleymanager.repo.ContactPersonRepo;
import ch.volleymanager.repo.TeamMemberRepo;
import ch.volleymanager.resource.dto.ContactPersonDto;
import ch.volleymanager.utils.HasLogger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContactPersonService implements HasLogger {
    private final ContactPersonRepo contactPersonRepo;
    private final TeamMemberRepo teamMemberRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public ContactPersonService(ContactPersonRepo contactPersonRepo, TeamMemberRepo teamMemberRepo) {
        this.contactPersonRepo = contactPersonRepo;
        this.teamMemberRepo=teamMemberRepo;
    }

    public List<ContactPerson> findAllContactPersons() {
        return contactPersonRepo.findAll();
    }

    public ContactPerson updateContactPerson(ContactPerson contactPerson) {
        return contactPersonRepo.save(contactPerson);
    }

    public ContactPerson assignNewContactPersonToTeamMember(ContactPerson contactPerson, Long teamMemberId) {
        teamMemberRepo.findByIdWithEagerRelationships(teamMemberId).ifPresent(teamMember -> {
            teamMember.setContactPerson(contactPerson);
            contactPerson.addTeamMember(teamMember);
            teamMemberRepo.save(teamMember);
            contactPersonRepo.save(contactPerson);
        });
        return contactPerson;
    }

    public void assignExistingContactPersonToTeamMember(Long contactPersonId, Long teamMemberId) {

        contactPersonRepo.findByIdWithEagerRelationships(contactPersonId).ifPresent(contactPerson -> {
            teamMemberRepo.findByIdWithEagerRelationships(teamMemberId).ifPresent(teamMember -> {
                teamMember.setContactPerson(contactPerson);
                contactPerson.addTeamMember(teamMember);
                teamMemberRepo.save(teamMember);
                contactPersonRepo.save(contactPerson);
            });
        });

    }

    public void removeContactPersonFromTeamMember(long contactPersonId, Long teamMemberId) {
        contactPersonRepo.findByIdWithEagerRelationships(contactPersonId).ifPresent(contactPerson -> {
            teamMemberRepo.findByIdWithEagerRelationships(teamMemberId).ifPresent(teamMember -> {
                contactPerson.removeTeamMember(teamMember);
                contactPersonRepo.save(contactPerson);
                teamMemberRepo.save(teamMember);
                //Delete contactPerson if it is orphaned
                if (contactPerson.getTeamMembers().size()==0) {
                    contactPersonRepo.delete(contactPerson);
                }
            });
        });
    }

    //Todo: ContactPerson can only be deleted when no player is attached
    public void deleteContactPersonById(Long id) throws ContactPersonNotDeletable {
        ContactPerson contactPerson = contactPersonRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException());

        if (contactPerson.getTeamMembers().isEmpty()){
            contactPersonRepo.delete(contactPerson);
        } else {
            throw new ContactPersonNotDeletable("Kontaktperson ist noch mit Teammitglied verbunden und kann deswegen nicht gelöscht werden");
        }

        //Find Player by Id
        TeamMember teamMember = teamMemberRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException());

    }

    public ContactPerson addContactPersonToMember(Long memberId, boolean shouldUseTheSameAddress) {
        TeamMember teamMember = teamMemberRepo.findById(memberId).orElseThrow(() -> new UserNotFoundException());

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

    private ContactPersonDto convertToDto(ContactPerson contactPerson) {
        return modelMapper.map(contactPerson, ContactPersonDto.class);
    }

    private ContactPerson convertToEntity(ContactPersonDto contactPersonDto) {
        return modelMapper.map(contactPersonDto, ContactPerson.class);
    }

    public ContactPerson findContactPersonById(Long id){
        return contactPersonRepo.findById(id)
                .orElseThrow(() -> new TeamNotFoundException("Team " + id + "konnte nicht gefunden werden"));
    }


 /*   public void removeContactPersonFromMember(Long teammemberid, long contactpersonid) {
        ContactPerson contactPerson = findContactPersonById(contactpersonid);
        Long teammemberId = contactPerson.getId();
        TeamMember teamMember = findContactPersonById(contactpersonid);
        List<ContactPerson> foundContactPerson = teamMember.getTeamMembers().stream()
                .fiter(member -> Objects.equals(member.getId(), memberId))
                .collection(Collectors.toList());
        if(foundContactPerson.size()>0){
            Set<ContactPerson> contactpersons = teamMember.getContactPerson();
            Set<TeamMember> teammembers = teamMember.getTeamMember();
            teammembers = teammembers.stream()
                    .filter(t -> !t.getTeamMemberId().equals(teamemberid))
                    .collect(Collectors.toSet());

            contactPerson.setTeamMembers(teammembers);
            teamMember.setContacPerson(contactPerson);

            teamMemberRepo.save(teamMember);
            teamMemberRepo.save(contactPerson);
            return teammembers;
        }
        throw new UserCanNotBeDeleted();


        }

  */

}
