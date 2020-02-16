package pl.puzzleportal.springjpabackend.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.puzzleportal.springjpabackend.entity.UserEntity;
import pl.puzzleportal.springjpabackend.repository.UserRepository;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserEntityRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenCalledSave_thenCorrectNumberOfUsers(){
        UserEntity userEntity1 = new UserEntity();
        UserEntity userEntity2 = new UserEntity("user2","password2",0);

        userEntity1.setLogin("user1");
        userEntity1.setPoints(0);

        userRepository.save(userEntity1);
        userRepository.save(userEntity2);

        List<UserEntity> userEntities = userRepository.findAll();

        assertThat(userEntities.size(), is(2));
    }
}
