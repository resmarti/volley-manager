package ch.volleymanager.resource;

import ch.volleymanager.domain.ContactPerson;
import ch.volleymanager.service.ContactPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactperson")
public class ContactPersonResource {
    private final ContactPersonService contactPersonService;

    public ContactPersonResource(ContactPersonService contactPersonService) {
        this.contactPersonService = contactPersonService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ContactPerson>> getAllContactPersons(){
        List<ContactPerson> contactPersons = contactPersonService.findAllContactPersons();
        return new ResponseEntity<>(contactPersons, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ContactPerson> updateContactPerson(@RequestBody ContactPerson contactPerson) {
        ContactPerson updateContactPerson = contactPersonService.updateContactPerson(contactPerson);
        return new ResponseEntity<>(updateContactPerson, HttpStatus.OK);
    }

    @PostMapping("/addnewtoteammember/{teammemberid}")
    public ResponseEntity<ContactPerson> assignNewContactPersonToTeamMember(@RequestBody ContactPerson contactPerson, @PathVariable("teammemberid") Long teammemberid) {
        ContactPerson newContactPerson = contactPersonService.assignNewContactPersonToTeamMember(contactPerson, teammemberid);
        return new ResponseEntity<>(newContactPerson, HttpStatus.CREATED);
    }

    @PutMapping("/addexistingtoteammeber/{contactpersonid}/{teammemberid}")
    public ResponseEntity<?> assignExistingContactPersonToTeamMember(@PathVariable Long contactpersonid, @PathVariable("teammemberid") Long teammemberid) {
        contactPersonService.assignExistingContactPersonToTeamMember(contactpersonid, teammemberid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
