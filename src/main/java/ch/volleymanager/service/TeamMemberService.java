package ch.volleymanager.service;

import ch.volleymanager.domain.Team;
import ch.volleymanager.domain.TeamMember;
import ch.volleymanager.exception.UserCanNotBeAdded;
import ch.volleymanager.exception.UserNotFoundException;
import ch.volleymanager.repo.TeamMemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeamMemberService {
    private final TeamMemberRepo teammemberRepo;


    @Autowired
    public TeamMemberService(TeamMemberRepo teammemberRepo) {
        this.teammemberRepo = teammemberRepo;
    }

    public TeamMember addTeammember(TeamMember teammember) {
        return teammemberRepo.save(teammember);
    }

    public List<TeamMember> findAllTeammembers() {
        return teammemberRepo.findAll();
    }

    public TeamMember updateTeammember(TeamMember teammember) {
        return teammemberRepo.save(teammember);
    }

    public void deleteTeammember(Long id) {
        teammemberRepo.deleteTeammemberById(id);
    }

    public TeamMember findTeammemberById(Long id) {
        return teammemberRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Teammitglied " + id + "konnte nicht gefunden werden"));
    }

    //Todo: Add teammember to team with check of the maxAge in class Team
    public Set<Team> addTeamMemberToTeam(Long id, Team team) {
        TeamMember teamMember = findTeammemberById(id);

        if (team.getMaxAge() >= teamMember.calculateAge()) {
            teamMember.getTeams().add(team);
            team.getTeammembers().add(teamMember);
        } else {
            throw new UserCanNotBeAdded("Teammitglied kann nicht hinzugefügt werden");
        }

        return teamMember.getTeams();
    }
}


