package ch.volleymanager.resource;
import ch.volleymanager.domain.Event;
import ch.volleymanager.domain.Team;
import ch.volleymanager.domain.TeamMember;
import ch.volleymanager.service.EventService;
import ch.volleymanager.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventResource {
    private final EventService eventService;
    private final TeamService teamService;

    public EventResource(EventService eventService, TeamService teamService) {
        this.eventService = eventService;
        this.teamService = teamService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.findAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Event> findEventById(@PathVariable("id") Long id) {
        Event events = eventService.findEventById(id);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        Event newEvent = eventService.addEvent(event);
        return new ResponseEntity<>(newEvent, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable("eventId") Long eventId) {
        eventService.deleteEventById(eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
        Event updateEvent = eventService.updateEvent(event);
        return new ResponseEntity<>(updateEvent, HttpStatus.OK);
    }

    @PutMapping("/addteamtoevent/{eventId}/{teamId}")
    public ResponseEntity<Team> addTeamToEvent(@PathVariable("eventId") Long eventId, @PathVariable("teamId") Long teamId) {
        eventService.addTeamToEvent(teamId, eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/addteammembertoevent/{eventId}/{teammemberId}")
    public ResponseEntity<TeamMember> addTeammemberToEvent(@PathVariable("eventId") Long eventId, @PathVariable("teammemberId") Long teammemberId) {
        eventService.addTeammemberToEvent(teammemberId, eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/removeteammemberfromevent/{eventId}/{teammemberId}")
    public ResponseEntity<TeamMember> removeTeammemberFromEvent(@PathVariable("eventId") Long eventId, @PathVariable("teammemberId") Long teammemberId) {
        eventService.removeTeammemberFromEvent(teammemberId, eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/removeteamfromevent/{eventId}/{teamId}")
    public ResponseEntity<Team> removeTeamFromEvent(@PathVariable("eventId") Long eventId, @PathVariable("teamId") Long teamId) {
        eventService.removeTeamFromEvent(teamId, eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
