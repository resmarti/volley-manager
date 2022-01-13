package ch.volleymanager.resource;

import ch.volleymanager.domain.Event;
import ch.volleymanager.domain.Team;
import ch.volleymanager.domain.TeamMember;
import ch.volleymanager.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamResource {
    private final TeamService teamService;

public TeamResource (TeamService teamService){
    this.teamService = teamService;
}

    @GetMapping("/all")
    public ResponseEntity<List<Team>> getAllTeams(){
        List<Team> teams = teamService.findAllTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable("id")Long id){
        Team team = teamService.findTeamById(id);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Team> addTeam(@RequestBody Team team) {
        Team newTeam = teamService.addTeam(team);
        return new ResponseEntity<>(newTeam, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Team> updateTeam(@RequestBody Team team) {
        Team updateTeam = teamService.updateTeam(team);
        return new ResponseEntity<>(updateTeam, HttpStatus.OK);
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable("id")Long id) {
        teamService.deleteTeam(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/removeTeamMemberFromTeam{id}")
    public ResponseEntity<?> removeTeamMemberFromTeam (@PathVariable("id")Long id, TeamMember teamMember){
        //teamService.removeTeamFromTeamMember(teamMember);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/addTeamToEvent")
    public ResponseEntity<Team>addTeamToEvent(Long teamId, @RequestBody Event event){

    teamService.addTeamToEvent(teamId, event);
    return new ResponseEntity<>(HttpStatus.OK);
    }

}
