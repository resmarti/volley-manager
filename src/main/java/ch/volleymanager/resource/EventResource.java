package ch.volleymanager.resource;
import ch.volleymanager.domain.Event;
import ch.volleymanager.domain.Team;
import ch.volleymanager.service.EventService;
import ch.volleymanager.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;


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


    @GetMapping("/add/{eventId}")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        Event newEvent = eventService.addEvent(event);
        return new ResponseEntity<>(newEvent, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEvent(@PathVariable("eventId") Long eventId) {
        eventService.deleteEventById(eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/update/{eventId}")
    public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
        Event updateEvent = eventService.updateEvent(event);
        return new ResponseEntity<>(updateEvent, HttpStatus.OK);
    }
    @PutMapping("/addTeamToEvent")
    public ResponseEntity<Team> addTeamToEvent(Long teamId, @RequestBody Event event) {
        eventService.addTeamToEvent(teamId, event);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
