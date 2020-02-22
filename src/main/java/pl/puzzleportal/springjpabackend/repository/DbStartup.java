package pl.puzzleportal.springjpabackend.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.puzzleportal.springjpabackend.entity.Answer;
import pl.puzzleportal.springjpabackend.entity.Game;
import pl.puzzleportal.springjpabackend.entity.Question;
import pl.puzzleportal.springjpabackend.entity.User;

import java.util.ArrayList;
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
        User test = new User("test", passwordEncoder.encode("test"), 108, 1, "USER");
        User example = new User("example", passwordEncoder.encode("example"), 100, 1, "USER");
        User testAdmin = new User("testAdmin", passwordEncoder.encode("testAdmin"), 96, 1, "USER,ADMIN");

        List<User> users = Arrays.asList(test, example, testAdmin);

        //Create games
        Answer france = new Answer("Paryż");
        Answer germany = new Answer("Berlin");
        Answer russia = new Answer("Moskwa");
        Answer usa = new Answer("Waszyngton");

        Game capitals = new Game(
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

        Answer grunwaldzka = new Answer("1410");
        Answer legnica = new Answer("1241");
        Answer pierwszaKonstytucja = new Answer("1791");
        Answer niepodlegloscStanow = new Answer("1776");

        Game years = new Game(
                "Wskaż w którym roku poniższe wydarzenia historyczne miały miejsce",
                "Historia",
                Arrays.asList(
                        new Question(
                                "Bitwa Grunwaldzka",
                                Arrays.asList(
                                        grunwaldzka,
                                        new Answer("1401"),
                                        new Answer("1422"),
                                        new Answer("1453")
                                ),
                                grunwaldzka
                        ),
                        new Question(
                                "Bitwa pod Legnicą",
                                Arrays.asList(
                                        new Answer("1232"),
                                        new Answer("1240"),
                                        legnica,
                                        new Answer("1255")
                                ),
                                legnica
                        ),
                        new Question(
                                "Podpisanie pierwszej konstutycji Polski",
                                Arrays.asList(
                                        pierwszaKonstytucja,
                                        new Answer("1793"),
                                        new Answer("1794"),
                                        new Answer("1788")
                                ),
                                pierwszaKonstytucja
                        ),
                        new Question(
                                "Podpisanie deklaracji niepodległości Stanów Zjednoczonych",
                                Arrays.asList(
                                        new Answer("1771"),
                                        new Answer("1783"),
                                        new Answer("1774"),
                                        niepodlegloscStanow
                                ),
                                niepodlegloscStanow
                        )
                )
        );

        List<Game> games = Arrays.asList(capitals, years);

        logger.info("uzytkownik zostal zapisany do bazy danych");
        logger.info("gra zostala zapisana do bazy danych");

        this.userRepository.saveAll(users);
        this.gameRepository.saveAll(games);
    }
}
