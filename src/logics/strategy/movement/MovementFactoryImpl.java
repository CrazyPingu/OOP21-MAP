package logics.strategy.movement;

import logics.strategy.concrete_strategies.CrossArea;
import logics.strategy.concrete_strategies.AroundArea;

public class MovementFactoryImpl implements MovementFactory {

	@Override
	public MovementImpl stepMovement(int actioNum) {
		return new MovementImpl(new AroundArea(), actioNum);
	}

	@Override
	public MovementImpl runMovement(int actioNum) {
		return new MovementImpl(new CrossArea(), actioNum);
	}

}
