package ch.volleymanager.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ContactPerson extends AbstractPerson {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contactPerson")
    private Set<Player> players;

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
