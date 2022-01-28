package ch.volleymanager.repository;

import ch.volleymanager.AbstractTest;
import ch.volleymanager.domain.ContactPerson;
import ch.volleymanager.repo.ContactPersonRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactPersonRepoTest extends AbstractTest {

    @Autowired
    ContactPersonRepo contactPersonRepo;

    private Long contactPersonId;
    private ContactPerson newPerson;

    @Override
    @BeforeEach
    public void setUp() {
        String jsonContact = readResource(new ClassPathResource("contact/contactPerson1.json"));
        try {
            newPerson = mapFromJson(jsonContact, ContactPerson.class);
            List<ContactPerson> persons = contactPersonRepo.findByFirstNameAndLastName(newPerson.getFirstName(), newPerson.getLastName());
            if (persons.isEmpty()) {
                newPerson = contactPersonRepo.save(newPerson);
                contactPersonId = newPerson.getId();
            } else {
                newPerson = persons.get(0);
                contactPersonId = persons.get(0).getId();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void shouldHaveAtLeastOneContact() throws Exception {
        List<ContactPerson> contactPersons = contactPersonRepo.findAll();
        assertTrue(contactPersons.size() > 0);
    }

    @Test
    public void shouldHaveAtLeastOneEagerContact() throws Exception {
        List<ContactPerson> contactPersons = contactPersonRepo.findAllWithEagerRelationships();
        assertTrue(contactPersons.size() > 0);
    }

    @Test
    public void shouldLoadOneEagerContact() throws Exception {
        contactPersonRepo.findByIdWithEagerRelationships(contactPersonId).ifPresent(contactPerson -> {
            try {
                assertEquals(mapToJson(newPerson), mapToJson(contactPerson));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
    }

}
