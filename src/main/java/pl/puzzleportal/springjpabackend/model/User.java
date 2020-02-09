package pl.puzzleportal.springjpabackend.model;


import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
public class User extends BaseEntity {
    private String login;
    private String password;
    private String email;
    private long points;
}
