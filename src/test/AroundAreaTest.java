package test;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import model.strategy.Strategy;
import model.strategy.concrete_strategies.AroundArea;
import model.strategy.concrete_strategies.VariableDistanceConstants;
import utilities.Pair;

/**
 * 
 * Test of different cases of position choices with junit of an around area type
 * selectable area.
 *
 */
public class AroundAreaTest {

  private Pair<Integer, Integer> size, pos;
  final private Strategy aroundAreaStrategy = new AroundArea(VariableDistanceConstants.SINGLE_DISTANCE);
  final private List<Pair<Integer, Integer>> expectedResults = new ArrayList<>();

  /**
   * 
   * Initialize the AroundAreaTest
   */
  @org.junit.Before
  public void init() {
    this.size = new Pair<>(3, 3);
    this.expectedResults.clear();
  }

  /**
   * test of inner area cell choice
   */
  @org.junit.Test
  public void innerGridTest() {
    this.pos = new Pair<>(1, 1);

    expectedResults.add(new Pair<>(0, 0));
    expectedResults.add(new Pair<>(0, 1));
    expectedResults.add(new Pair<>(0, 2));
    expectedResults.add(new Pair<>(1, 0));
    expectedResults.add(new Pair<>(1, 2));
    expectedResults.add(new Pair<>(2, 0));
    expectedResults.add(new Pair<>(2, 1));
    expectedResults.add(new Pair<>(2, 2));

    assertEquals(expectedResults, aroundAreaStrategy.execute(this.pos, this.size));
  }

  /**
   * test of grid's upper left corner cell choice
   */
  @org.junit.Test
  public void upperLeftCornerTest() {
    this.pos = new Pair<>(0, 0);
    this.expectedResults.add(new Pair<>(0, 1));
    this.expectedResults.add(new Pair<>(1, 0));
    this.expectedResults.add(new Pair<>(1, 1));

    assertEquals(expectedResults, aroundAreaStrategy.execute(this.pos, this.size));
  }

  /**
   * test of grid's bottom left corner cell choice
   */
  @org.junit.Test
  public void bottomLeftCornerTest() {
    this.pos = new Pair<>(0, 2);
    this.expectedResults.add(new Pair<>(0, 1));
    this.expectedResults.add(new Pair<>(1, 1));
    this.expectedResults.add(new Pair<>(1, 2));

    assertEquals(expectedResults, aroundAreaStrategy.execute(this.pos, this.size));
  }

  /**
   * test of grid's upper left corner cell choice
   */
  @org.junit.Test
  public void upperRightCornerTest() {
    this.pos = new Pair<>(2, 0);
    this.expectedResults.add(new Pair<>(1, 0));
    this.expectedResults.add(new Pair<>(1, 1));
    this.expectedResults.add(new Pair<>(2, 1));

    assertEquals(expectedResults, aroundAreaStrategy.execute(this.pos, this.size));
  }

  /**
   * test of grid's upper left corner cell choice
   */
  @org.junit.Test
  public void bottomRightCornerTest() {
    this.pos = new Pair<>(2, 2);
    this.expectedResults.add(new Pair<>(1, 1));
    this.expectedResults.add(new Pair<>(1, 2));
    this.expectedResults.add(new Pair<>(2, 1));

    assertEquals(expectedResults, aroundAreaStrategy.execute(this.pos, this.size));
  }
}
