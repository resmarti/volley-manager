package ch.volleymanager.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ch.volleymanager.domain.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EventRepo extends JpaRepository<Event, Long> {
    public List<Event> findAllByOrderByEventDateAsc();

    @Query("select e from Event e left join fetch e.teamMembers left join fetch e.teams where e.eventId =:id")
    Optional<Event> findByIdWithEagerRelationships(@Param("id") Long id);

    @Query (value ="select e from Event e left join fetch e.teamMembers",
    countQuery = "select count(teamMembers) from TeamMember teammembers")
    Page<Event> findAllWithEagerRelationships(Pageable page);

}
