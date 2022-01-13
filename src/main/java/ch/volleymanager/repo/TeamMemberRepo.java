package ch.volleymanager.repo;
import ch.volleymanager.domain.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamMemberRepo extends JpaRepository<TeamMember, Long> {

}
