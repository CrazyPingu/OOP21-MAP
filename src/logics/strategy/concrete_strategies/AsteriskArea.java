package logics.strategy.concrete_strategies;

import java.util.ArrayList;
import java.util.List;

import logics.strategy.Strategy;
import utilities.Pair;
import utilities.PosInGrid;

/**
 * 
 * Concrete strategy. Implements an algorithm that returns an asterisk shaped area
 * around the given coordinate.
 * 
 */
public class AsteriskArea implements Strategy {

	private int distance;

	/**
	 * @param distance is how far from around area can reach
	 * (if SINGLE_DISTANCE is required it will be considered starting from around area
	 * that's why there's a sum with VariableDistanceConstants.SINGLE_DISTANCE)
	 */
	public AsteriskArea(int distance) {
		this.distance = distance + VariableDistanceConstants.SINGLE_DISTANCE;
	}

	/**
	 * {inheritDoc}
	 */
	public List<Pair<Integer, Integer>> execute(Pair<Integer, Integer> pos, Pair<Integer, Integer> size) {
		List<Pair<Integer, Integer>> reachableCells = new ArrayList<Pair<Integer, Integer>>();		
		AroundArea aroundArea = new AroundArea(VariableDistanceConstants.SINGLE_DISTANCE);
		List<Pair<Integer, Integer>> aroundAreaList = aroundArea.execute(pos, size);
		int counter=0;

		for (int i = pos.getX() - this.distance; i <= pos.getX() + this.distance; i++) {
			for (int j = pos.getY() - this.distance; j <= pos.getY() + this.distance; j++) {
				Pair<Integer, Integer> cellToAdd = new Pair<>(i, j);
				if (!aroundAreaList.contains(cellToAdd) && !pos.equals(cellToAdd)
						&& PosInGrid.checkPosInGrid(cellToAdd, size) && counter%2==0) {
					reachableCells.add(cellToAdd);
				}
				counter++;
			}
		}

		reachableCells.addAll(aroundAreaList);
		return reachableCells;
	}
}