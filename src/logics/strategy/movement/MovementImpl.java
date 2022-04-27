package logics.strategy.movement;

import java.util.List;

import logics.strategy.Strategy;
import utilis.Pair;

public class MovementImpl implements Movement {

	private Strategy movingStrategy;

	public MovementImpl(Strategy movingStrategy) {
		this.movingStrategy = movingStrategy;
	}

	@Override
	public List<Pair<Integer, Integer>> reachableCells(Pair<Integer, Integer> pos, Pair<Integer, Integer> size) {
		return this.movingStrategy.execute(pos, size);
	}
}
