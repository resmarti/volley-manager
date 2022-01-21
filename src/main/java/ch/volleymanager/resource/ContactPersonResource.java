package ch.volleymanager.resource;

import ch.volleymanager.domain.ContactPerson;
import ch.volleymanager.domain.TeamMember;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ch.volleymanager.service.ContactPersonService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ContactPersonResource<contactpersonid> {
    private final ContactPersonService contanctpersonService;

    public ContactPersonResource(ContactPersonService contactPersonService){
        this.contanctpersonService = contactPersonService;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?>deleteContactPersonById(@PathVariable("id")Long contactpersonid){
        contanctpersonService.deleteContactPersonById(contactpersonid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //TODO: @Res: Kannst du schauen ob das funktioniert?
    @PutMapping("addcontactpersontomember")
    public ResponseEntity<ContactPerson> addContactPersonToMember(Long memberId, @RequestBody TeamMember teamMember){
    contanctpersonService.addContactPersonToMember(memberId, true);
    return new ResponseEntity(HttpStatus.OK);

    }

}
