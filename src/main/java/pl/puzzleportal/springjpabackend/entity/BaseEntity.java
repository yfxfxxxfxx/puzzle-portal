package pl.puzzleportal.springjpabackend.entity;

import lombok.Getter;
import javax.persistence.*;

@Getter
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
