package pl.puzzleportal.springjpabackend.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.puzzleportal.springjpabackend.entity.User;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Service
public class DbStartup implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private Logger logger;

    public DbStartup(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        logger = Logger.getLogger(getClass().getName());

        //Clear db
        this.userRepository.deleteAll();

        //Create users
        User test = new User("test",passwordEncoder.encode("test"), 0,"USER","");

        List<User> users = Arrays.asList(test);

        logger.info("uzytkownik zostal zapisany do bazy danych");

        this.userRepository.saveAll(users);
    }
}
