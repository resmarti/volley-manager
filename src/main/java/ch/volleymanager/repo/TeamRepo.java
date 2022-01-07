package ch.volleymanager.repo;

import ch.volleymanager.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TeamRepo extends JpaRepository<Team, Long> {
    Optional <Team> deleteTeamById(Long id);
    Optional<Team> addTeam(Long id);
}
