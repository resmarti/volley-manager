package ch.volleymanager.repo;
import ch.volleymanager.domain.ContactPerson;
import ch.volleymanager.domain.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TeamMemberRepo extends JpaRepository<TeamMember, Long> {

    @Query("select t from TeamMember t left join fetch t.contactPerson left join fetch t.teams left join fetch t.events  where t.id =:id")
    Optional<TeamMember> findByIdWithEagerRelationships(@Param("id") Long id);

}
