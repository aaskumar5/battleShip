package strategy;

import model.Game;
import model.Grid;

public interface AttackStrategy {
    public Grid nextAttack(Integer start, Integer end, Integer dimension, Game game);
}
