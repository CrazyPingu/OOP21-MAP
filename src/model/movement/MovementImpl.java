package model.movement;

import java.util.List;

import model.strategy.Strategy;
import utilities.Pair;

/**
 * 
 * This class define the method for the movement implementation. This class is a
 * part of the stratey pattern, represent the "Context" of the Strategy
 * interface.
 */
public class MovementImpl implements Movement {

  private final Strategy movingStrategy;

  /**
   * 
   * @param movingStrategy the strategy of the movement system
   */
  public MovementImpl(final Strategy movingStrategy) {
    this.movingStrategy = movingStrategy;
  }

  @Override
  public List<Pair<Integer, Integer>> reachableCells(final Pair<Integer, Integer> pos,
      final Pair<Integer, Integer> size) {
    return this.movingStrategy.execute(pos, size);
  }
}
