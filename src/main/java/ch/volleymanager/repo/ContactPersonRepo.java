package ch.volleymanager.repo;

import ch.volleymanager.domain.ContactPerson;
import ch.volleymanager.domain.Event;
import ch.volleymanager.domain.TeamMember;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ContactPersonRepo extends JpaRepository<ContactPerson, Long> {

    List<ContactPerson> findByFirstNameAndLastName(String firstName, String lastName);

    @Query("select c from ContactPerson c where c.lastName = :lastName")
    List<ContactPerson> findQueryByLastName(String lastName);

    @Query("select c from ContactPerson c left join fetch c.teamMembers  where c.id =:id")
    Optional<ContactPerson> findByIdWithEagerRelationships(@Param("id") Long id);

    @Query("select c from ContactPerson c left join fetch c.teamMembers")
    List<ContactPerson> findAllWithEagerRelationships();


    @Query( value = "select c from ContactPerson c left join fetch c.teamMembers",
            countQuery = "select count(contact) from ContactPerson contact")
    Page<ContactPerson> findAllWithEagerRelationships(Pageable page);
}
