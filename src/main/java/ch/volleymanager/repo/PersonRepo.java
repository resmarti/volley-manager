package ch.volleymanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ch.volleymanager.domain.Person;

import java.util.Optional;

public interface PersonRepo extends JpaRepository<Person, Long> {
    void deletePersonById(Long id);

    Optional<Person> findPersonById(Long id);
}
