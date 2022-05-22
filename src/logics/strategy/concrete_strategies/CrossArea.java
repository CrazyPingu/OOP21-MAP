package logics.strategy.concrete_strategies;

import java.util.ArrayList;
import java.util.List;
import logics.strategy.Strategy;
import utilities.Pair;
import utilities.PosInGrid;

/**
 * 
 * Concrete strategy. Implements an algorithm that returns a cross shaped area
 * around the given coordinate.
 * 
 */
public class CrossArea implements Strategy {
	
	private final int distance;

	/**
	 * @param distance is how far from around area can reach
	 */
	public CrossArea(final int distance) {
		this.distance = distance;
	}

	@Override
	/**
	 * {inheritDoc}
	 */
	public List<Pair<Integer, Integer>> execute(final Pair<Integer, Integer> pos, final Pair<Integer, Integer> size) {
		final List<Pair<Integer, Integer>> reachableCells = new ArrayList<>();
		Pair<Integer, Integer> cellToAdd;

		for (int i = pos.getX() - this.distance; i <= pos.getX() + this.distance; i++) {
			cellToAdd = new Pair<>(i, pos.getY());
			if (!pos.equals(cellToAdd) && PosInGrid.checkPosInGrid(cellToAdd, size)) {
				reachableCells.add(cellToAdd);
			}
		}

		for (int i = pos.getY() - this.distance; i <= pos.getY() + this.distance; i++) {
			cellToAdd = new Pair<>(pos.getX(), i);
			if (!pos.equals(cellToAdd) && PosInGrid.checkPosInGrid(cellToAdd, size)) {
				reachableCells.add(cellToAdd);
			}
		}

		return reachableCells;
	}

}
