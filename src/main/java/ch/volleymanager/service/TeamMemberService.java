package ch.volleymanager.service;

import ch.volleymanager.domain.Event;
import ch.volleymanager.domain.Team;
import ch.volleymanager.domain.TeamMember;
import ch.volleymanager.exception.UserCanNotBeAdded;
import ch.volleymanager.exception.UserCanNotBeDeleted;
import ch.volleymanager.exception.UserNotFoundException;
import ch.volleymanager.repo.TeamMemberRepo;
import ch.volleymanager.repo.TeamRepo;
import ch.volleymanager.resource.dto.TeamMemberDto;
import ch.volleymanager.utils.FieldMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TeamMemberService {
    @Autowired
    private final TeamMemberRepo teamMemberRepo;
    private final TeamRepo teamRepo;

    @Autowired
    private ModelMapper modelMapper;

    public TeamMemberService(TeamMemberRepo teammemberRepo, TeamRepo teamRepo) {
        this.teamMemberRepo = teammemberRepo;
        this.teamRepo = teamRepo;
    }

    public TeamMember addTeamMember(TeamMember teammember) {
        return teamMemberRepo.save(teammember);
    }

    public List<TeamMember> findAllTeamMembers() {
        return teamMemberRepo.findAll();
    }

    public TeamMember updateTeamMember(TeamMember teammember) {
        return teamMemberRepo.save(teammember);
    }

    public void deleteTeamMember(Long id) {
        teamMemberRepo.deleteById(id);
    }

    public List<TeamMemberDto> deleteTeamMember1() {
        List<TeamMember> teamMembers = teamMemberRepo.findAllWithEagerRelationships();
        List<TeamMemberDto> teamMemberDtos = new ArrayList<>();
        teamMembers.forEach(teamMember -> teamMemberDtos.remove(convertToDto(teamMember)));
        return teamMemberDtos;
    }

    public TeamMember findTeamMemberById(Long id) {
        return teamMemberRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
    }

    public Team findTeamById(Long id) {
        return teamRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
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

    public void removeTeamMemberFromTeam(Long teamid, Long teammemberid) {
        TeamMember teamMember = findTeamMemberById(teammemberid);
        Long memberId = teamMember.getId();
        Team team = findTeamById(teamid);
        List<TeamMember> foundMembers = team.getTeammembers().stream()
                .filter(member -> Objects.equals(member.getId(), memberId))
                .collect(Collectors.toList());
        if (foundMembers.size() > 0) {

            Set<TeamMember> members = team.getTeammembers();
            members = members.stream()
                    .filter(member -> !member.getId().equals(memberId))
                    .collect(Collectors.toSet());

            Set<Team> teams = teamMember.getTeams();
            teams = teams.stream()
                    .filter(t -> !t.getTeamId().equals(teamid))
                    .collect(Collectors.toSet());

            team.setTeammembers(members);
            teamMember.setTeams(teams);

            teamMemberRepo.save(teamMember);
            teamRepo.save(team);
            return;
        }
        throw new UserCanNotBeDeleted();
    }

    public Set<Event> addTeamMemberToEvent(Long id, Event event) {
        TeamMember teamMember = findTeamMemberById(id);
        teamMember.getEvents().add(event);
        event.getTeamMembers().add(teamMember);
        return teamMember.getEvents();
    }

    public List<TeamMemberDto> findAllTeamMembersEager() {
        List<TeamMember> teamMembers = teamMemberRepo.findAllWithEagerRelationships();
        List<TeamMemberDto> teamMemberDtos = new ArrayList<>();
        teamMembers.forEach(teamMember -> teamMemberDtos.add(convertToDto(teamMember)));
        return teamMemberDtos;
    }

    private TeamMemberDto convertToDto(TeamMember teamMember) {
        return modelMapper.map(teamMember, TeamMemberDto.class);
    }

    private TeamMember convertToEntity(TeamMemberDto teamMemberDto) {
        return modelMapper.map(teamMemberDto, TeamMember.class);
    }

}


