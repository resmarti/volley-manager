package ch.volleymanager.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "person_id", nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false, updatable = true)
    private String firstName;
    @Column(nullable = false, updatable = true)
    private String lastName;
    @Column(nullable = false, updatable = true)
    private String dateOfBirth;
    @Column(nullable = false, updatable = true)
    private String emailaddressPlayer;
    @Column(nullable = false, updatable = true)
    private String mobileNumberPlayer;
    @Column(nullable = false, updatable = true)
    private String street;
    @Column(nullable = false, updatable = true)
    private int streetNb;
    @Column(nullable = false, updatable = true)
    private int postalCode;
    @Column(nullable = false, updatable = true)
    private String location;
    @Column(nullable = false, updatable = true)
    private boolean isPlayer;
    @Column(nullable = false, updatable = true)
    private boolean isTrainer;
    @Column(nullable = false, updatable = true)
    private boolean isAdmin;
    @Column(nullable = false, updatable = true)
    private String imageUrl;
    @ManyToOne
    private Parent parent;

    public Person(){}

    public Person(String firstName, String lastName, String dateOfBirth, String emailaddressPlayer,
                  String mobileNumberPlayer, String street, int streetNb, int postalCode,
                  String location, boolean isPlayer, boolean isTrainer, boolean isAdmin, String imageUrl){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
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

    public boolean GetIsPlayer() {
        return isPlayer;
    }

    public void setPlayer(boolean isPlayer) {
        this.isPlayer = isPlayer;
    }

    public boolean GetIsTrainer() {
        return isTrainer;
    }

    public void setIsTrainer(boolean isTrainer) {
        this.isTrainer = isTrainer;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean admin) {
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
