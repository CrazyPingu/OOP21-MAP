package logics.strategy.concrete_strategies;

import java.util.ArrayList;
import java.util.List;

import logics.strategy.Strategy;
import utilis.Pair;
import utilis.PosInGrid;

/**
 * 
 * Concrete strategy. Implements an algorithm that returns the area around the
 * chosen position.
 *
 */
public class AroundArea implements Strategy {

	@Override
	public List<Pair<Integer, Integer>> execute(Pair<Integer, Integer> pos, Pair<Integer, Integer> size) {
		List<Pair<Integer, Integer>> reachableCells = new ArrayList<Pair<Integer, Integer>>();
		for (int i = pos.getX() - 1; i <= pos.getX() + 1; i++) {
			for (int j = pos.getY() - 1; j <= pos.getY() + 1; j++) {
				Pair<Integer, Integer> cellToAdd = new Pair<>(i, j);
				if (!pos.equals(cellToAdd) && PosInGrid.checkPosInGrid(cellToAdd, size)) {
					reachableCells.add(cellToAdd);
				}
			}
		}
		return reachableCells;
	}

}
