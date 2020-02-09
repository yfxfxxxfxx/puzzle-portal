package pl.puzzleportal.springjpabackend.databaseFactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameQuizCreator {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "quiz_id")
    private Integer id;





    private boolean isAvaible;


}
