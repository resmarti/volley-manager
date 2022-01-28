package ch.volleymanager.repository;

import ch.volleymanager.AbstractTest;
import ch.volleymanager.domain.Team;
import ch.volleymanager.repo.TeamRepo;
import org.aspectj.lang.annotation.Before;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class TeamRepoTest extends AbstractTest {
    /*
    @Autowired
    TeamRepo teamRepo;

    private Long teamId;
    private Team newTeam;

    @Override
    @BeforeEach
    public void setUp(){
        String jsonTeam = readResource(new ClassPathResource("team/team.json"));
        try{
            newTeam = mapFromJson(jsonTeam, Team.class);
            List<Team> teams = teamRepo.findById(newTeam.getTeamId());
            if(teams.isEmpty()){
                newTeam= teamRepo.save(newTeam);
                teamId = newTeam.getTeamId();
            }else{
                newTeam= teams.get(0);
                teamId = teams.get(0).getTeamId();
            }
        }catch(IOException e){
            e.printStackTrace();;
        }
    }
    */

}
