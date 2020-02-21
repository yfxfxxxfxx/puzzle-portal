package pl.puzzleportal.springjpabackend.controller;

import com.google.common.base.Preconditions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.puzzleportal.springjpabackend.entity.Game;
import pl.puzzleportal.springjpabackend.entity.GameInfo;
import pl.puzzleportal.springjpabackend.repository.GameRepository;

import java.util.ArrayList;
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

    @GetMapping("/{id}")
    public Game findGameById(@PathVariable("id") long id){
        return Preconditions.checkNotNull(gameRepository.findById(id).orElse(null));
    }

    @GetMapping("/info")
    public List<GameInfo> getInfoFromAllGames(){
        List<GameInfo> gamesInfo = new ArrayList<>();

        List<Game> games = this.gameRepository.findAll();

        for (Game game : games) {
            gamesInfo.add(new GameInfo(game.getName(),game.getCategory()));
        }

        return gamesInfo;
    }

}
