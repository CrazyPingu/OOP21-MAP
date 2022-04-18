package logics.strategy.movement;

import logics.strategy.concrete_strategies.CrossArea;
import logics.strategy.concrete_strategies.VariableDistanceConstants;
import logics.strategy.concrete_strategies.AroundArea;

public class MovementFactoryImpl implements MovementFactory {

	@Override
	public MovementImpl stepMovement(int actioNum) {
		return new MovementImpl(new AroundArea(VariableDistanceConstants.SINGLE_DISTANCE), actioNum);
	}

	@Override
	public MovementImpl runMovement(int actioNum) {
		return new MovementImpl(new CrossArea(VariableDistanceConstants.DOUBLE_DISTANCE), actioNum);
	}

}
