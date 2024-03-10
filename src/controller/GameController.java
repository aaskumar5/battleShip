package controller;

import model.BattleField;
import model.Game;
import model.Player;

import java.util.List;
import java.util.Scanner;

public class GameController {

     // Start game
    public Game startGame(List<Player> players, Integer dimension) {
        return Game.getGameBuilder()
                .setBattleField(new BattleField(dimension))
                .setPlayers(players)
                .build();
    }

    public void attack(Game game, Scanner sc){
        game.attack(sc);
    }
}
