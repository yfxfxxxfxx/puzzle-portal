package pl.puzzleportal.springjpabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.puzzleportal.springjpabackend.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
    Answer getAnswerByText(String text);
}
