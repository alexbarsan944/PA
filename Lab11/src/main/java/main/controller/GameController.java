package main.controller;

import main.entity.Games;
import main.exceptions.MyException;
import main.repo.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class GameController {
    private List<Games> games = new ArrayList<>();
    @Autowired
    private GameRepo gameRepo;

    @GetMapping("/games")
    public List<Games> getAllGames() {
        List<Games> g = (List<Games>) gameRepo.findAll();
        if (g == null)
            throw new MyException("No game found");
        return g;
    }

    @GetMapping("/{id}")
    public Games show(@PathVariable("id") Integer id) {
        games = (List<Games>) gameRepo.findAll();
        return games.stream()
                .filter(g -> g.getId() == id).findFirst()
                .orElseThrow(() -> new MyException("No game found"));
    }

    @PostMapping("/games")
    public Games create(@RequestBody Map<String, String> body) {
        String id_castigator = body.get("id_castigator");
        Games g = new Games();
        g.setIdCastigator(Integer.parseInt(id_castigator));
        String id_player1 = body.get("id_player1");
        g.setIdPlayer1(Integer.parseInt(id_player1));
        String id_player2 = body.get("id_player2");
        g.setIdPlayer2(Integer.parseInt(id_player2));
        games.add(g);
        return gameRepo.save(g);
    }
}
