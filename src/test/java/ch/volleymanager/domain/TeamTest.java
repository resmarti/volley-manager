package ch.volleymanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class TeamTest {
    private Set <Event> events;

    @Test

    void toStringVerifier() throws Exception{
        Team t = new Team();
        t.setTeamId(1L);
        t.setMaxAge(20);
        t.setTeamName("U20 Junioren");
        t.setEvents(events);
        t.addTeamMember(
                new TeamMember(
                null,
                "Maria",
                "Kreis",
                "Im Kreis",
                "10a",
                5400,
                "Baden",
                "m.kreis@gmail.com",
                "+41 79 999 00 00",
                LocalDate.of(2005, 5, 30),
                "f",
                null,
                Collections.emptySet(),
                false,
                true
                )
        );
        t.addTeamMember(
                new TeamMember(
                        null,
                        "Veronika",
                        "Hugetobler",
                        "Auf der Mauer",
                        "169",
                        8000,
                        "Zürich",
                        "v.hugentobler@hotmail.com",
                        "+41 78 855 76 66",
                        LocalDate.of(2008, 10, 11),
                        "f",
                        null,
                        Collections.emptySet(),
                        false,
                        true
                )
        );

        new TeamMember(
                null,
                "Jasmin",
                "Von der Valle",
                "Hausstrasse",
                "4",
                5426,
                "Lengnau",
                "jvondervalle@hotmail.com",
                "+41 77 399 99 09",
                LocalDate.of(2007, 8, 5),
                "f",
                null,
                Collections.emptySet(),
                false,
                true
        );

        new TeamMember(
                null,
                "Nuria",
                "Hidalgo",
                "Strasse",
                "8",
                5425,
                "Endingen",
                "nuria@hidalgo.ch",
                "+41 77 199 89 09",
                LocalDate.of(2005, 8, 7),
                "f",
                null,
                Collections.emptySet(),
                false,
                true
        );

        new TeamMember(
                null,
                "Philippa",
                "Bovic",
                "Wegstrase",
                "8",
                5401,
                "Wettingen",
                "ph.bovic@gmail.com",
                "+41 77 100 11 11",
                LocalDate.of(2004, 12, 24),
                "f",
                null,
                Collections.emptySet(),
                false,
                true
        );


    }



}
