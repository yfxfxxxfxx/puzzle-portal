package pl.puzzleportal.springjpabackend.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.puzzleportal.springjpabackend.model.User;
import pl.puzzleportal.springjpabackend.repository.UserRepository;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenCalledSave_thenCorrectNumberOfUsers(){
        User user1 = new User();
        User user2 = new User("login","password","logn@wp.pl",0);
        user1.setEmail("wwwwww@wp.pl");
        user1.setLogin("user1");
        user1.setPassword("password1");
        user1.setPoints(0);

        userRepository.save(user1);
        userRepository.save(user2);

        List<User> users = userRepository.findAll();

        assertThat(users.size(), is(2));
    }
}
