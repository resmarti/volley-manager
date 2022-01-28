package ch.volleymanager.resource;

import ch.volleymanager.AbstractTest;
import ch.volleymanager.domain.Team;
import ch.volleymanager.repo.TeamRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TeamResourceTest extends AbstractTest {
    @Autowired
    TeamRepo teamRepo;

    @Override
    @BeforeEach
    public void setUp(){
        super.setUp();}

    @Test
    public void shouldGetTeamListEager() throws Exception{
        String uri = "/team/all-eager";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();


    int status = mvcResult.getResponse().getStatus();
    assertEquals(200, status);
    String response = mvcResult.getResponse().getContentAsString();

    Team[] team = super.mapFromJson(response, Team[].class);
    assertTrue(team.length>0);
        }


}
