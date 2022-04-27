package logics.strategy.movement;

import logics.strategy.concrete_strategies.CrossArea;
import logics.strategy.concrete_strategies.VariableDistanceConstants;
import logics.strategy.concrete_strategies.AroundArea;

public class MovementFactoryImpl implements MovementFactory {

	@Override
	public MovementImpl stepMovement() {
		return new MovementImpl(new AroundArea(VariableDistanceConstants.SINGLE_DISTANCE));
	}

	@Override
	public MovementImpl runMovement() {
		return new MovementImpl(new CrossArea(VariableDistanceConstants.DOUBLE_DISTANCE));
	}

}
