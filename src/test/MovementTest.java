package test;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import logics.strategy.concrete_strategies.CrossArea;
import logics.strategy.concrete_strategies.VariableDistanceConstants;
import logics.strategy.concrete_strategies.AroundArea;
import logics.strategy.movement.Movement;
import logics.strategy.movement.MovementImpl;

public class MovementTest {
	private Movement movement; 
	private final int NUMBER_ACTION = 1;  
	@Test
	/*
	 * test the correct creation of a movement class
	 */
	void createMovementTest() {
		this.movement = new MovementImpl(new AroundArea(VariableDistanceConstants.SINGLE_DISTANCE), NUMBER_ACTION);
		assertTrue(this.movement.getActionNumber() == NUMBER_ACTION);
		
		this.movement = new MovementImpl(new CrossArea(VariableDistanceConstants.DOUBLE_DISTANCE), NUMBER_ACTION);
		assertTrue(this.movement.getActionNumber() == NUMBER_ACTION);
	}
	
	
}