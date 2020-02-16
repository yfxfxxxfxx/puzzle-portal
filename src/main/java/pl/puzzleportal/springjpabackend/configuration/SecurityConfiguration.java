package pl.puzzleportal.springjpabackend.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pl.puzzleportal.springjpabackend.entity.Privilege;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/*").hasRole(Privilege.USER.name())
                .antMatchers("/admin/*").hasRole(Privilege.ADMIN.name())
                .and()
                .formLogin();
    }
}
