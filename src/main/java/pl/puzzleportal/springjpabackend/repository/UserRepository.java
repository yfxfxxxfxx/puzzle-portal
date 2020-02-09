package pl.puzzleportal.springjpabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.puzzleportal.springjpabackend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByLogin(String login);
    void deleteById(Long id);
}
