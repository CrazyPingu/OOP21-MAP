package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import logics.strategy.Strategy;
import logics.strategy.concrete_strategies.AsteriskArea;
import logics.strategy.concrete_strategies.VariableDistanceConstants;
import utilis.Pair;

public class AsteriskAreaTest {
	
	private Pair<Integer, Integer> size, pos;
	private Strategy asteriskStrategy = new AsteriskArea(VariableDistanceConstants.SINGLE_DISTANCE);
	private List<Pair<Integer, Integer>> expectedResults = new ArrayList<>();
	
	@org.junit.Before
	public void init() {
		this.size = new Pair<>(9, 5);
		this.expectedResults.clear();
	}
	
	@org.junit.Test
	/**
	 * test of inner area cell choice
	 */
	public void innerGridTest() {
		this.pos = new Pair<>(5,2);
		
		expectedResults.add(new Pair<>(3,0));
		expectedResults.add(new Pair<>(3,2));
		expectedResults.add(new Pair<>(3,4));
		
		expectedResults.add(new Pair<>(5,0));
		expectedResults.add(new Pair<>(5,4));
		
		expectedResults.add(new Pair<>(7,0));
		expectedResults.add(new Pair<>(7,2));
		expectedResults.add(new Pair<>(7,4));
		
		expectedResults.add(new Pair<>(4,1));
		expectedResults.add(new Pair<>(4,2));
		expectedResults.add(new Pair<>(4,3));
		
		expectedResults.add(new Pair<>(5,1));
		expectedResults.add(new Pair<>(5,3));
		
		expectedResults.add(new Pair<>(6,1));
		expectedResults.add(new Pair<>(6,2));
		expectedResults.add(new Pair<>(6,3));
		
		assertEquals(expectedResults, asteriskStrategy.execute(this.pos, this.size));
	}
	
	@org.junit.Test
	/**
	 * test of grid's upper left corner cell choice
	 */
	public void upperLeftCornerTest() {
		this.pos = new Pair<>(0,0);
		
		this.expectedResults.add(new Pair<>(0,2));
		this.expectedResults.add(new Pair<>(2,0));
		this.expectedResults.add(new Pair<>(2,2));
		
		this.expectedResults.add(new Pair<>(0,1));
		this.expectedResults.add(new Pair<>(1,0));
		this.expectedResults.add(new Pair<>(1,1));
		
		assertEquals(expectedResults, asteriskStrategy.execute(this.pos, this.size));
	}
	
	@org.junit.Test
	/**
	 * test of grid's bottom left corner cell choice
	 */
	public void bottomLeftCornerTest() {
		this.pos = new Pair<>(0,4);
		
		this.expectedResults.add(new Pair<>(0,2));
		this.expectedResults.add(new Pair<>(2,2));
		this.expectedResults.add(new Pair<>(2,4));
		
		this.expectedResults.add(new Pair<>(0,3));
		this.expectedResults.add(new Pair<>(1,3));
		this.expectedResults.add(new Pair<>(1,4));
		
		assertEquals(expectedResults, asteriskStrategy.execute(this.pos, this.size));
	}
	
	@org.junit.Test
	/**
	 * test of grid's upper left corner cell choice
	 */
	public void upperRightCornerTest() {
		this.pos = new Pair<>(8,0);
		
		this.expectedResults.add(new Pair<>(6,0));
		this.expectedResults.add(new Pair<>(6,2));
		this.expectedResults.add(new Pair<>(8,2));
		
		this.expectedResults.add(new Pair<>(7,0));
		this.expectedResults.add(new Pair<>(7,1));
		this.expectedResults.add(new Pair<>(8,1));
		
		assertEquals(expectedResults, asteriskStrategy.execute(this.pos, this.size));
	}
	
	@org.junit.Test
	/**
	 * test of grid's upper left corner cell choice
	 */
	public void bottomRightCornerTest() {
		this.pos = new Pair<>(8,4);
		
		this.expectedResults.add(new Pair<>(6,2));
		this.expectedResults.add(new Pair<>(6,4));
		this.expectedResults.add(new Pair<>(8,2));
		
		this.expectedResults.add(new Pair<>(7,3));
		this.expectedResults.add(new Pair<>(7,4));
		this.expectedResults.add(new Pair<>(8,3));
		
		assertEquals(expectedResults, asteriskStrategy.execute(this.pos, this.size));
	}
}
