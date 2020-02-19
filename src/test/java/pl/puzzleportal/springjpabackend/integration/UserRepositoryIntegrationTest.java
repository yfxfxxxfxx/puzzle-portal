package pl.puzzleportal.springjpabackend.integration;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {

//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    public void whenCalledSave_thenCorrectNumberOfUsers(){
////        UserEntity userEntity1 = new UserEntity();
////        UserEntity userEntity2 = new UserEntity("user2","password2",0);
////
////        userEntity1.setLogin("user1");
////        userEntity1.setPoints(0);
////
////        userRepository.save(userEntity1);
////        userRepository.save(userEntity2);
////
////        List<UserEntity> userEntities = userRepository.findAll();
////
////        assertThat(userEntities.size(), is(2));
//    }
}
