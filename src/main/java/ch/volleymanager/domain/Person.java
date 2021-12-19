package ch.volleymanager.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String emailaddressPlayer;
    private String mobileNumberPlayer;
    private String street;
    private String streetNb;
    private int postalCode;
    private String location;
    private boolean isPlayer;
    private boolean isTrainer;
    private boolean isAdmin;
    private String imageUrl;

    public Person(){}

    public Person(String firstName, String lastName, String dateOfBirth, String gender, String emailaddressPlayer,
                  String mobileNumberPlayer, String street, String streetNb, int postalCode,
                  String location, boolean isPlayer, boolean isTrainer, boolean isAdmin, String imageUrl){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.emailaddressPlayer = emailaddressPlayer;
        this.mobileNumberPlayer = mobileNumberPlayer;
        this.street = street;
        this.streetNb = streetNb;
        this.postalCode= postalCode;
        this.location = location;
        this.isPlayer = isPlayer;
        this.isTrainer = isTrainer;
        this.isAdmin = isAdmin;
        this.imageUrl = imageUrl;
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

    public String getLastName() { return lastName;    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailaddressPlayer() {
        return emailaddressPlayer;
    }

    public void setEmailaddressPlayer(String emailaddressPlayer) {
        this.emailaddressPlayer = emailaddressPlayer;
    }

    public String getStreet() { return street; }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNb() { return streetNb; }

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

    public String getMobileNumberPlayer() {
        return mobileNumberPlayer;
    }

    public void setMobil(String mobileNumberPlayer) {
        this.mobileNumberPlayer = mobileNumberPlayer;
    }

    public boolean getIsPlayer() {
        return isPlayer;
    }

    public void setPlayer(boolean isPlayer) {
        this.isPlayer = isPlayer;
    }

    public boolean getIsTrainer() {
        return isTrainer;
    }

    public void setIsTrainer(boolean isTrainer) {
        this.isTrainer = isTrainer;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", vorname='" + firstName + '\'' +
                    ", nachname='" + lastName + '\'' +
                    ", geburtsdatum='" + dateOfBirth + '\'' +
                    ", geschlecht='" + gender + '\'' +
                    ", email='" + emailaddressPlayer + '\'' +
                    ", mobil='" + mobileNumberPlayer + '\'' +
                    ", Address='" + street + streetNb + postalCode + location + '\'' +
                    ", spieler=" + isPlayer +
                    ", trainer=" + isTrainer +
                    ", admin=" + isAdmin +
                    ", imageUrl='" + imageUrl + '\'' +
                    '}';
        }
}
