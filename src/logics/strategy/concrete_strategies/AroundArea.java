package logics.strategy.concrete_strategies;

import java.util.ArrayList;
import java.util.List;

import logics.strategy.Strategy;
import utilities.Pair;
import utilities.PosInGrid;

/**
 * 
 * Concrete strategy. Implements an algorithm that returns the area around the
 * chosen position.
 *
 */
public class AroundArea implements Strategy {
	
	private int distance;

	/**
	 * @param distance is how far from around area can reach
	 */
	public AroundArea(int distance) {
		this.distance = distance;
	}

	@Override
	/**
	 * {inheritDoc}
	 */
	public List<Pair<Integer, Integer>> execute(Pair<Integer, Integer> pos, Pair<Integer, Integer> size) {
		List<Pair<Integer, Integer>> reachableCells = new ArrayList<Pair<Integer, Integer>>();
		for (int i = pos.getX() - this.distance; i <= pos.getX() + this.distance; i++) {
			for (int j = pos.getY() - this.distance; j <= pos.getY() + this.distance; j++) {
				Pair<Integer, Integer> cellToAdd = new Pair<>(i, j);
				if (!pos.equals(cellToAdd) && PosInGrid.checkPosInGrid(cellToAdd, size)) {
					reachableCells.add(cellToAdd);
				}
			}
		}
		return reachableCells;
	}

}
