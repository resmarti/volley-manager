package ch.volleymanager.repo;

import ch.volleymanager.domain.ContactPerson;
import ch.volleymanager.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactPersonRepo extends JpaRepository<ContactPerson, Long> {
}
