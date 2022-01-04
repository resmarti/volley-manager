package ch.volleymanager.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_id", nullable = false, updatable = false)
    private long id;
    @Column(nullable = false, updatable = true)
    private String firstName;
    @Column(nullable = false, updatable = true)
    private String lastName;
    @Column(nullable = false, updatable = true)
    private String dateOfBirth;
    @Column(nullable = false, updatable = true)
    private String emailaddress;
    @Column(nullable = false, updatable = true)
    private String mobileNumber;
    @OneToMany
    private Set<Person> person;
 /* @ManyToMany
    @JoinTable(name = "parent_id_person_id",
            joinColumns = @JoinColumn(name = "parent_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Set<Person> person;
*/
    public Parent() {
    }

    public long getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Set<Person> getPerson() {
        return person;
    }

    public void setPerson(Set<Person> person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                ", vorname='" + firstName + '\'' +
                ", nachname='" + lastName + '\'' +
                ", geburtsdatum='" + dateOfBirth + '\'' +
                ", email='" + emailaddress + '\'' +
                ", mobil='" + mobileNumber + '\'' +
                '}';
    }
}