package ch.volleymanager.domain;

import javax.persistence.*;

@Entity
@Table(name = "Event Table")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long eventId;
    @Column(name= "Event name", nullable = false, updatable = true)
    private String eventName;
    @Column(name= "Event date",nullable = false, updatable = true)
    private String eventDate;
    @Column(name= "Ämtli",nullable = false, updatable = true)
    private String eventJob;
    @Column(name= "Ort",nullable = false, updatable = true)
    private String eventLocation;
    @Column(name= "Number of helper",nullable = false, updatable = true)
    private int numberOfHelpersNeeded;
    @Column(name= "Enough helpers?",nullable = false, updatable = true)
    private boolean numberOfHelpersOK;
    private Person person;

    public Event(long eventId, String eventName, String eventDate, String eventJob, String eventLocation, int numberOfHelpersNeeded,
                 boolean numberOfHelpersOK, Person person) {
        this.eventId=eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventJob = eventJob;
        this.eventLocation = eventLocation;
        this.numberOfHelpersNeeded = numberOfHelpersNeeded;
        this.numberOfHelpersOK = numberOfHelpersOK;
        this.person = person;
    }

    public long getEventId(){
        return eventId;
    }

    public void setEventId(long eventId){
        this.eventId=eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
