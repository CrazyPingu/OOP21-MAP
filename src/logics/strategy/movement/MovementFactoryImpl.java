package logics.strategy.movement;

import java.util.ArrayList;
import java.util.List;
import logics.strategy.Strategy;
import logics.strategy.concrete_strategies.aroundArea;
import utilis.Pair;

public class MovementFactoryImpl implements MovementFactory {

	@Override
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
