package ch.volleymanager.service;

import ch.volleymanager.domain.Team;
import ch.volleymanager.exception.TeamNotFoundException;
import ch.volleymanager.repo.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void deleteTeam(Long id){
        teamRepo.deleteTeamById(id);
    }

    public Team findTeamById(Long id) {
        return teamRepo.findById(id)
                .orElseThrow(() -> new TeamNotFoundException("Team " + id + "konnte nicht gefunden werden"));
    }
}
