package ch.volleymanager.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class AbstractPerson implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false, updatable = true)
    private String streetNb;
    @Column(nullable = false, updatable = true)
    private int postalCode;
    @Column(nullable = false, updatable = true)
    private String location;
    @Column(nullable = false, updatable = true)
    private String email;
    @Column(nullable = false, updatable = true)
    private String mobile;

    public AbstractPerson(Long id, String firstName, String lastName, String street, String streetNb, int postalCode, String location, String email, String mobile) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.streetNb = streetNb;
        this.postalCode = postalCode;
        this.location = location;
        this.email= email;
        this.mobile=mobile;
    }

    public AbstractPerson(){
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNb() {
        return streetNb;
    }

    public void setStreetNb(String streetNb) {
        this.streetNb = streetNb;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
public String toString() {
    return "AbstractPerson{" +
            "id=" + id +
            ",firstName='" + firstName + '\'' +
            ",lastName='" + lastName +'\'' +
            ",street='" + street +'\'' +
            ",streetNb ='" + streetNb +'\'' +
            ",postalCode='" + postalCode +'\'' +
            ",location='" + location +'\'' +
            ",email='" + email +'\'' +
            ",mobile='" + mobile +'\'' +
            '}';
    }
}
