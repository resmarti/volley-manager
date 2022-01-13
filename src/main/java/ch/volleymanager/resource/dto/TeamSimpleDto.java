package ch.volleymanager.resource.dto;

import ch.volleymanager.domain.Event;

import java.util.HashSet;
import java.util.Set;

public class TeamSimpleDto {

    private Long teamId;
    private String teamName;
    private int maxAge;



    //Contructor
    public TeamSimpleDto(Long teamId, int maxAge, String teamName) {
        this.teamId = teamId;
        this.maxAge = maxAge;
        this.teamName = teamName;

    }
    //empty constructor for the DB
    public TeamSimpleDto(){
    }

    //Getter and Setter methods
    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

}
