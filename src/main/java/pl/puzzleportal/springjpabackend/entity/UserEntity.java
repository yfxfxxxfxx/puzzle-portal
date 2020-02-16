package pl.puzzleportal.springjpabackend.entity;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static pl.puzzleportal.springjpabackend.entity.Privilege.ADMIN;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity implements UserDetails {
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Privilege privilege;
    private int points;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority user = new SimpleGrantedAuthority("ROLE_USER");
        if(ADMIN.equals(this.privilege)) {
            SimpleGrantedAuthority admin = new SimpleGrantedAuthority("ROLE_ADMIN");
            return Arrays.asList(admin,user);
        } else {
            return Collections.singletonList(user);
        }
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
