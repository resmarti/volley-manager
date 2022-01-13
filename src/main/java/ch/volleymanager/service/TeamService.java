package ch.volleymanager.service;

import ch.volleymanager.domain.Event;
import ch.volleymanager.domain.Team;
import ch.volleymanager.domain.TeamMember;
import ch.volleymanager.exception.TeamNotFoundException;
import ch.volleymanager.repo.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

@Service
public class TeamService {
    private final TeamRepo teamRepo;

    @Autowired
    public TeamService(TeamRepo teamRepo) {
        this.teamRepo = teamRepo;
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

    public void deleteTeam(Long id) {
        teamRepo.deleteTeamById(id);
    }

    public Team findTeamById(Long id) {
        return teamRepo.findById(id)
                .orElseThrow(() -> new TeamNotFoundException("Team " + id + "konnte nicht gefunden werden"));
    }

    public Set<Event> addTeamToEvent(Long id, Event event) {
        Team team = findTeamById(id);
        team.getEvents().add(event);
        event.getTeams().add(team);
        return team.getEvents();
    }
}

