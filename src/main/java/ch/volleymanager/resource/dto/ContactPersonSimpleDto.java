package ch.volleymanager.resource.dto;

import ch.volleymanager.domain.AbstractPerson;

import java.util.HashSet;
import java.util.Set;

public class ContactPersonSimpleDto extends AbstractPerson {

    public ContactPersonSimpleDto(Long id, String firstName, String lastName, String street, String streetNb, int postalCode, String location, String email, String mobile) {
        super(id, firstName, lastName, street, streetNb, postalCode, location, email, mobile);
    }

    public ContactPersonSimpleDto() {
    }

}
