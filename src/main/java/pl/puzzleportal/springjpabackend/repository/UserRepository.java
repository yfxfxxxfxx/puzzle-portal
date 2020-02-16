package pl.puzzleportal.springjpabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.puzzleportal.springjpabackend.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByLogin(String login);
    void deleteById(Long id);
}
