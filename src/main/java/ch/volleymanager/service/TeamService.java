package ch.volleymanager.service;

import ch.volleymanager.domain.Event;
import ch.volleymanager.domain.Team;
import ch.volleymanager.domain.TeamMember;
import ch.volleymanager.exception.TeamNotFoundException;
import ch.volleymanager.repo.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TeamService {
    private final TeamRepo teamRepo;
    private final TeamMemberService teamMemberService;
    private final EventService eventService;

    @Autowired
    public TeamService(TeamRepo teamRepo, @Lazy TeamMemberService teamMemberService, @Lazy EventService eventService) {
        this.teamRepo = teamRepo;
        this.teamMemberService = teamMemberService;
        this.eventService = eventService;
    }

    public Team addTeam(Team team) {
        return teamRepo.save(team);
    }

    public List<Team> findAllTeams() {
        return teamRepo.findAll();
    }

    public Team updateTeam(Team team) {
        return teamRepo.save(team);
    }

    public Team findTeamById(Long id) {
        return teamRepo.findById(id)
                .orElseThrow(() -> new TeamNotFoundException("Team " + id + "konnte nicht gefunden werden"));
    }


    public void deleteTeam(Long id) {
        Optional<Team> team = teamRepo.findByIdWithEagerRelationships(id);
        if(team.isPresent()) {
            //remove from each Team that they belong to
            Set<TeamMember> teamMembers = team.get().getTeamMembers();
            teamMembers.forEach(teamMember -> teamMemberService.removeTeamMemberFromTeam(team.get().getTeamId(), teamMember.getId()));
            //remove all events if there are any connections
            Set<Event> events = team.get().getEvents();
            events.forEach(event -> eventService.removeTeamFromEvent(team.get().getTeamId(), event.getEventId()));
        }
        teamRepo.deleteById(id);
    }



}

