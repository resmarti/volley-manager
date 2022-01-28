package ch.volleymanager.resource.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class EventSimpleDto {

    private Long eventId;
    private String eventName;
    private LocalDate eventDate;
    private String eventJob;
    private String eventLocation;
    private int numberOfHelpersNeeded;
    private boolean numberOfHelpersOK;

    public EventSimpleDto(Long eventId, String eventName, LocalDate eventDate, String eventJob, String eventLocation, int numberOfHelpersNeeded,
                          boolean numberOfHelpersOK, Set<TeamMemberDto> teamMembers, Set<TeamDto> teams) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventJob = eventJob;
        this.eventLocation = eventLocation;
        this.numberOfHelpersNeeded = numberOfHelpersNeeded;
        this.numberOfHelpersOK = numberOfHelpersOK;
    }

    public EventSimpleDto() {
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventJob() {
        return eventJob;
    }

    public void setEventJob(String eventJob) {
        this.eventJob = eventJob;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public int getNumberOfHelpersNeeded() {
        return numberOfHelpersNeeded;
    }

    public void setNumberOfHelpersNeeded(int numberOfHelpersNeeded) {
        this.numberOfHelpersNeeded = numberOfHelpersNeeded;
    }

    public boolean isNumberOfHelpersOK() {
        return numberOfHelpersOK;
    }

    public void setNumberOfHelpersOK(boolean numberOfHelpersOK) {
        this.numberOfHelpersOK = numberOfHelpersOK;
    }

    //Event must be checked if it is already in the past or not
    public boolean getEventValid() {
        return this.eventDate.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return "Event{" +
                "Event ID=" + eventId +
                ", Event Name='" + eventName + '\'' +
                ", Event Datum ='" + eventDate + '\'' +
                ", Event Job='" + eventJob + '\'' +
                ", Event Location='" + eventLocation + '\'' +
                '}';
    }

}

