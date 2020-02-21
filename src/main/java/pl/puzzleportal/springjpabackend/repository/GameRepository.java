package pl.puzzleportal.springjpabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.puzzleportal.springjpabackend.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
}
