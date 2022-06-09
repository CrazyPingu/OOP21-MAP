package test;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import model.strategy.Strategy;
import model.strategy.concrete_strategies.CrossArea;
import model.strategy.concrete_strategies.VariableDistanceConstants;
import utilities.Pair;

class CrossAreaTest {
  private Pair<Integer, Integer> size, pos;
  final private Strategy crossArea = new CrossArea(VariableDistanceConstants.SINGLE_DISTANCE);
  final private List<Pair<Integer, Integer>> expectedResults = new ArrayList<>();

  @org.junit.Before
  public void init() {
    this.size = new Pair<>(3, 3);
    this.expectedResults.clear();
  }

  @org.junit.Test
  /**
   * test of inner area cell choice
   */
  public void innerGridTest() {
    this.pos = new Pair<>(1, 1);
    System.out.println(crossArea.execute(this.pos, this.size));
    expectedResults.add(new Pair<>(0, 0));
    expectedResults.add(new Pair<>(0, 1));
    expectedResults.add(new Pair<>(0, 2));
    expectedResults.add(new Pair<>(1, 0));
    expectedResults.add(new Pair<>(1, 2));
    expectedResults.add(new Pair<>(2, 0));
    expectedResults.add(new Pair<>(2, 1));
    expectedResults.add(new Pair<>(2, 2));

    assertEquals(expectedResults, crossArea.execute(this.pos, this.size));
  }

  @org.junit.Test
  /**
   * test of grid's upper left corner cell choice
   */
  public void upperLeftCornerTest() {
    this.pos = new Pair<>(0, 0);
    System.out.println(crossArea.execute(this.pos, this.size));
    this.expectedResults.add(new Pair<>(0, 1));
    this.expectedResults.add(new Pair<>(1, 0));
    this.expectedResults.add(new Pair<>(1, 1));

    assertEquals(expectedResults, crossArea.execute(this.pos, this.size));
  }

  @org.junit.Test
  /**
   * test of grid's bottom left corner cell choice
   */
  public void bottomLeftCornerTest() {
    this.pos = new Pair<>(0, 2);
    System.out.println(crossArea.execute(this.pos, this.size));
    this.expectedResults.add(new Pair<>(0,1));
    this.expectedResults.add(new Pair<>(1,1));
    this.expectedResults.add(new Pair<>(1,2));
    
    assertEquals(expectedResults, crossArea.execute(this.pos, this.size));
  }

  @org.junit.Test
  /**
   * test of grid's upper left corner cell choice
   */
  public void upperRightCornerTest() {
    this.pos = new Pair<>(2, 0);
    System.out.println(crossArea.execute(this.pos, this.size));
    this.expectedResults.add(new Pair<>(1,0));
    this.expectedResults.add(new Pair<>(1,1));
    this.expectedResults.add(new Pair<>(2,1));

    assertEquals(expectedResults, crossArea.execute(this.pos, this.size));
  }

  @org.junit.Test
  /**
   * test of grid's upper left corner cell choice
   */
  public void bottomRightCornerTest() 
  {
    this.pos = new Pair<>(2, 2);
    System.out.println(crossArea.execute(this.pos, this.size));
    this.expectedResults.add(new Pair<>(1,1));
    this.expectedResults.add(new Pair<>(1,2));
    this.expectedResults.add(new Pair<>(2,1));

    assertEquals(expectedResults, crossArea.execute(this.pos, this.size));
  }

}
