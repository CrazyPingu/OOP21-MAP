package logics.strategy.movement;

import java.util.List;

import logics.strategy.Strategy;
import utilities.Pair;

public class MovementImpl implements Movement {

  private final Strategy movingStrategy;

  public MovementImpl(final Strategy movingStrategy) {
    this.movingStrategy = movingStrategy;
  }

  @Override
  public List<Pair<Integer, Integer>> reachableCells(final Pair<Integer, Integer> pos,
      final Pair<Integer, Integer> size) {
    return this.movingStrategy.execute(pos, size);
  }
}
