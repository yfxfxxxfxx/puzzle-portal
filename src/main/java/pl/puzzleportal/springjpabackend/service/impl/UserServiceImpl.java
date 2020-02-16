package pl.puzzleportal.springjpabackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.puzzleportal.springjpabackend.entity.Privilege;
import pl.puzzleportal.springjpabackend.exceptions.NotFoundException;
import pl.puzzleportal.springjpabackend.entity.UserEntity;
import pl.puzzleportal.springjpabackend.repository.UserRepository;
import pl.puzzleportal.springjpabackend.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Long save(UserEntity userEntity) {
        String password = passwordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(password);
        userEntity.setPrivilege(Privilege.USER);
        userRepository.save(userEntity);
        return userEntity.getId();
    }

    @Override
    public UserEntity findByUsername(String login) {
        return userRepository.findByUsername(login);
    }

    @Override
    public void update(Long id, UserEntity sourceUserEntity) {
        UserEntity destinationUserEntity = findById(id);
//        destinationUserEntity.setLogin(sourceUserEntity.getLogin());
//        destinationUser.setPassword(sourceUser.getPassword());
        destinationUserEntity.setPoints(sourceUserEntity.getPoints());
        userRepository.save(destinationUserEntity);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
