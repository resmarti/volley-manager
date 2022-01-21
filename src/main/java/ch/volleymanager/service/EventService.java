package ch.volleymanager.service;
import ch.volleymanager.domain.Event;
import ch.volleymanager.domain.Team;
import ch.volleymanager.domain.TeamMember;
import ch.volleymanager.exception.EventNotDeletable;
import ch.volleymanager.exception.UserCanNotBeDeleted;
import ch.volleymanager.exception.UserNotFoundException;
import ch.volleymanager.repo.EventRepo;
import ch.volleymanager.repo.TeamMemberRepo;
import ch.volleymanager.repo.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class EventService {
    private final EventRepo eventRepo;
    private final TeamRepo teamRepo;
    private final TeamService teamService;

    @Autowired
    public EventService(EventRepo eventRepo, TeamRepo teamRepo,
                        TeamService teamService){
        this.eventRepo=eventRepo;
        this.teamRepo = teamRepo;
        this.teamService = teamService;
    }

    public Event addEvent(Event event){
        return eventRepo.save(event);
    }

    public List<Event> findAllEvents() {
        return eventRepo.findAll();
    }

        public Event findEventById(Long eventid) {
        return eventRepo.findById(eventid).orElseThrow(()-> new UserNotFoundException());
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


    public Set<Event> addTeamToEvent(Long id, Event event) {
        Team team = teamService.findTeamById(id);
        team.getEvents().add(event);
        event.getTeams().add(team);
        return team.getEvents();
    }

    // Searches the teams assigned to the event and decouples the connection
    public void removeTeamFromEvent(Long teamid, Long eventid){
        Event event = findEventById(eventid);
        Long randomId = event.getEventId();
        Team team = teamService.findTeamById(teamid);
        List<Event> foundEvents = team.getEvents().stream()
                .filter(id -> Objects.equals(id.getEventId(), randomId))
                .collect(Collectors.toList());
        if (foundEvents.size() > 0) {
           Set<Event> events = team.getEvents();
           events = events.stream()
                   .filter(eventId -> !eventId.getEventId().equals(randomId))
                   .collect(Collectors.toSet());

            Set<Team> teams = event.getTeams();
            teams = teams.stream()
                    .filter(t -> !t.getTeamId().equals(teamid))
                    .collect(Collectors.toSet());

            team.setEvents(events);
            event.setTeams(teams);

            eventRepo.save(event);
            teamRepo.save(team);
            return;
        }
        throw new UserCanNotBeDeleted();

    }


}
