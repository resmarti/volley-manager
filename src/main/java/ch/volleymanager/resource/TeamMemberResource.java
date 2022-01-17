package ch.volleymanager.resource;

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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeamMember(@PathVariable("id")Long id) {
        teamMemberService.deleteTeamMember(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete1/{id}")
    public ResponseEntity<?> deleteTeamMember1(@PathVariable("id")Long id){
        teamMemberService.deleteTeamMember1();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/removeteammemberfromteam/{teamid}/{teammemberid}")
    public ResponseEntity<?> removeTeamMemberFromTeam (@PathVariable("teamid")Long teamid, @PathVariable("teammemberid") Long teammemberid){
        teamMemberService.removeTeamMemberFromTeam(teamid, teammemberid);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/addTeamMemberToTeam")
    public ResponseEntity<Set<Team>> addTeamMemberToTeam(Long memberId, Team team){
        Set<Team> newTeamMember = teamMemberService.addTeamMemberToTeam(memberId, team);
        return new ResponseEntity<>(newTeamMember, HttpStatus.CREATED);
    }


}
