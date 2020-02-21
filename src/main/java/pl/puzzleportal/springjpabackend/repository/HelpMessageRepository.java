package pl.puzzleportal.springjpabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.puzzleportal.springjpabackend.entity.HelpMessage;

public interface HelpMessageRepository extends JpaRepository<HelpMessage,Long> {
}
