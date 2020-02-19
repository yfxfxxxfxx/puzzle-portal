package pl.puzzleportal.springjpabackend.entity;

import lombok.Getter;
import javax.persistence.*;

@Getter
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
