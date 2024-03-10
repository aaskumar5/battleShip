import controller.GameController;
import model.Game;
import model.Player;
import model.Ship;
import model.types.GameState;
import model.types.ShipStatus;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        List<Player> players = new ArrayList<>();
        List<Ship> playerAShip = new ArrayList<>();
        playerAShip.add(new Ship(1,"SH-1", 4,0,0));
        players.add(new Player(1,"PlayerA",playerAShip));

        List<Ship> playerBShip = new ArrayList<>();
        playerBShip.add(new Ship(2,"SH-2",3,0,6));
        players.add(new Player(2,"PlayerB",playerBShip));

        GameController gameController = new GameController();
        Game game = gameController.startGame(players,10);

        while (game.getGameState().equals(GameState.IN_PROGRESS)) {


        }


    }
}
