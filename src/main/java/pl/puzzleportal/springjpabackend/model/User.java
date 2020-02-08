package pl.puzzleportal.springjpabackend.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String login;

    @NonNull
    private String password;

    @NonNull
    private long points;
}
