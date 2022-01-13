package ch.volleymanager.service;

import ch.volleymanager.domain.Event;
import ch.volleymanager.domain.Team;
import ch.volleymanager.domain.TeamMember;
import ch.volleymanager.exception.UserCanNotBeAdded;
import ch.volleymanager.exception.UserCanNotBeDeleted;
import ch.volleymanager.exception.UserNotFoundException;
import ch.volleymanager.repo.TeamMemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeamMemberService {
    @Autowired
    private final TeamMemberRepo teamMemberRepo;

    public TeamMemberService(TeamMemberRepo teammemberRepo) {
        this.teamMemberRepo = teammemberRepo;
    }

    public TeamMember addTeammember(TeamMember teammember) {
        return teamMemberRepo.save(teammember);
    }

    public List<TeamMember> findAllTeammembers() {
        return teamMemberRepo.findAll();
    }

    public TeamMember updateTeamMember(TeamMember teammember) {
        return teamMemberRepo.save(teammember);
    }

    public void deleteTeamMember(Long id) {
        teamMemberRepo.deleteById(id);
    }

    public TeamMember findTeamMemberById(Long id) {
        return teamMemberRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Teammitglied " + id + "konnte nicht gefunden werden"));
    }

    //Add team member to team with check of the maxAge in class Team
    public Set<Team> addTeamMemberToTeam(Long id, Team team) {
        TeamMember teamMember = findTeamMemberById(id);

        if (team.getMaxAge() >= teamMember.calculateAge()) {
            teamMember.getTeams().add(team);
            team.getTeammembers().add(teamMember);
        } else {
            throw new UserCanNotBeAdded("Teammitglied kann nicht hinzugefügt werden");
        }

        return teamMember.getTeams();
    }

    public Set<Team> removeTeamMemberFromTeam(Long id, Team team){
        TeamMember teamMember = findTeamMemberById(id);
        if(team.getTeammembers().contains(teamMember)){
            teamMember.getTeams().remove(teamMember);
            team.getTeammembers().remove(team);
        }throw new UserCanNotBeDeleted("Teammitglied kann nicht entfernt werden");
    }

    public Set<Event> addTeamMemberToEvent(Long id, Event event){
        TeamMember teamMember = findTeamMemberById(id);
        teamMember.getEvents().add(event);
        event.getTeamMembers().add(teamMember);
            return teamMember.getEvents();
    }
}


