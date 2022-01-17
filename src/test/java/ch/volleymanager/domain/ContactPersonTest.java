package ch.volleymanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactPersonTest {

    @Test
    void toStringVerifier() throws Exception {
        ContactPerson cp = new ContactPerson();
        cp.setId(1L);
        cp.setFirstName("Felix");
        cp.setLastName("Muster");
        cp.setLocation("Aarau");
        cp.setPostalCode(5000);
        cp.setStreet("Bahnhofstrasse");
        cp.setStreetNb("1");
        cp.addTeamMember(
                new TeamMember(
                        null,
                        "Anna",
                        "Muster",
                        "Bahnhofstrasse",
                        "1",
                        5000,
                        "Aarau",
                        "email",
                        "mobile",
                        LocalDate.of(2008, 3, 3),
                        "f",
                        null,
                        null,
                        false,
                        false
                )
        );

        String temp = "AbstractPerson{id=1,firstName='Felix',lastName='Muster',street='Bahnhofstrasse',streetNb ='1',postalCode='5000',location='Aarau'}";
        assertThat(temp).isEqualTo(cp.toString());

    }
}
