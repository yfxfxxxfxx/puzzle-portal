package pl.puzzleportal.springjpabackend.databaseFactory;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class GameQuizQuestion {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quiz_id", referencedColumnName = "quiz_id")
    private GameQuizCreator gameQuizCreator;

  //  private Integer quizId;
    private String Question;
}
