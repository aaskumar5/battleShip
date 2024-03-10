package model;

import model.types.GameState;
import model.types.GridState;
import model.types.ShipStatus;
import strategy.AttackStrategy;
import strategy.RandomAttackStrategy;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    BattleField battleField;
    List<Player> players;
    List<Attack> attacks;
    GameState  gameState;
    Player winnerPlayer;
    Integer nextPlayerIndex;
    AttackStrategy attackStrategy;


    private Game(BattleField battleField, List<Player> players) {
        this.battleField = battleField;
        this.players = players;
        this.nextPlayerIndex = 0;
        attackStrategy = new RandomAttackStrategy();
        this.gameState = GameState.IN_PROGRESS;
    }
    public static Builder getGameBuilder(){
        return new Builder();
    }

    public BattleField getBattleField() {
        return battleField;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    public GameState getGameState() {
        return gameState;
    }

    public Player getWinnerPlayer() {
        return winnerPlayer;
    }

    public Integer getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void setWinnerPlayer(Player winnerPlayer) {
        this.winnerPlayer = winnerPlayer;
    }

    public void attack() throws InterruptedException {
        System.out.print(players.get(nextPlayerIndex).name + " chance for next move : ");
//        players.get(nextPlayerIndex).attack(sc);
        Grid attackGrid;
        if(nextPlayerIndex !=0) {
             attackGrid = attackStrategy.nextAttack(0, battleField.getDimension()/2, battleField.getDimension(),this);
        } else {
              attackGrid = attackStrategy.nextAttack(battleField.getDimension()/2, battleField.getDimension(), battleField.getDimension(),this);
        }
        System.out.print("Missile fired at ("+ attackGrid.getRow()+ ","+ attackGrid.getCol()+") ");
        if (attackGrid.getGridState().equals(GridState.DISTOYED) || attackGrid.isEmptyGrid()){
            // miss
            System.out.println("Miss");

        } else {
            attackGrid.distroyGrid(this);
//            TimeUnit.SECONDS.sleep(5);
            System.out.println("Hit *********************** \n\n\n"+ players.get((nextPlayerIndex+1)%2).name +"'s ship with id "+attackGrid.getShip().shipName+ " destroyed");
        }

        if(checkWinner(players.get((nextPlayerIndex+1)%2))) {
            this.setGameState(GameState.END);
            this.setWinnerPlayer(players.get(nextPlayerIndex));
        }

        nextPlayerIndex=(nextPlayerIndex+1)%2;
    }

    public boolean checkWinner(Player player){

        for(Ship ship : player.getShips()){
            if(ship.getShipStatus().equals(ShipStatus.HEALTHY)) {
                return false;
            }
        }

        return true;
    }

    public static class Builder {
        private BattleField battleField;
        private List<Player> players;
        private Builder() {
            this.players = new ArrayList<>();
            this.battleField = new BattleField(0);
        }
        public Game build() {
            // validation

            Game game = new Game(battleField,players);
            // first player
            setPlayerStateInBattleField(players.get(0),battleField,0,battleField.dimension/2);
            // second player
            setPlayerStateInBattleField(players.get(1),battleField,battleField.dimension/2,battleField.dimension);

            for(Player player : this.players){
                setShipStateInBattleField(player,battleField);
            }

//            game.battleField.printBattleField();

            return game;
        }
        public Builder setBattleField(BattleField battleField) {
            this.battleField = battleField;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public void setPlayerStateInBattleField(Player player,BattleField battleField,Integer start, Integer end){
            for(int i= 0;i< battleField.dimension;i++){
                for (int j= start;j<end;j++){
                    battleField.grids.get(i).get(j).player = player;
                }
            }
        }

        public void setShipStateInBattleField(Player player,BattleField battleField){
            for(Ship ship: player.ships){
                for(int i=ship.row;i<ship.row+ship.size;i++){
                    for(int j= ship.col;j<ship.col+ship.size;j++){
                        battleField.grids.get(i).get(j).ship = ship;
                    }
                }
            }
        }

    }


}
