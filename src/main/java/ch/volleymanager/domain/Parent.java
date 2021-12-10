package ch.volleymanager.domain;

public class Parent {
    private long id;
    private String firstNameParent;
    private String lastNameParent;
    private String emailaddressParent;
    private String mobileNumberParent;
    private Person person;

    public Parent(long id, String firstNameParent, String lastNameParent, String emailaddressParent, String mobileNumberParent, Person person) {
        this.id = id;
        this.firstNameParent = firstNameParent;
        this.lastNameParent = lastNameParent;
        this.emailaddressParent = emailaddressParent;
        this.mobileNumberParent = mobileNumberParent;
        this.person = person;
    }

    public long getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getFirstNameParent() {
        return firstNameParent;
    }

    public void setFirstNameParent(String firstNameParent) {
        this.firstNameParent = firstNameParent;
    }

    public String getLastNameParent() {
        return lastNameParent;
    }

    public void setLastNameParent(String lastNameParent) {
        this.lastNameParent = lastNameParent;
    }

    public String getEmailaddressParent() {
        return emailaddressParent;
    }

    public void setEmailaddressParent(String emailaddressParent) {
        this.emailaddressParent = emailaddressParent;
    }

    public String getMobileNumberParent() {
        return mobileNumberParent;
    }

    public void setMobileNumberParent(String mobileNumberParent) {
        this.mobileNumberParent = mobileNumberParent;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                ", vorname Elternteil='" + firstNameParent + '\'' +
                ", nachname Elternteil='" + lastNameParent + '\'' +
                ", email Elternteil='" + emailaddressParent + '\'' +
                ", mobile Elternteil='" + mobileNumberParent + '\'' +
                '}';
    }
}