package ch.volleymanager.repo;

import ch.volleymanager.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TeamRepo extends JpaRepository<Team, Long> {


    @Query("select t from Team t left join fetch t.teamMembers left join fetch t.events where t.teamId =:id")
    Optional<Team> findByIdWithEagerRelationships(@Param("id") Long id);
}
