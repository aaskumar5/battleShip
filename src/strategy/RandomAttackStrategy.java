package strategy;

import model.Game;
import model.Grid;

import java.util.Random;

public class RandomAttackStrategy implements AttackStrategy{
    public Grid nextAttack(Integer start, Integer end, Integer dimension, Game game){
        Random random = new Random();
        Integer row = random.nextInt(end-start) + start;
        Integer col = random.nextInt(dimension);
        return game.getBattleField().getGrids().get(row).get(col);
    }
}
