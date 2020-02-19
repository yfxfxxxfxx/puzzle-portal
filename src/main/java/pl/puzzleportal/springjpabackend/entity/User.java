package pl.puzzleportal.springjpabackend.entity;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter @Setter
public class User extends BaseEntity {

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private int points;
    private int active;
    private String roles = "";
    private String permissions = "";

    public User(String username, String password, int points, String roles, String permissions) {
        this.username = username;
        this.password = password;
        this.points = points;
        this.roles = roles;
        this.permissions = permissions;
        this.active = 1;
    }

    protected User(){}

    public List<String> getRoleList(){
        if(this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList(){
        if(this.permissions.length() > 0){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }
}
