package logics.strategy.concrete_strategies;

import java.util.ArrayList;
import java.util.List;

import logics.strategy.Strategy;
import utilis.Pair;
import utilis.PosInGrid;

public class CrossArea implements Strategy {

	@Override
	/**
	 * Concrete strategy. Implements an algotithm that return the cross shape area
	 * around the given coordinate.
	 */
	public List<Pair<Integer, Integer>> execute(Pair<Integer, Integer> pos, Pair<Integer, Integer> size) {
		List<Pair<Integer, Integer>> reachableCells = new ArrayList<Pair<Integer, Integer>>();
		Pair<Integer, Integer> cellToAdd;

		for (int i = pos.getX() - 2; i <= pos.getX() + 2; i++) {
			cellToAdd = new Pair<>(i, pos.getY());
			if (!pos.equals(cellToAdd) && PosInGrid.checkPosInGrid(cellToAdd, size)) {
				reachableCells.add(cellToAdd);
			}
		}

		for (int i = pos.getY() - 2; i <= pos.getY() + 2; i++) {
			cellToAdd = new Pair<>(pos.getX(), i);
			if (!pos.equals(cellToAdd) && PosInGrid.checkPosInGrid(cellToAdd, size)) {
				reachableCells.add(cellToAdd);
			}
		}

		return reachableCells;
	}

}
