package ch.volleymanager.resource;

import ch.volleymanager.domain.Event;
import ch.volleymanager.domain.Team;
import ch.volleymanager.domain.TeamMember;
import ch.volleymanager.resource.dto.TeamMemberDto;
import ch.volleymanager.service.TeamMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/teammember")
public class TeamMemberResource {
    private final TeamMemberService teamMemberService;

    public TeamMemberResource(TeamMemberService teamMemberService) {
        this.teamMemberService = teamMemberService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TeamMember>> getAllTeamMembers(){
        List<TeamMember> teamMembers = teamMemberService.findAllTeamMembers();
        return new ResponseEntity<>(teamMembers, HttpStatus.OK);
    }

    @GetMapping("/all-eager")
    public ResponseEntity<List<TeamMemberDto>> getAllTeamMembersEager(){
        List<TeamMemberDto> teamMembers = teamMemberService.findAllTeamMembersEager();
        return new ResponseEntity<>(teamMembers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TeamMember> getTeamMemberById(@PathVariable("id")Long id){
        TeamMember teammember = teamMemberService.findTeamMemberById(id);
        return new ResponseEntity<>(teammember, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TeamMember> addTeamMember(@RequestBody TeamMember teammember) {
        TeamMember newTeamMember = teamMemberService.addTeamMember(teammember);
        return new ResponseEntity<>(newTeamMember, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<TeamMember> updateTeamMember(@RequestBody TeamMember teamMember) {
        TeamMember updateTeamMember = teamMemberService.updateTeamMember(teamMember);
        return new ResponseEntity<>(updateTeamMember, HttpStatus.OK);
    }

    @DeleteMapping("/removeteammemberfromteam/{teamid}/{teammemberid}")
    public ResponseEntity<?> removeTeamMemberFromTeam (@PathVariable("teamid")Long teamid, @PathVariable("teammemberid") Long teammemberid){
        teamMemberService.removeTeamMemberFromTeam(teamid, teammemberid);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/addteammembertoteam/{teamid}/{teammemberid}")
    public ResponseEntity<Set<Team>> addTeamMemberToTeam(@PathVariable("teammemberid") Long teammemberid, @PathVariable("teamid")Long teamid ){
        Set<Team> newTeamMember = teamMemberService.addTeamMemberToTeam(teammemberid, teamid);
        return new ResponseEntity<>(newTeamMember, HttpStatus.CREATED);
    }

    //TODO: addTeammemberToEvent test
    @PutMapping("/addteammembertoevent/{teammemberid}/{eventid}")
    public ResponseEntity <Set<Event>> addTeamMemberToEvent(@PathVariable("teammemberid") Long teammemberid, @PathVariable("eventid") Long eventid){
        Set <Event> newTeammember = teamMemberService.addTeamMemberToEvent(teammemberid, eventid);
        return new ResponseEntity<>(newTeammember, HttpStatus.CREATED);
    }

    @GetMapping("/removeTeamMemberFromEvent/{id}")
    public ResponseEntity<?>removeTeamMemberFromEvent(@PathVariable("eventId")Long eventId, @PathVariable("teammemberid")Long teammemberid){
        Set <Event> newEvent = teamMemberService.removeTeamMemberFromEvent(teammemberid, eventId);
        return new ResponseEntity<>(newEvent, HttpStatus.OK);
    }

    @DeleteMapping("/deleteTeamMember/{teammemberid}")
    public ResponseEntity<?> deleteTeamMember(@PathVariable("teammemberid")Long teammemberid){
        teamMemberService.deleteTeamMember(teammemberid);
        return new ResponseEntity<>(HttpStatus.OK);
            }


}
