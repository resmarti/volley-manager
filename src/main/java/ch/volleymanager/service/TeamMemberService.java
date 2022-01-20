package ch.volleymanager.service;

import ch.volleymanager.domain.ContactPerson;
import ch.volleymanager.domain.Event;
import ch.volleymanager.domain.Team;
import ch.volleymanager.domain.TeamMember;
import ch.volleymanager.exception.UserCanNotBeAdded;
import ch.volleymanager.exception.UserCanNotBeDeleted;
import ch.volleymanager.exception.UserNotFoundException;
import ch.volleymanager.repo.ContactPersonRepo;
import ch.volleymanager.repo.EventRepo;
import ch.volleymanager.repo.TeamMemberRepo;
import ch.volleymanager.repo.TeamRepo;
import ch.volleymanager.resource.dto.TeamMemberDto;
import ch.volleymanager.utils.FieldMapper;
import ch.volleymanager.utils.HasLogger;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TeamMemberService implements HasLogger {
    @Autowired
    private final TeamMemberRepo teamMemberRepo;
    private final TeamRepo teamRepo;
    private final EventRepo eventRepo;
    private final ContactPersonRepo contactPersonRepo;

    @Autowired
    private ModelMapper modelMapper;

    public TeamMemberService(TeamMemberRepo teammemberRepo, TeamRepo teamRepo, ContactPersonRepo contactPersonRepo, EventRepo eventRepo) {
        this.teamMemberRepo = teammemberRepo;
        this.teamRepo = teamRepo;
        this.eventRepo = eventRepo;
        this.contactPersonRepo = contactPersonRepo;
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
        Optional<TeamMember> teamMember = teamMemberRepo.findByIdWithEagerRelationships(id);
        if(teamMember.isPresent()) {
            //remove from each Team that they belong to
            Set<Team> teams = teamMember.get().getTeams();
            teams.forEach(team -> this.removeTeamMemberFromTeam(team.getTeamId(), teamMember.get().getId()));
            //remove the contact Person if it exists
            if (teamMember.get().getContactPerson()!=null) {
                ContactPerson contactPerson = teamMember.get().getContactPerson();
                //contactPerson.removeTeamMember(teamMember.get());
                teamMember.get().removeContactPerson();
                teamMemberRepo.save(teamMember.get());
                contactPersonRepo.save(contactPerson);
            }
            //remove all events if there are any connections
            Set<Event> events = teamMember.get().getEvents();
            events.forEach(event -> this.removeTeamMemberFromEvent(event.getEventId(), teamMember.get().getId()));
        }
        teamMemberRepo.deleteById(id);
    }


    //Delete TeamMember
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

    public Event findEventById(Long id) {
        return eventRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
    }

    //Add team member to team with check of the maxAge in class Team
    public Set<Team> addTeamMemberToTeam(Long teammemberId, Long teamId) {
        TeamMember teamMember = findTeamMemberById(teammemberId);
        Team team = findTeamById(teamId);

        if (team.getMaxAge() >= teamMember.calculateAge()) {
            teamMember.getTeams().add(team);
            team.getTeammembers().add(teamMember);
            teamMemberRepo.save(teamMember);
            teamRepo.save(team);
        } else {
            throw new UserCanNotBeAdded();
        }

        return teamMember.getTeams();
    }

    //deletes Teammember from Team if the teammember is actually in the Teamlist
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

    public void removeTeamMemberFromEvent(Long eventid, Long teammemberid) {
        TeamMember teamMember = findTeamMemberById(teammemberid);
        Long memberId = teamMember.getId();
        Event event = findEventById(eventid);
        List<TeamMember> foundMembers = event.getTeamMembers().stream()
                .filter(member -> Objects.equals(member.getId(), memberId))
                .collect(Collectors.toList());
        if (foundMembers.size() > 0) {

            Set<TeamMember> members = event.getTeamMembers();
            members = members.stream()
                    .filter(member -> !member.getId().equals(memberId))
                    .collect(Collectors.toSet());

            Set<Event> events = teamMember.getEvents();
            events = events.stream()
                    .filter(t -> !t.getEventId().equals(eventid))
                    .collect(Collectors.toSet());

            event.setTeamMembers(members);
            teamMember.setEvents(events);

            teamMemberRepo.save(teamMember);
            eventRepo.save(event);
            return;
        }
        throw new UserCanNotBeDeleted();
    }

    public Set<Event> addTeamMemberToEvent(Long id, Long event) {
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


