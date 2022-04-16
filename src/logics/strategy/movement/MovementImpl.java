package logics.strategy.movement;

import java.util.List;

import logics.strategy.Strategy;
import utilis.Pair;

public class MovementImpl implements Movement {

	private Strategy movementStrategy; 
	private int numAction; 
	
	public MovementImpl(Strategy movementStrategy, int numAction) {
		this.movementStrategy = movementStrategy; 
		this.numAction = numAction; 
	}
	
	@Override
	public List<Pair<Integer, Integer>> reachableCells(Pair<Integer, Integer> pos, Pair<Integer, Integer> size) {
		return this.movementStrategy.execute(pos, size);
	}

	@Override
	public int getActionNumber() {
		return this.numAction;
	}

}
