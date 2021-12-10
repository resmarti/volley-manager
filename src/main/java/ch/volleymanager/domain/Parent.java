package ch.volleymanager.domain;

public class Parent {
    private String firstNameParent;
    private String lastNameParent;
    private String emailaddressParent;
    private String mobileParent;
    private Person person;

    public Parent(String firstNameParent, String lastNameParent, String emailaddressParent, String mobileParent, Person person) {
        this.firstNameParent = firstNameParent;
        this.lastNameParent = lastNameParent;
        this.emailaddressParent = emailaddressParent;
        this.mobileParent = mobileParent;
        this.person = person;
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

    public String getMobileParent() {
        return mobileParent;
    }

    public void setMobileParent(String mobileParent) {
        this.mobileParent = mobileParent;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
