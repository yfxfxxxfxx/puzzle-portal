package pl.puzzleportal.springjpabackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.puzzleportal.springjpabackend.entity.Game;
import pl.puzzleportal.springjpabackend.repository.GameRepository;

import java.util.List;

@RestController
@RequestMapping("/quizgame")
public class GameController {

    private GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping
    public List<Game> findAllGames(){
        return this.gameRepository.findAll();
    }

}
