package pl.puzzleportal.springjpabackend.service;

import pl.puzzleportal.springjpabackend.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUsers();
    UserEntity findById(Long id);
    Long save(UserEntity userEntity);
    UserEntity findByUsername(String login);
    void update(Long id, UserEntity userEntity);
    void deleteById(Long id);
}
