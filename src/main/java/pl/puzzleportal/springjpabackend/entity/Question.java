package pl.puzzleportal.springjpabackend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question extends BaseEntity {
    private String text;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Answer> answers;

    @OneToOne(cascade = CascadeType.ALL)
    private Answer correct;
}
