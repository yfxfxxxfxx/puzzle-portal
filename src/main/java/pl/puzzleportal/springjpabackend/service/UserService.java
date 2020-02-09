package pl.puzzleportal.springjpabackend.service;

import pl.puzzleportal.springjpabackend.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User findById(Long id);
    Long create(User user);
    User findByLogin(String login);
    void update(Long id, User user);
    void deleteById(Long id);
}
