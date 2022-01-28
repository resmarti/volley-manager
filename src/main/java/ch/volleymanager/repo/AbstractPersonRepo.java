package ch.volleymanager.repo;

import ch.volleymanager.domain.AbstractPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AbstractPersonRepo extends JpaRepository<AbstractPerson, Long> {


}
