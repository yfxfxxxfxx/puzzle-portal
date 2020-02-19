package pl.puzzleportal.springjpabackend.controller;

import com.google.common.base.Preconditions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.puzzleportal.springjpabackend.entity.User;
import pl.puzzleportal.springjpabackend.repository.UserRepository;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> retrieveUsers() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/id/{id}")
    public User retrieveUserById(@PathVariable("id") Long id) {
        return Preconditions.checkNotNull(userRepository.findById(id).orElse(null));
    }

    @GetMapping(value = "/login/{login}")
    public User retrieveUserByLogin(@PathVariable("login") String login) {
        return Preconditions.checkNotNull(userRepository.findByUsername(login));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User resource) {
        Preconditions.checkNotNull(resource);
        return userRepository.save(resource);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @RequestBody User resource) {
        Preconditions.checkNotNull(resource);
        RestPreconditions.checkFound(userRepository.findById(resource.getId()));
//        userRepository.update(id, resource);
    }

    @DeleteMapping(value = "/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
    }

}
