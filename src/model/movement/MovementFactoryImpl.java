package model.movement;

import model.strategy.concrete_strategies.AroundArea;
import model.strategy.concrete_strategies.CrossArea;
import model.strategy.concrete_strategies.VariableDistanceConstants;

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
