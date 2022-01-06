package ch.volleymanager.service;

import ch.volleymanager.domain.ContactPerson;
import ch.volleymanager.exception.ContactPersonNotDeletable;
import ch.volleymanager.exception.EventNotDeletable;
import ch.volleymanager.exception.UserNotFoundException;
import ch.volleymanager.repo.AbstractPersonRepo;
import ch.volleymanager.repo.ContactPersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ContactPersonService {
    private final ContactPersonRepo contactPersonRepo;

@Autowired
public ContactPersonService(ContactPersonRepo contactPersonRepo) {
    this.contactPersonRepo = contactPersonRepo;
}

    //Todo: ContactPerson can only be deleted when no player is attached
    public void deleteContactPersonById(Long id) throws ContactPersonNotDeletable {
        ContactPerson contactPerson = contactPersonRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("contactPerson Not Found"));

        if (contactPerson.getPlayers().isEmpty()){
            contactPersonRepo.delete(contactPerson);
        } else {
            throw new ContactPersonNotDeletable("Test");
        }
    }



}
