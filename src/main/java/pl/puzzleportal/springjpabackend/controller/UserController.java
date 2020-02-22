package pl.puzzleportal.springjpabackend.controller;

import com.google.common.base.Preconditions;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.puzzleportal.springjpabackend.entity.User;
import pl.puzzleportal.springjpabackend.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


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

    @GetMapping("/loggedUser")
    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return retrieveUserByLogin(currentPrincipalName);
    }

    @PostMapping("/loggedUserData")
    public void getAuthenticatedUserData(@RequestBody List<String> credentials) {
        User toAuthenticate = userRepository.findByUsername(credentials.get(0));

        if(toAuthenticate != null && toAuthenticate.getPassword().equals(credentials.get(1))){
            System.out.println(toAuthenticate.getActive());
            if(toAuthenticate.getActive() == 0){
                toAuthenticate.setActive(1);
            }
        }
    }

    @GetMapping("/is_active")
    public User checkUserAuthentication(@RequestBody String username) {
        User userToCheck = userRepository.findByUsername(username);

        if(userToCheck.getActive() == 1) {
            return userToCheck;
        } else {
            return null;
        }
    }

    @GetMapping(value = "/id/{id}")
    public User retrieveUserById(@PathVariable("id") Long id) {
        return Preconditions.checkNotNull(userRepository.findById(id).orElse(null));
    }

    @GetMapping(value = "login/{login}")
    public User retrieveUserByLogin(@PathVariable("login") String login) {
        return Preconditions.checkNotNull(userRepository.findByUsername(login));
    }

    @GetMapping("/ranked")
    public List<User> retrieveUsersOrderedByRank(){
        return retrieveUsers()
                .stream()
                .sorted(Comparator.comparing(User::getPoints).reversed())
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/result/{points}")
    public void addResultToPoints(@PathVariable("points") int points){
        User destinationUser = getAuthenticatedUser();
        destinationUser.setPoints(destinationUser.getPoints() + points);
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
