package ch.volleymanager.service;
import ch.volleymanager.domain.ContactPerson;
import ch.volleymanager.domain.TeamMember;
import ch.volleymanager.exception.TeamNotFoundException;
import ch.volleymanager.repo.TeamMemberRepo;
import ch.volleymanager.exception.ContactPersonNotDeletable;
import ch.volleymanager.exception.UserNotFoundException;
import ch.volleymanager.repo.ContactPersonRepo;
import ch.volleymanager.resource.dto.ContactPersonDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ContactPersonService {
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

    public void assignExistingContactPersonToTeamMember(Long contactId, Long teamMemberId) {

        contactPersonRepo.findByIdWithEagerRelationships(contactId).ifPresent(contactPerson -> {
            teamMemberRepo.findByIdWithEagerRelationships(teamMemberId).ifPresent(teamMember -> {
                teamMember.setContactPerson(contactPerson);
                contactPerson.addTeamMember(teamMember);
                teamMemberRepo.save(teamMember);
                contactPersonRepo.save(contactPerson);
            });
        });

    }


    public void deleteContactPersonById(Long id) throws ContactPersonNotDeletable{
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

    public ContactPerson assignContactPersonToMember(Long memberId, boolean shouldUseTheSameAddress) {
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

    public TeamMember findTeamMemberById(Long id) {
        return teamMemberRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
    }

        }




