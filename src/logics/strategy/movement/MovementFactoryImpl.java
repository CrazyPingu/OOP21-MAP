package logics.strategy.movement;

import logics.strategy.concrete_strategies.CrossArea;
import logics.strategy.concrete_strategies.aroundArea;

public class MovementFactoryImpl implements MovementFactory {

	@Override
	public MovementImpl stepMovement(int actioNum) {
		return new MovementImpl(new aroundArea(), actioNum);
	}

	@Override
	public MovementImpl runMovement(int actioNum) {
		return new MovementImpl(new CrossArea(), actioNum);
	}

}
