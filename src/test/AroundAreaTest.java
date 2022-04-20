package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import logics.strategy.Strategy;
import logics.strategy.concrete_strategies.CrossArea;
import logics.strategy.concrete_strategies.VariableDistanceConstants;
import logics.strategy.concrete_strategies.AroundArea;
import utilis.Pair;

public class AroundAreaTest {
	
	private final Pair<Integer, Integer> size = new Pair<>(7, 6);
	private List<Pair<Integer, Integer>> expectedRes = new ArrayList<>();
	private Pair<Integer, Integer> pos;
	private Strategy strategy = new AroundArea(VariableDistanceConstants.SINGLE_DISTANCE);
	
	@Test
	/*
	 * test the correct result of the algorithm when is chosen a cell in the center
	 * of the grid.
	 */
	void innerAreaTest() {
		System.out.println("In area Test:");
		this.pos = new Pair<>(3, 2);
		System.out.println("pos = " + pos);
		System.out.println(strategy.execute(pos, size));
	}

	@Test
	/*
	 * test the correct result of the algorithm when is chosen a cell in the corner
	 * of the grid.
	 */
	void cornerAreaTest() {
		System.out.println("Corner Test:");
		this.pos = new Pair<>(0, 0);
		System.out.println("pos = " + pos);
		System.out.println("res =");
		System.out.println(strategy.execute(pos, size));

		this.pos = new Pair<>(this.size.getX() - 1, 0);
		System.out.println("pos = " + pos);
		System.out.println("res =");
		System.out.println(strategy.execute(pos, size));

		this.pos = new Pair<>(0, this.size.getY() - 1);
		System.out.println("pos = " + pos);
		System.out.println("res =");
		System.out.println(strategy.execute(pos, size));

		this.pos = new Pair<>(this.size.getX() - 1, this.size.getY() - 1);
		System.out.println("pos = " + pos);
		System.out.println("res =");
		System.out.println(strategy.execute(pos, size));
	}
}