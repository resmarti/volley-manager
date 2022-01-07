package ch.volleymanager.resource;

import ch.volleymanager.domain.TeamMember;
import ch.volleymanager.service.TeamMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teammember")
public class TeamMemberResource {
    private final TeamMemberService teamMemberService;

    public TeamMemberResource(TeamMemberService teamMemberService) {
        this.teamMemberService = teamMemberService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TeamMember>> getAllTeammembers(){
        List<TeamMember> teamMembers = teamMemberService.findAllTeammembers();
        return new ResponseEntity<>(teamMembers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TeamMember> getTeammemberById(@PathVariable("id")Long id){
        TeamMember teammember = teamMemberService.findTeammemberById(id);
        return new ResponseEntity<>(teammember, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TeamMember> addTeammember(@RequestBody TeamMember teammember) {
        TeamMember newTeamMember = teamMemberService.addTeammember(teammember);
        return new ResponseEntity<>(newTeamMember, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<TeamMember> updateTeammember(@RequestBody TeamMember teammember) {
        TeamMember updateTeamMember = teamMemberService.updateTeammember(teammember);
        return new ResponseEntity<>(updateTeamMember, HttpStatus.OK);
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<?> deleteTeammember(@PathVariable("id")Long id) {
        teamMemberService.deleteTeammember(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
