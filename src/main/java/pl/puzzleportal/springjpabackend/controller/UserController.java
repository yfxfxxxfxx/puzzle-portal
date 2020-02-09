package pl.puzzleportal.springjpabackend.controller;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.puzzleportal.springjpabackend.model.User;
import pl.puzzleportal.springjpabackend.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> retrieveUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public User retrieveUserById(@PathVariable("id") Long id) {
        return Preconditions.checkNotNull(userService.findById(id));
    }

    @GetMapping(value = "/{login}")
    public User retrieveUserByLogin(@PathVariable("login") String login) {
        return Preconditions.checkNotNull(userService.findByLogin(login));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody User resource) {
        Preconditions.checkNotNull(resource);
        return userService.create(resource);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @RequestBody User resource) {
        Preconditions.checkNotNull(resource);
        RestPreconditions.checkFound(userService.findById(resource.getId()));
        userService.update(id, resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

}
