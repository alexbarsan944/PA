package main.controller;

import main.entity.Players;
import main.repo.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class PlayerController {

    @Autowired
    private PlayerRepo playerRepo;

    @GetMapping("/players")
    public List getAllPlayers() {
        return (List) playerRepo.findAll();
    }

    @GetMapping("/players/{id}")
    public Optional<Players> show(@PathVariable Integer id) {
        return playerRepo.findById(id);
    }

    @PostMapping("/players")
    public Players create(@RequestBody Map<String, String> body) {
        String nume = body.get("nume");
        String id = body.get("id");
        Players p = new Players();
        p.setNume(nume);
        p.setId(Integer.parseInt(id));
        return playerRepo.save(p);
    }

    @PutMapping("/players/{id}")
    public Players updateUser(@RequestBody Map<String, String> body, @PathVariable Integer id) {
        String nume = body.get("nume");

        Players p = new Players();
        p.setNume(nume);
        p.setId(id);
        return playerRepo.save(p);
    }

    @DeleteMapping("/players/{id}")
    public boolean delete(@PathVariable String id) {
        int PlayerID = Integer.parseInt(id);
        playerRepo.deleteById(PlayerID);
        return true;
    }
}
