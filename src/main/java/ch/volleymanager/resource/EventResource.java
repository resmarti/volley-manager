package ch.volleymanager.resource;
import ch.volleymanager.domain.Event;
import ch.volleymanager.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;


public class EventResource {
    private final EventService eventService;

    public EventResource(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.findAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    // TODO: findEventById implementation
    @GetMapping("/find/{id}")
    public ResponseEntity<Event> findEventById(@PathVariable("id") Long id) {
        List <Event> events = eventService.findEventById(id);
        return new ResponseEntity<Event>((Event) events, HttpStatus.OK);
    }


    @GetMapping("/add/{eventId}")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        Event newEvent = eventService.addEvent(event);
        return new ResponseEntity<>(newEvent, HttpStatus.CREATED);
    }

    @GetMapping("/delete")
    public ResponseEntity<?> deleteEvent(@PathVariable("eventId") Long eventId) {
        eventService.deleteEventById(eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/update/{eventId}")
    public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
        Event updateEvent = eventService.updateEvent(event);
        return new ResponseEntity<>(updateEvent, HttpStatus.OK);
    }

   /* @GetMapping("/removeTeamMemberFromEvent/{id}")
    public ResponseEntity<?>removeTeamMemberFromEvent(@PathVariable("eventId")Long eventId){
        eventService.;
    }
*/
}
