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
import org.springframework.context.annotation.Lazy;
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
    private final TeamMemberService teamMemberService;

    @Autowired
    public EventService(EventRepo eventRepo, @Lazy TeamRepo teamRepo, @Lazy TeamService teamService, @Lazy TeamMemberService teamMemberService){
        this.eventRepo=eventRepo;
        this.teamRepo = teamRepo;
        this.teamService = teamService;
        this.teamMemberService = teamMemberService;
    }

    public Event addEvent(Event event){
        return eventRepo.save(event);
    }

    public List<Event> findAllEvents() {
        return eventRepo.findAllByOrderByEventDateAsc();
    }

    public Event findEventById(Long eventid) {
        return eventRepo.findById(eventid).orElseThrow(()-> new UserNotFoundException());
    }

    public Event updateEvent (Event event){
        return eventRepo.save(event);
    }

    public void deleteEventById(Long eventid) throws EventNotDeletable {
        Optional<Event> event = eventRepo.findById(eventid);
        if(event.isPresent()) {
            //remove from each team that is connect to event
            Set<Team> teams = event.get().getTeams();
            teams.forEach(team -> this.removeTeamFromEvent(team.getTeamId(), event.get().getEventId()));
            //remove from each teammember that is connect to event
            Set<TeamMember> teammembers = event.get().getTeamMembers();
            teammembers.forEach(teammember -> this.removeTeammemberFromEvent(teammember.getId(), event.get().getEventId()));
            eventRepo.deleteById(eventid);
        }
    }


    public Set<Event> addTeamToEvent(Long teamId, Long eventId) {
        Event event = this.findEventById(eventId);
        Team team = teamService.findTeamById(teamId);
        team.getEvents().add(event);
        event.getTeams().add(team);
        return team.getEvents();
    }

    public Set<Event> addTeammemberToEvent(Long teamMemberId, Long eventId) {
        Event event = this.findEventById(eventId);
        TeamMember teamMember = teamMemberService.findTeamMemberById(teamMemberId);
        teamMember.getEvents().add(event);
        event.getTeamMembers().add(teamMember);
        return teamMember.getEvents();
    }

    /*public Set<Event> removeTeamFromEvent(Long teamId, Long eventId) {
        Event event = this.findEventById(eventId);
        Team team = teamService.findTeamById(teamId);
        team.getEvents().remove(event);
        event.getTeamMembers().remove(team);
        return team.getEvents();
    }*/

    public void removeTeammemberFromEvent(Long teamMemberId, Long eventId) {
        Event event = this.findEventById(eventId);
        TeamMember teamMember = teamMemberService.findTeamMemberById(teamMemberId);
        if(teamMember.getEvents().contains(event)) {
            teamMember.getEvents().remove(event);
            event.getTeamMembers().remove(teamMember);
            return;
        }
        throw new UserCanNotBeDeleted();
    }

    // Searches the teams assigned to the event and decouples the connection
    public void removeTeamFromEvent(Long teamId, Long eventId){
        Event event = findEventById(eventId);
        Team team = teamService.findTeamById(teamId);
        if(team.getEvents().contains(event)) {
            team.getEvents().remove(event);
            event.getTeamMembers().remove(team);
            return;
        }
        throw new UserCanNotBeDeleted();
    }


}
