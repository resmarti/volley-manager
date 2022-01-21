package ch.volleymanager.service;
import ch.volleymanager.domain.Event;
import ch.volleymanager.exception.EventNotDeletable;
import ch.volleymanager.repo.EventRepo;
import ch.volleymanager.repo.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EventService {
    private final EventRepo eventRepo;
    private final TeamRepo teamRepo;

    @Autowired
    public EventService(EventRepo eventRepo, TeamRepo teamRepo){
        this.eventRepo=eventRepo;
        this.teamRepo = teamRepo;
    }

    public Event addEvent(Event event){
        return eventRepo.save(event);
    }

    public List<Event> findAllEvents() {
        return eventRepo.findAll();
    }

    //TODO: @Res: Funktoniert diese Methode?
    public Optional<Event> findEventById(Long eventId) {
        return eventRepo.findById((eventId));
    }

    public Event updateEvent (Event event){
        return eventRepo.save(event);
    }

    public void deleteEventById(Long eventid) throws EventNotDeletable {
        Event event = eventRepo.findById(eventid)
                .orElseThrow(() -> new EventNotDeletable("Der Event mit der ID " + eventid + "kann nicht gelöscht werden."));
        if(event.getEventValid()) {
            eventRepo.deleteById(eventid);
        }
    }

}
