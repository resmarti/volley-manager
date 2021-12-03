package ch.volleymanager.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String vorname;
    private String nachname;
    private String geburtsdatum;
    private String email;
    private String mobil;
    private boolean spieler;
    private boolean trainer;
    private boolean admin;
    private String imageUrl;

    public Person() {}

    public Person(String vorname, String nachname, String geburtsdatum, String email, String mobil, boolean spieler, boolean trainer, boolean admin, String imageUrl) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
        this.email = email;
        this.mobil = mobil;
        this.spieler = spieler;
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

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public boolean isSpieler() {
        return spieler;
    }

    public void setSpieler(boolean spieler) {
        this.spieler = spieler;
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
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", geburtsdatum='" + geburtsdatum + '\'' +
                ", email='" + email + '\'' +
                ", mobil='" + mobil + '\'' +
                ", spieler=" + spieler +
                ", trainer=" + trainer +
                ", admin=" + admin +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
