package main;

import java.util.List;

public class Game {
    private int gameID;
    private List<Players> players;

    public Game(int gameID, List<Players> players) {
        this.gameID = gameID;
        this.players = players;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public List<Players> getPlayers() {
        return players;
    }

    public void setPlayers(List<Players> players) {
        this.players = players;
    }


}
