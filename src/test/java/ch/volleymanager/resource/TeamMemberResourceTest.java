package ch.volleymanager.resource;

import ch.volleymanager.AbstractTest;
import ch.volleymanager.repo.TeamMemberRepo;
import ch.volleymanager.resource.dto.TeamMemberDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TeamMemberResourceTest extends AbstractTest {

    @Autowired
    TeamMemberRepo teamMemberRepo;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    public void shouldGetTeamMemberListEager() throws Exception {
        String uri = "/teammember/all-eager";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String response = mvcResult.getResponse().getContentAsString();

        TeamMemberDto[] contactList = super.mapFromJson(response, TeamMemberDto[].class);
        assertTrue(contactList.length > 0);

    }

}
