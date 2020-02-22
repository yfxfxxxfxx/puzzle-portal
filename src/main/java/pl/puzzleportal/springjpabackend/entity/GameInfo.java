package pl.puzzleportal.springjpabackend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameInfo {

    @Id
    private long id;

    private String quizName;
    private String categoryId;
}
