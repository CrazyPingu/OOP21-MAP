package logics.strategy.movement;

import java.util.ArrayList;
import java.util.List;
import logics.strategy.Strategy;
import logics.strategy.concrete_strategies.aroundArea;
import utilis.Pair;

public class MovementFactoryImpl implements MovementFactory {

	@Override
	/**
	 * @param actioNum represent the number of action the entity can perform in a
	 *                 turn
	 * @return a MovementImpl that contains a strategy that allow the entity to move
	 *         in the cells around
	 */
	public MovementImpl stepMovement(int actioNum) {
		return new MovementImpl(new aroundArea(), actioNum);
	}

	@Override
	public MovementImpl jumpMovement(int actioNum) {
		return new MovementImpl(new Strategy() {

			@Override
			public List<Pair<Integer, Integer>> execute(Pair<Integer, Integer> pos, Pair<Integer, Integer> size) {

				List<Pair<Integer, Integer>> availableCell = new ArrayList<Pair<Integer, Integer>>();

				return null;
			}
		}, actioNum);
	}

}
