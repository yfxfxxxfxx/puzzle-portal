package pl.puzzleportal.springjpabackend.testAdding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.puzzleportal.springjpabackend.insertData.InsertUserRegister;
import pl.puzzleportal.springjpabackend.model.User;
import pl.puzzleportal.springjpabackend.repository.UserRepository;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(InsertUserRegister.class)
public class InsertUserRegisterTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void addRegister() throws Exception {
//        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
//                .post("/register/login/password/email@wp.pl");
//
////        ResultMatcher contentMatcher = MockMvcResultMatchers.content()
////                .string("POST Response");
//       // User user=new User()
////        this.mockMvc.perform(builder).andExpect(contentMatcher)
////                .andExpect(MockMvcResultMatchers.status().isOk());
//        userRepository.save(user);
//        //mvc.perform((RequestBuilder) post());
//        List<User> users = userRepository.findAll();
//        assertThat(users.size(), is(1));
    }

}
