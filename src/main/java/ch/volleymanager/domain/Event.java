package ch.volleymanager.domain;

public class Event {
    private long eventId;
    private String eventName;
    private String eventDate;
    private String eventJob;
    private String eventLocation;
    private int numberOfHelpersNeeded;
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
