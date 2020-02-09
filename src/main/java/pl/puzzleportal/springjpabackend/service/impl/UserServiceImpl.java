package pl.puzzleportal.springjpabackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.puzzleportal.springjpabackend.model.User;
import pl.puzzleportal.springjpabackend.repository.UserRepository;
import pl.puzzleportal.springjpabackend.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    //TODO: test jednostkowy, czy metoda faktycznie zwraca wartosc
    @Override
    public Long create(User user) {
        userRepository.save(user);
        return user.getId();
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
