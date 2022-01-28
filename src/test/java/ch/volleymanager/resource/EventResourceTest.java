package ch.volleymanager.resource;

import ch.volleymanager.AbstractTest;
import ch.volleymanager.domain.Event;
import ch.volleymanager.repo.EventRepo;
import ch.volleymanager.resource.dto.EventDto;
import ch.volleymanager.resource.dto.TeamMemberDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EventResourceTest extends AbstractTest{
    @Autowired
    EventRepo eventRepo;

    @Override
    @BeforeEach
    public void setUp(){super.setUp();}

    @Test
    public void shouldGetTeamMemberListEager() throws Exception{
        String url = "/event/all";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

    int status = mvcResult.getResponse().getStatus();
    assertEquals(200, status);
    String response = mvcResult.getResponse().getContentAsString();

    Event [] contactList = super.mapFromJson(response, Event[].class);
    assertTrue(contactList.length>0);
    }

}
