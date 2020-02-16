package pl.puzzleportal.springjpabackend.controller;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.puzzleportal.springjpabackend.entity.UserEntity;
import pl.puzzleportal.springjpabackend.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @PostConstruct
//    public void addFirstUser(){
//        User user = new User("email@gmai.com", passwordEncoder.encode("some-password"));
//        userRepository.save(user);
//    }

    @GetMapping
    public List<UserEntity> retrieveUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/id/{id}")
    public UserEntity retrieveUserById(@PathVariable("id") Long id) {
        return Preconditions.checkNotNull(userService.findById(id));
    }

    @GetMapping(value = "/login/{login}")
    public UserEntity retrieveUserByLogin(@PathVariable("login") String login) {
        return Preconditions.checkNotNull(userService.findByUsername(login));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody UserEntity resource) {
        Preconditions.checkNotNull(resource);
        return userService.save(resource);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @RequestBody UserEntity resource) {
        Preconditions.checkNotNull(resource);
        RestPreconditions.checkFound(userService.findById(resource.getId()));
        userService.update(id, resource);
    }

    @DeleteMapping(value = "/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

}
