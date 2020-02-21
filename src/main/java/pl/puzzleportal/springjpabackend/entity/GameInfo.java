package pl.puzzleportal.springjpabackend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameInfo extends BaseEntity {
    private String quizName;
    private String categoryId;
}
