package ch.volleymanager.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import ch.volleymanager.domain.Event;

import java.util.Optional;

public interface EventRepo extends JpaRepository<Event, Long> {

}
