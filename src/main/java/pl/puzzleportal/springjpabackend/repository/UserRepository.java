package pl.puzzleportal.springjpabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.puzzleportal.springjpabackend.model.User;

public interface UserRepository extends JpaRepository <Long, User> {
}
