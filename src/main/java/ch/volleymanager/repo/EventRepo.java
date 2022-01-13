package ch.volleymanager.repo;
import ch.volleymanager.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import ch.volleymanager.domain.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EventRepo extends JpaRepository<Event, Long> {


    @Query("select e from Event e left join fetch e.teamMembers left join fetch e.teams where e.eventId =:id")
    Optional<Event> findByIdWithEagerRelationships(@Param("id") Long id);
}
