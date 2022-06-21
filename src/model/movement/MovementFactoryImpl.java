package model.movement;

import model.strategy.concrete_strategies.AroundArea;
import model.strategy.concrete_strategies.CrossArea;
import model.strategy.concrete_strategies.VariableDistanceConstants;

/**
 * 
 * This class implements the method for the movement system creation.
 * This class follow the Factory patter. 
 */
public class MovementFactoryImpl implements MovementFactory {

  @Override
  public MovementImpl createStepMovement() {
    return new MovementImpl(new AroundArea(VariableDistanceConstants.SINGLE_DISTANCE));
  }

  @Override
  public MovementImpl createRunMovement() {
    return new MovementImpl(new CrossArea(VariableDistanceConstants.DOUBLE_DISTANCE));
  }

}
