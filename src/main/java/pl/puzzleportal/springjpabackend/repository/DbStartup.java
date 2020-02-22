package pl.puzzleportal.springjpabackend.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.puzzleportal.springjpabackend.entity.Answer;
import pl.puzzleportal.springjpabackend.entity.Game;
import pl.puzzleportal.springjpabackend.entity.Question;
import pl.puzzleportal.springjpabackend.entity.User;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Service
public class DbStartup implements CommandLineRunner {
    private UserRepository userRepository;
    private GameRepository gameRepository;
    private PasswordEncoder passwordEncoder;
    private Logger logger;

    public DbStartup(UserRepository userRepository, GameRepository gameRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.passwordEncoder = passwordEncoder;
        this.logger = Logger.getLogger(getClass().getName());
    }

    @Override
    public void run(String... args) {
        //Clear db
        this.userRepository.deleteAll();
        this.gameRepository.deleteAll();

        //Create users
        User test = new User("test",passwordEncoder.encode("test"), 200,0,"USER","");
        User example = new User("example",passwordEncoder.encode("example"), 100,0,"USER","");
        User testAdmin = new User("testAdmin",passwordEncoder.encode("testAdmin"),150,0,"USER,ADMIN","");

        List<User> users = Arrays.asList(test, example, testAdmin);

        //Create games
        Answer france = new Answer("Paryż");
        Answer germany = new Answer("Berlin");
        Answer russia = new Answer("Moskwa");
        Answer usa = new Answer("Waszyngton");

        Game firstGame = new Game(
                "Wybierz stolicy ponizszych krajow",
                "Geografia",
                Arrays.asList(
                        new Question(
                                "Jakie miasto jest stolicą Francji?",
                                Arrays.asList(
                                        france,
                                        new Answer("Berlin"),
                                        new Answer("Marseilles"),
                                        new Answer("Warszawa")
                                ),
                                france
                        ),
                        new Question(
                                "Jakie miasto jest stolicą Niemców?",
                                Arrays.asList(
                                        new Answer("Bern"),
                                        new Answer("Moskwa"),
                                        new Answer("Jerozolima"),
                                        germany
                                ),
                                germany
                        ),
                        new Question(
                                "Jakie miasto jest stolicą Rosji?",
                                Arrays.asList(
                                        new Answer("Paryż"),
                                        new Answer("Berlin"),
                                        russia,
                                        new Answer("Warszawa")
                                ),
                                russia
                        ),
                        new Question(
                                "Jakie miasto jest stolicą Stanów Zjednoczonych?",
                                Arrays.asList(
                                        new Answer("Nowy Jork"),
                                        usa,
                                        new Answer("Richmond"),
                                        new Answer("Teksas")
                                ),
                                usa
                        )
                )
                );

        logger.info("uzytkownik zostal zapisany do bazy danych");
        logger.info("gra zostala zapisana do bazy danych");

        logger.info(firstGame.toString());

        this.userRepository.saveAll(users);
        this.gameRepository.save(firstGame);
    }
}
