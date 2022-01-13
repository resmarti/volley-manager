package ch.volleymanager.service;
import ch.volleymanager.domain.Event;
import ch.volleymanager.domain.Team;
import ch.volleymanager.exception.EventNotDeletable;
import ch.volleymanager.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class EventService {
    private final EventRepo eventRepo;

    @Autowired
    public EventService(EventRepo eventRepo){
        this.eventRepo=eventRepo;
    }

    public Event addEvent(Event event){
        return eventRepo.save(event);
    }

    public List<Event> findAllEvents() {
        return eventRepo.findAll();
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
