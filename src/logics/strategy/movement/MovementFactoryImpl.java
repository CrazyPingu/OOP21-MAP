package logics.strategy.movement;

import java.util.List;

import logics.strategy.Strategy;
import utilis.Pair;

public class MovementFactoryImpl implements MovementFactory {

	@Override
	public MovementImpl stepMovement(int actioNum) {
		return new MovementImpl(new Strategy() {

			@Override
			public List<Pair<Integer, Integer>> execute(Pair<Integer, Integer> pos, Pair<Integer, Integer> size) {
				// TODO Auto-generated method stub
				return null;
			}
		}, actioNum);
	}

	@Override
	public MovementImpl jumpMovement(int actioNum) {
		return new MovementImpl(new Strategy() {

			@Override
			public List<Pair<Integer, Integer>> execute(Pair<Integer, Integer> pos, Pair<Integer, Integer> size) {
				// TODO Auto-generated method stub
				return null;
			}
		}, actioNum);
	}

}
