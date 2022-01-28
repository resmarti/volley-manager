package ch.volleymanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class TeamMemberTest {
    private Set<Team> teams;
    private Set<Event> events;
    private Set<ContactPerson> cp;
    private Object contactPersonTest;

    @Test
    void toStringVerifier() throws Exception{
    TeamMember tm = new TeamMember();
    tm.setTeams(teams);
    tm.setEvents(events);
    //tm.setContactPerson(ContactPersonTest contactPersonTest);
        tm.addTeam(
                new Team(
                null,
                15,
                "U15 Juniorinnen",
                Collections.emptySet(),
                Collections.emptySet()
                )
        );
        tm.addTeam(
                new Team(
                null,
                13,
                "U13 Juniorinnen",
                Collections.emptySet(),
                Collections.emptySet()
                )
        );
        tm.addEvent(
                new Event(
                        null,
                        "Heimturnier",
                        LocalDate.of(2022, 10, 10),
                        "Kanti Halle, 5400 Baden",
                        10,
                        false,
                        Collections.emptySet(),
                        Collections.emptySet()
                )
        );
    }
}



