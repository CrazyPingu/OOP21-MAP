package logics.strategy.concrete_strategies;

import java.util.ArrayList;
import java.util.List;

import logics.strategy.Strategy;
import utilis.Pair;
import utilis.PosInGrid;

/**
 * 
 * Concrete strategy. Implements an algorithm that returns a cross shaped area
 * around the given coordinate.
 * 
 */
public class CrossArea implements Strategy {
	
	private int distance;

	public CrossArea(int distance) {
		this.distance = distance;
	}

	@Override
	public List<Pair<Integer, Integer>> execute(Pair<Integer, Integer> pos, Pair<Integer, Integer> size) {
		List<Pair<Integer, Integer>> reachableCells = new ArrayList<Pair<Integer, Integer>>();
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
