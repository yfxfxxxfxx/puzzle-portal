package pl.puzzleportal.springjpabackend.service;

import pl.puzzleportal.springjpabackend.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserDetails();
    User findById(Long id);
    User save(User user);
    User findByLogin(String login);
    void delete(Long id);
}
