package pl.puzzleportal.springjpabackend.entity;


import lombok.*;
import javax.persistence.*;
import java.util.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    private String username;
    private String password;
    private int points;
    private int active;
    private String roles = "";
    private String permissions = "";

    public User(String username, String password, int points, String roles, String permissions) {
        this.username = username;
        this.password = password;
        this.points = points;
        this.active = 1;
        this.roles = roles;
        this.permissions = permissions;
    }

    public List<String> getRoleList(){
        if(this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList(){
        if(this.permissions.length() > 0) {
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }
}
