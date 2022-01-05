package ch.volleymanager.repo;

import ch.volleymanager.domain.AbstractPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AbstractPersonRepo extends JpaRepository<AbstractPerson, Long> {
    Optional<AbstractPerson> deletePersonById(Long id);
}
