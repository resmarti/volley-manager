package ch.volleymanager.repo;

import ch.volleymanager.domain.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ParentRepo {

public interface ParentRepo extends JpaRepository<Parent, Long> {
    Optional<Parent> deleteParentById(Long id);
    Optional<Parent> findPersonById(Long id);
}
}
