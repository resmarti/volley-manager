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
    private String emailaddressPlayer;
    private String mobileNumberPlayer;
    private String street;
    private int streetNb;
    private int postalCode;
    private String location;
    private boolean player;
    private boolean trainer;
    private boolean admin;
    private String imageUrl;

    public Person() {}

    public Person(String firstName, String lastName, String dateOfBirth, String emailaddressPlayer,
                  String mobileNumberPlayer, String street, int streetNb, int postalCode,
                  String location, boolean player, boolean trainer, boolean admin, String imageUrl){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.emailaddressPlayer = emailaddressPlayer;
        this.mobileNumberPlayer = mobileNumberPlayer;
        this.street = street;
        this.streetNb = streetNb;
        this.postalCode= postalCode;
        this.location = location;
        this.player = player;
        this.trainer = trainer;
        this.admin = admin;
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

    public String getEmailaddressPlayer() {
        return emailaddressPlayer;
    }

    public void setEmailaddressPlayer(String emailaddressPlayer) {
        this.emailaddressPlayer = emailaddressPlayer;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNb() {
        return streetNb;
    }

    public void setStreetNb(int streetNb) {
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

    public boolean isPlayer() {
        return player;
    }

    public void setPlayer(boolean player) {
        this.player = player;
    }

    public boolean isTrainer() {
        return trainer;
    }

    public void setTrainer(boolean trainer) {
        this.trainer = trainer;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
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
                ", email='" + emailaddressPlayer + '\'' +
                ", mobil='" + mobileNumberPlayer + '\'' +
                ", Address='" + street + streetNb + postalCode + location + '\'' +
                ", spieler=" + player +
                ", trainer=" + trainer +
                ", admin=" + admin +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
